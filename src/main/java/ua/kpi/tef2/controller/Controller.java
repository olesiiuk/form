package ua.kpi.tef2.controller;

import ua.kpi.tef2.model.Model;
import ua.kpi.tef2.model.User;
import ua.kpi.tef2.view.View;

import java.util.ResourceBundle;

public class Controller {
    private String ERROR_SUFFIX = ".error";
    private String DATA_REQUEST_SUFFIX = ".dataRequest";
    private String RESOURCE_BUNDLE_MESSAGES = "Messages";

    private Model model;

    private View view;

    private DataReader dataReader;

    private ResourceBundle resourceBundle = ResourceBundle.getBundle(RESOURCE_BUNDLE_MESSAGES);

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
        dataReader = new DataReader();
    }

    public void process() {
        LoginController loginController = new LoginController(model, view, this);
        loginController.registration();

        User user = new User();

        user.setName(getValidData(InputType.NAME));
        user.setLastName(getValidData(InputType.LAST_NAME));
        user.setEmail(getValidData(InputType.EMAIL));
        user.setPhoneNumber(getValidData(InputType.PHONE));

        System.out.println(user);

    }


    public String getValidData(String inputType) {

        String dataRequest = resourceBundle.getString(inputType + DATA_REQUEST_SUFFIX);
        String errorMessage = resourceBundle.getString(inputType + ERROR_SUFFIX);

        while (true) {
            view.printMessage(dataRequest);

            String input = dataReader.readInput();
            if (InputValidator.validate(inputType, input)) {
                return input;
            }
            view.printMessage(errorMessage);
        }
    }


    public void setDataReader(DataReader dataReader) {
        this.dataReader = dataReader;
    }
}
