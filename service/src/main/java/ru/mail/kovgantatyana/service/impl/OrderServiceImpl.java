package ru.mail.kovgantatyana.service.impl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ru.mail.kovgantatyana.repository.OrderDao;
import ru.mail.kovgantatyana.service.OrderService;
import ru.mail.kovgantatyana.service.converter.OrderConverter;
import ru.mail.kovgantatyana.repository.model.Order;
import ru.mail.kovgantatyana.service.model.OrderDTO;
import ru.mail.kovgantatyana.repository.model.OrderStatusEnum;
import ru.mail.kovgantatyana.service.model.UserDTO;

import java.util.ArrayList;
import java.util.List;

@Service("orderService")
public class OrderServiceImpl implements OrderService {

    private static final Logger logger = Logger.getLogger(OrderServiceImpl.class);

    @Autowired
    private OrderDao orderDao;

    @Autowired
    private OrderConverter orderConverter;

    @Override
    public List<OrderDTO> getOrderDTOsByUserDTO(UserDTO userDTO) {
        return null;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public List<OrderDTO> getOrderByUserId(int userId){
        List<Order> orderList = orderDao.findByUserId(userId);
        List<OrderDTO> orderDTOList = new ArrayList<>();
        for (Order order:orderList){
            orderDTOList.add(orderConverter.convertToDTO(order));
        }
        return orderDTOList;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public List<OrderDTO> getAll() {
        List<Order> orderList = orderDao.findAll();
        List<OrderDTO> orderDTOList = new ArrayList<>();
        for (Order order : orderList) {
            orderDTOList.add(orderConverter.convertToDTO(order));
        }
        return orderDTOList;
    }

    @Override
    public void deleteOrder(int orderId) {

    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void setOrderStatus(int orderId, OrderStatusEnum statusEnum) {
        orderDao.changeStatus(orderId, statusEnum);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void saveOrder(OrderDTO orderDTO) {
        Order order = orderConverter.convertToOrder(orderDTO);
        orderDao.save(order);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public OrderDTO getById(int orderId) {
        Order order = (Order) orderDao.findById(orderId);
        OrderDTO orderDTO = orderConverter.convertToDTO(order);
        return orderDTO;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void update(OrderDTO orderDTO){
        Order order = orderConverter.convertToOrder(orderDTO);
        orderDao.saveOrUpdate(order);
    }
}
