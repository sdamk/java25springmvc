package pl.sda.springmvc.springmvc.dto;

public class ProductDTO {
    private long id;
    private String name;

    public ProductDTO(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
