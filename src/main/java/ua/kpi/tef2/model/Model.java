package ua.kpi.tef2.model;

public class Model {

    public boolean registerLogin(String login) throws LoginAlreadyExistsException {
        return DBStub.FIRST.registration(login);
    }
}
