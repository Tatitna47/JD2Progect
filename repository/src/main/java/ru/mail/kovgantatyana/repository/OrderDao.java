package ru.mail.kovgantatyana.repository;

import ru.mail.kovgantatyana.repository.GenericDao;
import ru.mail.kovgantatyana.repository.model.Order;
import ru.mail.kovgantatyana.repository.model.OrderStatusEnum;

import java.util.List;

public interface OrderDao extends GenericDao {

    void deleteByUserId(int userId);

    List<Order> findByUserId(int userId);

    void changeStatus(int orderId, OrderStatusEnum orderStatusEnum);
}
