package ua.kpi.tef2.controller;

import ua.kpi.tef2.model.Model;
import ua.kpi.tef2.model.User;
import ua.kpi.tef2.view.View;

import java.util.ResourceBundle;

public class Controller {
    private String ERROR_SUFFIX = ".error";
    private String DATA_REQUEST_SUFFIX = ".dataRequest";

    private Model model;

    private View view;

    private DataReader dataReader;

    private ResourceBundle resourceBundle = ResourceBundle.getBundle("Messages");

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
        dataReader = new DataReader();
    }

    public void process() {
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
            view.pringMessage(dataRequest);

            String input = dataReader.readInput();
            if (InputValidator.validate(inputType, input)) {
                return input;
            }
            view.pringMessage(errorMessage);
        }
    }


    public void setDataReader(DataReader dataReader) {
        this.dataReader = dataReader;
    }
}
