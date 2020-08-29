package pl.sda.springmvc.springmvc.exception;

public class UserLoginExistException extends RuntimeException{

    private static final String MESSAGE = "There is a user with login: ";

    public UserLoginExistException(String login) {
        super(MESSAGE + login);
    }
}
