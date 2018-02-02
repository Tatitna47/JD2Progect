package ru.mail.kovgantatyana.service;

import ru.mail.kovgantatyana.service.model.ItemDTO;

import java.util.List;

public interface ItemService {

    List<ItemDTO> getItemListAll();

    List<ItemDTO> getItemListByOrder(int orderId);

    void deleteItemFromOrder(int orderId, int itemId);

    ItemDTO getById(int itemId);

    void saveItem(int orderId, int itemId);

    void copyByInventoryNumber(int id);

    void deleteByInventoryNumber(int id);

    void saveNewItem(ItemDTO itemDTO);
}
