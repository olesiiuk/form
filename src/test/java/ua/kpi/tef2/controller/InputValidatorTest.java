package ua.kpi.tef2.controller;

import org.junit.Test;

import static org.junit.Assert.*;

public class InputValidatorTest {

    @Test
    public void testValidation() {
        String inputType = "Name";
        String input = "Yaroslav";

        boolean isValid = InputValidator.validate(inputType, input);

        assertTrue(isValid);
    }

}