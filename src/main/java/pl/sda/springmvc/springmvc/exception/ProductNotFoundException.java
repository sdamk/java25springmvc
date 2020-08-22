package pl.sda.springmvc.springmvc.exception;

public class ProductNotFoundException extends RuntimeException {

    private static final String MESSAGE = "Not found product with id: ";

    public ProductNotFoundException(long idProduct){
        super(MESSAGE + idProduct);
    }
}
