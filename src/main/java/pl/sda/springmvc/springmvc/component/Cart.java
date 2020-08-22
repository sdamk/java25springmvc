package pl.sda.springmvc.springmvc.component;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import pl.sda.springmvc.springmvc.dto.ProductDTO;
import pl.sda.springmvc.springmvc.service.OrderService;
import pl.sda.springmvc.springmvc.service.ProductService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class Cart {

    private List<ProductDTO> products = new ArrayList<>();

    private final ProductService productService;
    private final OrderService orderService;

    //@Autowired
    public Cart(ProductService productService,
                OrderService orderService) {
        this.productService = productService;
        this.orderService = orderService;
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

    //TODO: To think about this method name
    public void submit() {
        List<Long> collect = products
                .stream()
                .map(ProductDTO::getId)
                .collect(Collectors.toList());
        orderService.createOrder(collect);
        products.clear();
    }
}
