package pl.sda.springmvc.springmvc.controller;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.configurers.SessionManagementConfigurer;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import pl.sda.springmvc.springmvc.component.Cart;

import java.security.Principal;

@Controller
@RequestMapping("/cart")
class CartController {

    private final Cart cart;

    CartController(Cart cart) {
        this.cart = cart;
    }

    @RequestMapping
    ModelAndView cartPage() {
        ModelAndView mnv = new ModelAndView("cart");
        mnv.addObject("products", cart.getProducts());
        return mnv;
    }

    //Trick: Get method changes system state
    @GetMapping("/addProduct")
    //@RequestMapping(value = "/addProduct")
    String addProductToCart(@RequestParam("id") long idProduct) {
        cart.addProduct(idProduct);
        return "redirect:/cart";
    }

    @GetMapping("/makeOrder")
    String makeOrder(Principal principal) {
        System.out.println(principal.getName());
        //SecurityContextHolder.getContext().getAuthentication().getName();
        cart.submit();
        return "redirect:/orders";
    }
}

