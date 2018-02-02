package ru.mail.kovgantatyana.repository.impl;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.mail.kovgantatyana.repository.NewsDao;
import ru.mail.kovgantatyana.repository.OrderDao;
import ru.mail.kovgantatyana.repository.UserDao;
import ru.mail.kovgantatyana.repository.model.Comment;
import ru.mail.kovgantatyana.repository.model.FeedBack;
import ru.mail.kovgantatyana.repository.model.Role;
import ru.mail.kovgantatyana.repository.model.User;
import ru.mail.kovgantatyana.repository.model.UserStatusEnum;

import java.util.List;

@Repository("userdao")
public class UserDaoImpl implements UserDao {
    private static final Logger logger = Logger.getLogger(UserDaoImpl.class);

    @Autowired
    private NewsDao newsDao;

    @Autowired
    private OrderDao orderDao;

    private SessionFactory sessionFactory;

    public UserDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    private Session currentSession() {
        return sessionFactory.openSession();
    }

    @Override
    public User getByName(String username) {
        Session session = currentSession();
        Transaction transaction = session.beginTransaction();
        String hql = "select u from User u WHERE u.username=:username";
        Query query = session.createQuery(hql);
        query.setParameter("username", username);
        User user = (User) query.uniqueResult();
        transaction.commit();
        session.close();
        return user;
    }

    @Override
    public Integer save(User entity) {
        return null;
    }

    @Override
    public void delete(int userId){
        newsDao.deleteComment(userId);
        orderDao.deleteByUserId(userId);
        Session session = currentSession();
        Transaction transaction = session.beginTransaction();
        String hql = "DELETE from User as u where u.id=:userId";
        Query query = session.createQuery(hql);
        query.setParameter("userId", userId);
        query.executeUpdate();
        logger.info("User for delete by id: id " + userId);
        transaction.commit();
        session.close();
    }

    @Override
    public void changeStatus(int userId, UserStatusEnum status){
        Session session = currentSession();
        Transaction transaction = session.beginTransaction();
        String hql = "update User as u set u.status =:status where u.id=:id";
        Query query = session.createQuery(hql);
        query.setParameter("status", status);
        query.setParameter("id", userId);
        query.executeUpdate();
        transaction.commit();
        session.close();
        logger.info("ChangeStatus user : id " + userId + ", status " + status);
    }

    @Override
    public void changeRole(int userId, Role role){
        Session session = currentSession();
        Transaction transaction = session.beginTransaction();
        String hql = "update User as u set u.role =:role where u.id=:id";
        Query query = session.createQuery(hql);
        query.setParameter("role", role);
        query.setParameter("id", userId);
        query.executeUpdate();
        transaction.commit();
        session.close();
        logger.info("ChangeRole user : id " + userId + ", role " + role);
    }

    @Override
    public void changePassword(int userId, String password){
        Session session = currentSession();
        Transaction transaction = session.beginTransaction();
        String hql = "update User as u set u.password=:password where u.id=:id";
        Query query = session.createQuery(hql);
        query.setParameter("password", password);
        query.setParameter("id", userId);
        query.executeUpdate();
        transaction.commit();
        session.close();
        logger.info("ChangePassword user : id " + userId + ", password " + password);
    }

    @Override
    public void saveOrUpdate(User user) {
        Session session = currentSession();
        Transaction transaction = session.beginTransaction();
        session.saveOrUpdate(user);
        transaction.commit();
        session.close();
        logger.info("User fo update " + user.toString());
    }

    @Override
    public void addFeedback(FeedBack feedBack){
        Session session = currentSession();
        Transaction transaction = session.beginTransaction();
        session.saveOrUpdate(feedBack);
        transaction.commit();
        session.close();
        logger.info("Feedback fo add " + feedBack.toString());
    }

    @Override
    public void delete(User entity) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public List<Comment> getComments(int userId){
        Session session = currentSession();
        Transaction transaction = session.beginTransaction();
        String hql = "from Comment c join c.user u where u.id=:userId";
        Query query = session.createQuery(hql);
        query.setParameter("userId", userId);
        List<Comment> commentList = query.list();
        transaction.commit();
        session.close();
        return commentList;
    }

    @Override
    public List<User> findAll() {
        Session session = currentSession();
        Transaction transaction = session.beginTransaction();
        String hql = "from User";
        Query query = session.createQuery(hql);
        transaction.commit();
        List<User> userList = query.list();
        session.close();
        for (User user : userList) {
            logger.info("All users from repository : " + user.toString());
        }
        return userList;
    }

    @Override
    public User findById(Integer integer) {
        Session session = currentSession();
        Transaction transaction = session.beginTransaction();
        String hql = "from User u where u.id=:id";
        Query query = session.createQuery(hql);
        query.setParameter("id", integer);
        User user = (User) query.uniqueResult();
        logger.info("User by id " + user.toString());
        transaction.commit();
        session.close();
        return user;
    }
}
