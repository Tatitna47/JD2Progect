package ru.mail.kovgantatyana.service.converter;

import org.springframework.stereotype.Component;
import ru.mail.kovgantatyana.repository.model.Item;
import ru.mail.kovgantatyana.service.model.ItemDTO;
import ru.mail.kovgantatyana.repository.model.ItemStatusEnum;

@Component("itemconverter")
public class ItemConverter {

    public Item convertToItem(ItemDTO itemDTO) {
        Item item = new Item();
        item.setItemName(itemDTO.getItemName());
        item.setDescription(itemDTO.getDescription());
        item.setInventoryNumber(itemDTO.getInventoryNumber());
        item.setPrice(itemDTO.getPrice());
        item.setItemStatusEnum(ItemStatusEnum.NOT_DELETE);
        return item;
    }

    public ItemDTO convertToItemDTO(Item item) {
        ItemDTO itemDTO = new ItemDTO();
        itemDTO.setId(item.getId());
        itemDTO.setItemName(item.getItemName());
        itemDTO.setDescription(item.getDescription());
        itemDTO.setInventoryNumber(item.getInventoryNumber());
        itemDTO.setPrice(item.getPrice());
        return itemDTO;
    }

}
