package pl.sda.springmvc.springmvc.dto;

import lombok.Getter;

import java.util.List;

public class OrderDTO {

    private static long count;

    @Getter
    private long id;
    @Getter
    private List<ProductDTO> products;

    public OrderDTO(List<ProductDTO> products) {
        this.id = ++count;
        this.products = products;
    }
}
