package ru.mail.kovgantatyana.service;

import ru.mail.kovgantatyana.service.model.OrderDTO;
import ru.mail.kovgantatyana.repository.model.OrderStatusEnum;
import ru.mail.kovgantatyana.service.model.UserDTO;

import java.util.List;

public interface OrderService {

    List<OrderDTO> getOrderDTOsByUserDTO(UserDTO userDTO);

    List<OrderDTO> getOrderByUserId(int userId);

    List<OrderDTO> getAll();

    void deleteOrder(int orderId);

    void setOrderStatus(int orderId, OrderStatusEnum statusEnum);

    void saveOrder(OrderDTO orderDTO);

    OrderDTO getById(int orderId);

    void update(OrderDTO orderDTO);
}
