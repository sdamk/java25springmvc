package pl.sda.springmvc.springmvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.sda.springmvc.springmvc.entity.Product;

import java.util.Set;

public interface ProductRepository
        extends JpaRepository<Product, Long> {

    Set<Product> findAllByIdIn(Set<Long> ids);
}
