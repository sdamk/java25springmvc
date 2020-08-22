package pl.sda.springmvc.springmvc.service;

import org.springframework.stereotype.Service;
import pl.sda.springmvc.springmvc.dto.NewProductDTO;
import pl.sda.springmvc.springmvc.dto.ProductDTO;
import pl.sda.springmvc.springmvc.exception.ProductNotFoundException;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    private static long count = 0;

    private List<ProductDTO> products = new ArrayList<>();
    {
        products.add(new ProductDTO(++count, "Product 1"));
        products.add(new ProductDTO(++count, "Product 2"));
    }
    public List<ProductDTO> getProducts() {
        return products;
    }

    public void addProduct(NewProductDTO newProductDTO) {
        ProductDTO productDTO = new ProductDTO(++count, newProductDTO.getName());
        products.add(productDTO);
    }

    //FIX ME!!!!
    public ProductDTO getProductById(long idProduct) {
        return products
                .stream()
                .filter(product -> product.getId() == idProduct)
                .findFirst()
                .orElseThrow(() -> new ProductNotFoundException(idProduct));
    }
}