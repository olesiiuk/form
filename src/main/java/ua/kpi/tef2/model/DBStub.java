package ua.kpi.tef2.model;

public enum DBStub {
    FIRST("login1", "password1"),
    SECOND("login2", "password2"),
    THIRD("login3", "password3");

    private String login;

    private String password;

    DBStub(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public boolean registration(String login) throws LoginAlreadyExistsException {
        for (DBStub record : DBStub.values()) {
            if (record.login.equalsIgnoreCase(login)) {
                throw new LoginAlreadyExistsException(login);
            }
        }

        return true;

    }

    private String getLogin() {
        return login;
    }

    private String getPassword() {
        return password;
    }
}
