package ru.mail.kovgantatyana.repository.impl;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.mail.kovgantatyana.repository.NewsDao;
import ru.mail.kovgantatyana.repository.model.Comment;
import ru.mail.kovgantatyana.repository.model.News;

import java.util.List;

@Repository("newsdao")
public class NewsDaoImpl implements NewsDao {

    private static final Logger logger = Logger.getLogger(NewsDaoImpl.class);

    private SessionFactory sessionFactory;

    @Autowired
    public NewsDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    private Session currentSession() {
        return sessionFactory.openSession();
    }

    @Override
    public Integer save(News news) {
        Session session = currentSession();
        Transaction transaction = session.beginTransaction();
        logger.info("News for saving " + news.toString());
        session.save(news);
        transaction.commit();
        logger.info(news.toString());
        session.close();
        return null;
    }

    @Override
    public void delete(String newsname) {
        Session session = currentSession();
        Transaction transaction = session.beginTransaction();
        String hql = "DELETE from News as n where n.newsname=:newsname";
        Query query = session.createQuery(hql);
        query.setParameter("newsname", newsname);
        query.executeUpdate();
        logger.info("News for delete " + newsname);
        transaction.commit();
        session.close();
    }

    @Override
    public News getByName(String newsname) {
        Session session = currentSession();
        Transaction transaction = session.beginTransaction();
        String hql = "from News n where n.newsname=:newsname";
        Query query = session.createQuery(hql);
        query.setParameter("newsname", newsname);
        News news = (News) query.uniqueResult();
        logger.info("News by name " + news.toString());
        transaction.commit();
        session.close();
        return news;
    }

    @Override
    public void deleteComment(String comment, String newsname) {
        Session session = currentSession();
        Transaction transaction = session.beginTransaction();
        String hql = "DELETE from Comment c where c.message=:message and c.news.id in (select n from news n where n.newsname=:newsname)";
        Query query = session.createQuery(hql);
        query.setParameter("message", comment);
        query.setParameter("newsname", newsname);
        query.executeUpdate();
        logger.info("News for delete : comment " + comment + ", newsname " + newsname);
        transaction.commit();
        session.close();
    }

    @Override
    public void deleteComment(int userId) {
        Session session = currentSession();
        Transaction transaction = session.beginTransaction();
        String hql = "DELETE from Comment c where c.user.id in (select u from user u where u.id=:id)";
        Query query = session.createQuery(hql);
        query.setParameter("id", userId);
        query.executeUpdate();
        logger.info("News for delete : userId " + userId);
        transaction.commit();
        session.close();
    }

    @Override
    public void saveOrUpdate(News entity) {
    }

    @Override
    public void deleteAll() {

    }

    @Override
    public List<News> findAll() {
        Session session = currentSession();
        Transaction transaction = session.beginTransaction();
        String hql = "from News";
        Query query = session.createQuery(hql);
        transaction.commit();
        List<News> newsList = query.list();
        for (News news : newsList) {
            logger.info("News from repository getAll(): " + news.toString());
        }
        session.close();
        return newsList;
    }

    @Override
    public News findById(Integer newsId) {
        Session session = currentSession();
        Transaction transaction = session.beginTransaction();
        String hql = "from News n where n.id=:id";
        Query query = session.createQuery(hql);
        query.setParameter("id", newsId);
        News news = (News) query.uniqueResult();
        //logger.info("News by id " + news.toString());
        transaction.commit();
        session.close();
        return news;
    }

    @Override
    public void delete(News news) {
    }

    @Override
    public void addComment(Comment comment){
        Session session = currentSession();
        Transaction transaction = session.beginTransaction();
        session.save(comment);
        transaction.commit();
        session.close();
        logger.info(comment.toString());
    }
}