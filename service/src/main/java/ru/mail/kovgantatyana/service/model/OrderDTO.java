package ru.mail.kovgantatyana.service.model;

import ru.mail.kovgantatyana.repository.model.OrderStatusEnum;

import java.util.List;

public class OrderDTO {

    private int id;
    private Integer orderNumber;
    private OrderStatusEnum orderStatus;
    private int userId;
    private List<ItemDTO> itemDTOs;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(Integer orderNumber) {
        this.orderNumber = orderNumber;
    }

    public OrderStatusEnum getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatusEnum orderStatus) {
        this.orderStatus = orderStatus;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public List<ItemDTO> getItems() {
        return itemDTOs;
    }

    public void setItems(List<ItemDTO> itemDTOs) {
        this.itemDTOs = itemDTOs;
    }

    @Override
    public String toString(){
        return "ORDER : orderNumber " + orderNumber + ", orderStatus " + orderStatus + ", userId " + userId;
    }
}
