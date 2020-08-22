package pl.sda.springmvc.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import pl.sda.springmvc.springmvc.component.Cart;

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
}
