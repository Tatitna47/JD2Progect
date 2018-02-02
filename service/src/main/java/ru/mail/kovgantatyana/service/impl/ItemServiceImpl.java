package ru.mail.kovgantatyana.service.impl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ru.mail.kovgantatyana.repository.ItemDao;
import ru.mail.kovgantatyana.service.ItemService;
import ru.mail.kovgantatyana.service.converter.ItemConverter;
import ru.mail.kovgantatyana.repository.model.Item;
import ru.mail.kovgantatyana.service.model.ItemDTO;

import java.util.ArrayList;
import java.util.List;

@Service("itemService")
public class ItemServiceImpl implements ItemService {
    private static final Logger logger = Logger.getLogger(ItemServiceImpl.class);

    @Autowired
    private ItemDao itemDao;

    @Autowired
    private ItemConverter itemconverter;

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public List<ItemDTO> getItemListAll() {
        List<Item> itemList = itemDao.findAll();
        List<ItemDTO> itemDTOList = new ArrayList<>();
        for (Item item : itemList) {
            itemDTOList.add(itemconverter.convertToItemDTO(item));
        }
        return itemDTOList;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public List<ItemDTO> getItemListByOrder(int orderId) {
        List<Item> itemList = itemDao.getByOrder(orderId);
        List<ItemDTO> itemDTOList = new ArrayList<>();
        for (Item item : itemList) {
            itemDTOList.add(itemconverter.convertToItemDTO(item));
        }
        return itemDTOList;
    }

    @Override
    public void deleteItemFromOrder(int orderId, int itemId) {

    }

    @Override
    public ItemDTO getById(int itemId) {
        Item item = itemDao.findById(itemId);
        ItemDTO itemDTO = itemconverter.convertToItemDTO(item);
        return itemDTO;
    }

    @Override
    public void saveItem(int orderId, int itemId) {

    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void copyByInventoryNumber(int id) {
        Item item = itemDao.findById(id);
        itemDao.clone(item);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void deleteByInventoryNumber(int id) {
        itemDao.softDeleteByInventoryNumber(id);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void saveNewItem(ItemDTO itemDTO) {
        Item item = itemconverter.convertToItem(itemDTO);
        itemDao.save(item);
    }
}
