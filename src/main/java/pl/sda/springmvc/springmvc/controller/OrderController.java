package pl.sda.springmvc.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import pl.sda.springmvc.springmvc.service.OrderService;

@Controller
@RequestMapping("/orders")
class OrderController {

    private final OrderService orderService;

    OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @RequestMapping
    ModelAndView ordersPage() {
        ModelAndView mnv = new ModelAndView("orders");
        mnv.addObject("orders", orderService.getOrders());
        return mnv;
    }
}
