package lab.app.tools;

import lab.app.entities.User;

public class UserServiceException extends RuntimeException{
    public UserServiceException() {
        super();
    }

    public UserServiceException(String message) {
        super(message);
    }

    public UserServiceException(String message, Throwable cause) {
        super(message, cause);
    }
}
