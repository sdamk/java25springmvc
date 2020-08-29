package pl.sda.springmvc.springmvc.service;

import org.springframework.stereotype.Service;
import pl.sda.springmvc.springmvc.dto.OrderDTO;
import pl.sda.springmvc.springmvc.entity.Order;
import pl.sda.springmvc.springmvc.entity.Product;
import pl.sda.springmvc.springmvc.exception.ProductNotFoundException;
import pl.sda.springmvc.springmvc.repository.OrderRepository;
import pl.sda.springmvc.springmvc.repository.ProductRepository;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

@Service
public class OrderService {
    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;

    public OrderService(OrderRepository orderRepository,
                        ProductRepository productRepository) {
        this.orderRepository = orderRepository;
        this.productRepository = productRepository;
    }

    public void createOrder(Set<Long> productIDs) {
        Set<Product> products = productRepository
                .findAllByIdIn(productIDs);

        Order order = new Order(products);
        orderRepository.save(order);
    }

    public List<OrderDTO> getOrders() {
        return orderRepository
                .findAll()
                .stream()
                // FIX ME: null
                .map(order -> new OrderDTO(order.getId(), order.getCreateTime(), null))
                .collect(toList());
    }

    public OrderDTO getOrderById(long idProduct) {
        return orderRepository
                .findById(idProduct)
                .map(order -> new OrderDTO(order.getId(), order.getCreateTime(), null))
                .orElseThrow(() -> new ProductNotFoundException(idProduct));
    }
}
