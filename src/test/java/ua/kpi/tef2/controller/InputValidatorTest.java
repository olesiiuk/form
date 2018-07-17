package ua.kpi.tef2.controller;

import org.junit.Test;


import static org.junit.Assert.*;

public class InputValidatorTest {


    @Test
    public void testValidationNameFalse() {
        String inputType = InputType.NAME;

        assertFalse(InputValidator.validate(inputType, "yaroslav"));
        assertFalse(InputValidator.validate(inputType, "Yaros lav"));
        assertFalse(InputValidator.validate(inputType, "Yaros--lav"));
        assertFalse(InputValidator.validate(inputType, "Yaros.lav"));
    }

    @Test
    public void testNewValidationNameTrue() {
        String inputType = InputType.NAME;
        assertTrue(InputValidator.validate(inputType, "Yaroslav"));
        assertTrue(InputValidator.validate(inputType, "Yaros-lav"));
    }

    @Test
    public void testLastNameValidation() {
        String inputType = InputType.LAST_NAME;
        assertTrue(InputValidator.validate(inputType, "Olesiiuk"));
        assertFalse(InputValidator.validate(inputType, "Olesiiuk 123"));
    }

    @Test
    public void testCommentValidation() {
        String inputType = InputType.COMMENT;
        assertTrue(InputValidator.validate(inputType, "some comment of few words"));
        assertTrue(InputValidator.validate(inputType, "some comment of few words, and some ? " +
                "punctuation. that ... I need to check!"));
    }

    @Test
    public void testPhoneNumberValidation() {
        String inputType = InputType.PHONE;
        assertTrue(InputValidator.validate(inputType, "063-845-62-45"));
        assertTrue(InputValidator.validate(inputType, "+38-063-845-62-45"));
        assertFalse(InputValidator.validate(inputType, "+38-abd-845-62-45"));
        assertFalse(InputValidator.validate(inputType, "+38-063-845-62-450"));
        assertFalse(InputValidator.validate(inputType, "+38-063-845-62--5"));
        assertFalse(InputValidator.validate(inputType, "+38-063 845-62-45"));
    }

    @Test
    public void testEmailValidation() {
        String inputType = InputType.EMAIL;
        assertTrue(InputValidator.validate(inputType, "test@email.com"));
        assertTrue(InputValidator.validate(inputType, "te.s_t@email.com"));
        assertFalse(InputValidator.validate(inputType, "t/e.s_t@email.com"));
        assertFalse(InputValidator.validate(inputType, "te.s_t@ema il.com"));
        assertFalse(InputValidator.validate(inputType, "tes t@ema il.com"));
    }


}