package ru.mail.kovgantatyana.repository;

import javax.persistence.Id;
import java.io.Serializable;
import java.util.List;

public interface GenericDao<T extends Serializable, ID extends Serializable> {

    ID save(T entity);

    void saveOrUpdate(T entity);

    void delete(T entity);

    void deleteAll();

    List<T> findAll();

    T findById(ID id);
}
