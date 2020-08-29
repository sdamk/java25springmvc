package pl.sda.springmvc.springmvc.dto;

import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;
@Getter
public class OrderDTO {

    private long id;
    private LocalDateTime localDateTime;
    private List<ProductDTO> products;

    public OrderDTO(long id, LocalDateTime ldt, List<ProductDTO> products) {
        this.id = id;
        this.localDateTime = ldt;
        this.products = products;
    }
}
