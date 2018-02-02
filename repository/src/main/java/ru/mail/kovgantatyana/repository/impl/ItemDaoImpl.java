package ru.mail.kovgantatyana.repository.impl;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.mail.kovgantatyana.repository.ItemDao;
import ru.mail.kovgantatyana.repository.model.Item;

import java.util.List;

@Repository
public class ItemDaoImpl implements ItemDao {
    private static final Logger logger = Logger.getLogger(ItemDaoImpl.class);

    private SessionFactory sessionFactory;

    @Autowired
    public ItemDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    private Session currentSession() {
        return sessionFactory.openSession();
    }

    @Override
    public Integer save(Item item) {
        Session session = currentSession();
        Transaction transaction = session.beginTransaction();
        session.save(item);
        transaction.commit();
        logger.info("saved object " + item.toString());
        return null;
    }

    @Override
    public void delete(Item item) {
        int itemId = item.getId();
        Session session = currentSession();
        Transaction transaction = session.beginTransaction();
        String hql = "delete from Item I where I.id=:itemId";
        Query query = session.createQuery(hql);
        query.setParameter("itemId", itemId);
        query.executeUpdate();
        transaction.commit();
        logger.info("Delete item " + item.toString());
    }

    @Override
    public List<Item> findAll() {
        Session session = currentSession();
        Transaction transaction = session.beginTransaction();
        String hql = "select I from Item as I where I.itemStatusEnum=0";
        Query query = session.createQuery(hql);
        transaction.commit();
        List<Item> itemList = query.list();
        logger.info("All active items " + itemList.toString());
        return itemList;
    }

    @Override
    public List<Item> getByOrder(int orderId) {
        Session session = currentSession();
        Transaction transaction = session.beginTransaction();
        String hql = "select I from Item I join I.orber as O where O.id=:orderId";
        Query query = session.createQuery(hql);
        query.setParameter("orderId", orderId);
        transaction.commit();
        List<Item> itemList = query.list();
        logger.info("Items for order : orderId "+ orderId + ", itemList " + itemList);
        return itemList;
    }

    @Override
    public void softDeleteByInventoryNumber(int id) {
        Session session = currentSession();
        Transaction transaction = session.beginTransaction();
        String hql = "update Item as I set I.itemStatusEnum = 1 where I.id=:id";
        Query query = session.createQuery(hql);
        query.setParameter("id", id);
        query.executeUpdate();
        transaction.commit();
        logger.info("SoftDelete item : id " + id);
    }

    @Override
    public void clone(Item item) {
        Session session = currentSession();
        Transaction transaction = session.beginTransaction();
       // session.evict(item);
        session.save(item);
        transaction.commit();
        logger.info("clone object " + item.toString());
    }


    @Override
    public Item findById(Integer userId) {
        Session session = currentSession();
        Transaction transaction = session.beginTransaction();
        String hql = "select I from Item I where I.id=:id";
        Query query = session.createQuery(hql);
        query.setParameter("id", userId);
        Item item = (Item) query.uniqueResult();
        transaction.commit();
        logger.info("Get item : id " + userId);
        return item;
    }

    @Override
    public void deleteAll() {

    }

    @Override
    public void saveOrUpdate(Item entity) {

    }
}
