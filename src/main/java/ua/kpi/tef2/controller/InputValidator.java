package ua.kpi.tef2.controller;

public class InputValidator {
    private static final String NAME_AND_LAST_NAME_REG_EX = "^[A-Z]([a-z][^(-){2,}\\s.]?)+$";
    private static final String COMMENT_REG_EX = "^[\\w\\s.,!?:…]{0,500}$";
    private static final String PHONE_REG_EX = "^(\\+\\d\\d-)?(\\d\\d\\d)-(\\d\\d\\d)(-\\d\\d){2}$";
    private static final String EMAIL_REG_EX = "^[\\w.]{3,15}@[a-zA-Z.]{4,15}$";

    public static boolean validate(String inputType, String input) {
        String regEx = "";
        switch (inputType) {
            case InputType.NAME:
                regEx = NAME_AND_LAST_NAME_REG_EX;
                break;
            case InputType.LAST_NAME:
                regEx = NAME_AND_LAST_NAME_REG_EX;
                break;
            case InputType.COMMENT:
                regEx = COMMENT_REG_EX;
                break;
            case InputType.PHONE:
                regEx = PHONE_REG_EX;
                break;
            case InputType.EMAIL:
                regEx = EMAIL_REG_EX;
                break;
        }
        return input.matches(regEx);
    }
}
