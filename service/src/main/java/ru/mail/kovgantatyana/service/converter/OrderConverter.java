package ru.mail.kovgantatyana.service.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.mail.kovgantatyana.service.UserService;
import ru.mail.kovgantatyana.repository.model.Item;
import ru.mail.kovgantatyana.service.model.ItemDTO;
import ru.mail.kovgantatyana.repository.model.Order;
import ru.mail.kovgantatyana.service.model.OrderDTO;

import java.util.ArrayList;
import java.util.List;

@Component("orderConverter")
public class OrderConverter {

    @Autowired
    private ItemConverter itemConverter;

    @Autowired
    private UserService userService;

    public OrderDTO convertToDTO(Order order) {
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setId(order.getId());
        orderDTO.setUserId(order.getUser().getId());
        orderDTO.setOrderNumber(order.getOrderNumber());
        orderDTO.setOrderStatus(order.getOrderStatus());
        List<ItemDTO> itemListDTO = new ArrayList<>();
        List<Item> itemList = order.getItems();
        for (Item item : itemList) {
            itemListDTO.add(itemConverter.convertToItemDTO(item));
        }
        orderDTO.setItems(itemListDTO);
        return orderDTO;
    }

    public Order convertToOrder(OrderDTO orderDTO) {
        Order order = new Order();
        order.setOrderStatus(orderDTO.getOrderStatus());
        order.setUser(userService.getUserById(orderDTO.getUserId()));
        List<Item> itemList = new ArrayList<>();
        List<ItemDTO> itemDTOList = orderDTO.getItems();
        for (ItemDTO itemDTO : itemDTOList) {
            itemList.add(itemConverter.convertToItem(itemDTO));
        }
        order.setItems(itemList);
        return order;
    }

}
