package pl.sda.springmvc.springmvc.service;

import org.springframework.stereotype.Service;
import pl.sda.springmvc.springmvc.dto.OrderDTO;
import pl.sda.springmvc.springmvc.dto.ProductDTO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class OrderService {
    private Map<Long, OrderDTO> orders = new HashMap<>();

    private final ProductService productService;

    public OrderService(ProductService productService) {
        this.productService = productService;
    }

    public void createOrder(List<Long> productIDs) {
        List<ProductDTO> collect = productIDs
                .stream()
                .map(productService::getProductById)
                .collect(Collectors.toList());
        OrderDTO orderDTO = new OrderDTO(collect);
        orders.put(orderDTO.getId(), orderDTO);
    }

    public List<OrderDTO> getOrders() {
        return new ArrayList<>(orders.values());
    }

    public OrderDTO getOrderById(long idProduct) {
        return orders.get(idProduct);
    }
}
