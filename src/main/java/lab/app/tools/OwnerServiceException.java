package lab.app.tools;

public class OwnerServiceException extends RuntimeException{
    public OwnerServiceException() {
        super();
    }

    public OwnerServiceException(String message) {
        super(message);
    }

    public OwnerServiceException(String message, Throwable cause) {
        super(message, cause);
    }
}
