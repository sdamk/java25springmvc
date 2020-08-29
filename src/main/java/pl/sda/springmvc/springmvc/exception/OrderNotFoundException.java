package pl.sda.springmvc.springmvc.exception;

public class OrderNotFoundException
        extends RuntimeException {

    private static final String MESSAGE = "Not found order with id: ";

    public OrderNotFoundException(long idOrder) {
        super(MESSAGE + idOrder);
    }
}
