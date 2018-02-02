package ru.mail.kovgantatyana.controller.user;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.mail.kovgantatyana.service.ItemService;
import ru.mail.kovgantatyana.service.OrderService;
import ru.mail.kovgantatyana.service.model.ItemDTO;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class UserItemController {
    private static final Logger logger = Logger.getLogger(UserItemController.class);

    @Autowired
    private ItemService itemService;

    @Autowired
    private OrderService orderService;

    @GetMapping(value = "/user/item/all")
    public String showItemAll(Model model) {
        List<ItemDTO> itemDTOList = itemService.getItemListAll();
        model.addAttribute("itemDTOList", itemDTOList);
        return "user/item/all";
    }

    @PostMapping(value = "/user/item/add")
    public String addItemToBasket(
            @RequestParam("itemId") int itemId,
            HttpSession session,
            Model model) {
        ItemDTO itemDTO = itemService.getById(itemId);
        List<ItemDTO> basket = (List<ItemDTO>) session.getAttribute("basket");
        basket.add(itemDTO);
        return "redirect:/user/item/all";
    }

    @GetMapping(value = "/user/basket")
    public String showBasket(
            HttpSession session,
            Model model) {
        List<ItemDTO> basket = (List<ItemDTO>) session.getAttribute("basket");
        model.addAttribute("basket", basket);
        return "user/basket/basket";
    }

    @PostMapping(value = "/user/basket/delete")
    public String deleteItemFromBasket(
            @RequestParam("itemId") int itemId,
            HttpSession session,
            Model model) {
        List<ItemDTO> basket = (List<ItemDTO>) session.getAttribute("basket");
        for (ItemDTO itemDTO : basket) {
            if (itemDTO.getId() == itemId) {
                basket.remove(itemDTO);
                break;
            }
        }
        return "redirect:/user/basket";
    }

    @PostMapping(value = "/user/item/delete")
    public String deleteFromBasket(
            @RequestParam("itemId") int itemId,
            HttpSession session,
            Model model) {
        List<ItemDTO> basket = (List<ItemDTO>) session.getAttribute("basket");
        for (ItemDTO itemDTO : basket) {
            if (itemDTO.getId() == itemId) {
                basket.remove(itemDTO);
                break;
            }
        }
        return "redirect:/user/basket";
    }

}
