package ru.mail.kovgantatyana.controller.superadmin;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.mail.kovgantatyana.service.ItemService;
import ru.mail.kovgantatyana.service.model.ItemDTO;

import java.util.List;

@Controller
public class SuperAdminItemController {
    private static final Logger logger = Logger.getLogger(SuperAdminItemController.class);

    @Autowired
    private ItemService itemService;


    @GetMapping(value = "superadmin/item/all")
    public String showItems(Model model) {
        List<ItemDTO> itemDTOList = itemService.getItemListAll();
        model.addAttribute("itemDTOList", itemDTOList);
        return "superadmin/item/all";
    }

    @GetMapping(value = "superadmin/item/add")
    public String showFormItem(Model model) {
        return "superadmin/item/add";
    }

    @PostMapping(value = "superadmin/item/add")
    public String addItem(
            @RequestParam("number") int inventoryNumber,
            @RequestParam("name") String name,
            @RequestParam("description") String description,
            @RequestParam("price") float price,
            Model model) {
        ItemDTO itemDTO = new ItemDTO();
        itemDTO.setPrice(price);
        itemDTO.setInventoryNumber(inventoryNumber);
        itemDTO.setDescription(description);
        itemDTO.setItemName(name);
        itemService.saveNewItem(itemDTO);
        return "redirect:/superadmin/item/all";
    }

    @PostMapping(value = "superadmin/item/delete")
    public String deleteItem(
            @RequestParam("id") int id,
            Model model) {
        itemService.deleteByInventoryNumber(id);
        return "redirect:/superadmin/item/all";
    }

    @PostMapping(value = "superadmin/item/copy")
    public String copyItem(
            @RequestParam("id") int id,
                           Model model) {
        itemService.copyByInventoryNumber(id);
        return "redirect:/superadmin/item/all";
    }
}
