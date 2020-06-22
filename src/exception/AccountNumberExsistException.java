package exception;

public class AccountNumberExsistException extends RuntimeException{
    public AccountNumberExsistException(String message) {
        super(message);
    }
}
