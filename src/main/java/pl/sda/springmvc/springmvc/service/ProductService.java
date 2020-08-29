package pl.sda.springmvc.springmvc.service;

import org.springframework.stereotype.Service;
import pl.sda.springmvc.springmvc.dto.NewProductDTO;
import pl.sda.springmvc.springmvc.dto.ProductDTO;
import pl.sda.springmvc.springmvc.entity.Product;
import pl.sda.springmvc.springmvc.exception.ProductNotFoundException;
import pl.sda.springmvc.springmvc.repository.ProductRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
//TRAANSACTION
public class ProductService {

    private final ProductRepository repo;

    //@Autowired
    public ProductService(ProductRepository repo) {
        this.repo = repo;
    }

    public List<ProductDTO> getProducts() {
        return repo
                .findAll()
                .stream()
                .map(entity -> new ProductDTO(entity.getId(), entity.getName()))
                .collect(Collectors.toList());
    }

    public void addProduct(NewProductDTO newProductDTO) {
        repo.save(new Product(newProductDTO.getName()));
    }

    public ProductDTO getProductById(long idProduct) {
        return repo
                .findById(idProduct)
                .map(entity -> new ProductDTO(entity.getId(), entity.getName()))
                .orElseThrow(() -> new ProductNotFoundException(idProduct));
    }
}