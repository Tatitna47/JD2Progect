package ru.mail.kovgantatyana.repository.impl;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.mail.kovgantatyana.repository.OrderDao;
import ru.mail.kovgantatyana.repository.model.Order;
import ru.mail.kovgantatyana.repository.model.OrderStatusEnum;

import java.io.Serializable;
import java.util.List;

@Repository("orderDao")
public class OrderDaoImpl implements OrderDao {
    private static final Logger logger = Logger.getLogger(OrderDaoImpl.class);

    private SessionFactory sessionFactory;

    @Autowired
    public OrderDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    private Session currentSession() {
        return sessionFactory.openSession();
    }

    @Override
    public Serializable save(Serializable order) {
        Session session = currentSession();
        Transaction transaction = session.beginTransaction();
        session.save(order);
        transaction.commit();
        session.close();
        return null;
    }

    @Override
    public void saveOrUpdate(Serializable order) {
        Session session = currentSession();
        Transaction transaction = session.beginTransaction();
        session.saveOrUpdate(order);
        transaction.commit();
        session.close();
    }

    @Override
    public void delete(Serializable entity) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public List<Order> findAll() {
        Session session = currentSession();
        Transaction transaction = session.beginTransaction();
        String hql = "from Order";
        Query query = session.createQuery(hql);
        transaction.commit();
        List<Order> orderList = query.list();
        for (Order order : orderList) {
            logger.info("All orders from repository : " + order.toString());
        }
        return orderList;
    }

    @Override
    public Serializable findById(Serializable orderId) {
        Session session = currentSession();
        Transaction transaction = session.beginTransaction();
        String hql = "select O from Order O where O.id=:id";
        Query query = session.createQuery(hql);
        query.setParameter("id", orderId);
        Order order = (Order) query.uniqueResult();
        transaction.commit();
        logger.info("Get orger : id " + orderId);
        return order;
    }

    @Override
    public void deleteByUserId(int userId){
        Session session = currentSession();
        Transaction transaction = session.beginTransaction();
        String hql = "DELETE from Order o where o.user.id in (select u from user u where u.id=:id)";
        Query query = session.createQuery(hql);
        query.setParameter("id", userId);
        query.executeUpdate();
        logger.info("Oreder for delete : userId " + userId);
        transaction.commit();
    }

    @Override
    public List<Order> findByUserId(int userId) {
        Session session = currentSession();
        Transaction transaction = session.beginTransaction();
        String hql = "select o from Order o join o.user u where u.id=:userId";
        Query query = session.createQuery(hql);
        query.setParameter("userId", userId);
        transaction.commit();
        List<Order> orderList = query.list();
        for (Order order : orderList) {
            logger.info("Orders from repository by userId : " + order.toString());
        }
        return orderList;
    }

    @Override
    public void changeStatus(int orderId, OrderStatusEnum orderStatus) {
        Session session = currentSession();
        Transaction transaction = session.beginTransaction();
        String hql = "update Order as o set o.orderStatus =:orderStatus where o.id=:id";
        Query query = session.createQuery(hql);
        query.setParameter("orderStatus", orderStatus);
        query.setParameter("id", orderId);
        query.executeUpdate();
        transaction.commit();
        logger.info("ChangeStatus order : id " + orderId + ", status " + orderStatus);
    }
}
