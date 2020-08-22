package pl.sda.springmvc.springmvc.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.sda.springmvc.springmvc.dto.ProductDTO;
import pl.sda.springmvc.springmvc.service.ProductService;

import java.util.ArrayList;
import java.util.List;

@Component
public class Cart {

    private List<ProductDTO> products = new ArrayList<>();

    private final ProductService productService;

    //@Autowired
    public Cart(ProductService productService) {
        this.productService = productService;
    }

    public void addProduct(long idProduct) {
        ProductDTO productById = productService.getProductById(idProduct);
        products.add(productById);
    }

    public void removeProduct() {

    }

    public List<ProductDTO> getProducts() {
        return products;
    }

    public void submit() {

    }
}
