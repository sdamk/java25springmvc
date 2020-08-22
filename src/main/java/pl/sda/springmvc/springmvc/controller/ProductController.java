package pl.sda.springmvc.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import pl.sda.springmvc.springmvc.dto.NewProductDTO;
import pl.sda.springmvc.springmvc.service.ProductService;

@Controller
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @RequestMapping
    ModelAndView productsPage() {
        ModelAndView mnv = new ModelAndView("products");
        mnv.addObject("products", productService.getProducts());
        mnv.addObject("newProduct", new NewProductDTO());
        return mnv;
    }

    //@PostMapping
    @RequestMapping(method = RequestMethod.POST)
    String addNewProduct(NewProductDTO productDTO) {
        productService.addProduct(productDTO);
        return "redirect:/products";
    }

    @RequestMapping("/{idProduct}")
    ModelAndView productDetailsPage(@PathVariable("idProduct") long id){
        ModelAndView mnv = new ModelAndView("details");
        mnv.addObject("product", productService.getProductById(id));
        return mnv;
    }
}
