package ru.mail.kovgantatyana.repository;

import ru.mail.kovgantatyana.repository.GenericDao;
import ru.mail.kovgantatyana.repository.model.Item;

import java.util.List;

public interface ItemDao extends GenericDao<Item, Integer> {
    List<Item> getByOrder(int orderId);

    void softDeleteByInventoryNumber(int id);

    void clone(Item item);
}
