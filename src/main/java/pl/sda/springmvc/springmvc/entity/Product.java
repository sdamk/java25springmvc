package pl.sda.springmvc.springmvc.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    @ManyToMany(mappedBy = "products")
    private Set<Order> orders = new HashSet<>();

    public Product(String name) {
        this.name = name;
    }
}

