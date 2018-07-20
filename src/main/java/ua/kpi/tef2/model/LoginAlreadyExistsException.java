package ua.kpi.tef2.model;

import java.util.ResourceBundle;

public class LoginAlreadyExistsException extends RuntimeException {
    private String ERROR_MESSAGE = ResourceBundle.getBundle("Messages")
            .getString("input.type.password.exceptionMessageFormat");

    private String login;

    public LoginAlreadyExistsException(String login) {
        this.login = login;
    }

    public LoginAlreadyExistsException(String message, String login) {
        super(message);
        this.login = login;
    }

    public String getMessage() {
        return String.format(ERROR_MESSAGE, login);
    }

}
