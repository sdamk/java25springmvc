package pl.sda.springmvc.springmvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.sda.springmvc.springmvc.entity.Order;

public interface OrderRepository
        extends JpaRepository<Order, Long> {
}
