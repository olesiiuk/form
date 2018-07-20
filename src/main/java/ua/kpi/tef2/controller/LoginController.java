package ua.kpi.tef2.controller;

import ua.kpi.tef2.model.LoginAlreadyExistsException;
import ua.kpi.tef2.model.Model;
import ua.kpi.tef2.view.View;

public class LoginController {

    private Controller controller;

    private Model model;

    private View view;

    public LoginController(Model model, View view, Controller controller) {
        this.controller = controller;
        this.model = model;
        this.view = view;
    }

    void registration() {
        saveLogin();
        String password = controller.getValidData(InputType.PASSWORD);

//        saveLoginData
    }

    private void saveLogin() {
        String login = controller.getValidData(InputType.LOGIN);
        try {
            model.registerLogin(login);
        } catch (LoginAlreadyExistsException ex) {
            view.printMessage(ex.getMessage());
            saveLogin();
        }
    }


}
