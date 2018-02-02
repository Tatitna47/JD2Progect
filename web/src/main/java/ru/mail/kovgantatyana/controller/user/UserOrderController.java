package ru.mail.kovgantatyana.controller.user;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.mail.kovgantatyana.service.OrderService;
import ru.mail.kovgantatyana.service.model.ItemDTO;
import ru.mail.kovgantatyana.service.model.OrderDTO;
import ru.mail.kovgantatyana.repository.model.OrderStatusEnum;
import ru.mail.kovgantatyana.service.model.UserDTO;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class UserOrderController {
    private static final Logger logger = Logger.getLogger(UserOrderController.class);

    @Autowired
    private OrderService orderService;

    @GetMapping(value = "/user/order/all")
    public String showOrder(
            HttpSession session,
            Model model) {
        UserDTO userDTO = (UserDTO) session.getAttribute("userDTO");
        List<OrderDTO> orderDTOList = orderService.getOrderByUserId(userDTO.getId());
        model.addAttribute("orderDTOList", orderDTOList);
        return "user/order/all";
    }

    @PostMapping(value = "/user/order/update")
    public String update(
            @RequestParam("orderId") int orderId,
            Model model) {
        OrderDTO orderDTO = orderService.getById(orderId);
        orderService.update(orderDTO);
        return "redirect:/user/order/all";
    }

    @GetMapping(value = "/user/order/new")
    public String makeOrder(
            HttpSession session,
            Model model) {
        List<ItemDTO> basket = (List<ItemDTO>) session.getAttribute("basket");
        if (basket.size() > 0) {
            UserDTO userDTO = (UserDTO) session.getAttribute("userDTO");
            OrderDTO orderDTO = new OrderDTO();
            orderDTO.setOrderStatus(OrderStatusEnum.NEW);
            orderDTO.setItems(basket);
            orderDTO.setUserId(userDTO.getId());
            orderService.saveOrder(orderDTO);
            return "redirect:/user/order/all";
        }
        return "redirect:/user/order/all";
    }
}
