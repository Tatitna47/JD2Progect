package ru.mail.kovgantatyana.controller.admin;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.mail.kovgantatyana.service.OrderService;
import ru.mail.kovgantatyana.service.model.OrderDTO;
import ru.mail.kovgantatyana.repository.model.OrderStatusEnum;

import java.util.List;

@Controller
public class AdminOrderController {

    private static final Logger logger = Logger.getLogger(AdminOrderController.class);

    @Autowired
    private OrderService orderService;

    @GetMapping(value = "admin/order/all")
    public String showOrders(Model model) {
        List<OrderDTO> orderDTOList = orderService.getAll();
        model.addAttribute("orderDTOList", orderDTOList);
        return "admin/order/all";
    }

    @PostMapping(value = "admin/order/all")
    public String changeOrderStatus(
            @RequestParam("orderstatus") OrderStatusEnum orderStatus,
            @RequestParam("orderId") int orderId,
            Model model){
        logger.info("orderStatus " + orderStatus + ", orderId " + orderId);
        orderService.setOrderStatus(orderId, orderStatus);
        return "redirect:/admin/order/all";
    }

}
