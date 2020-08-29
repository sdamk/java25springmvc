package pl.sda.springmvc.springmvc.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Getter
@Entity
@Table(name = "ORDER_")
@NoArgsConstructor
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private LocalDateTime createTime = LocalDateTime.now();

    @ManyToMany
    Set<Product> products = new HashSet<>();

    public Order(Set<Product> products) {
        this.products = products;
    }
}
