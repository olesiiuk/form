package ua.kpi.tef2.controller;

import org.junit.Test;

import static org.junit.Assert.*;

public class InputValidatorTest {

    @Test
    public void testValidationNameFalse() {
        String inputType = "Name";

        assertFalse(InputValidator.validate(inputType, "yaroslav"));
        assertFalse(InputValidator.validate(inputType, "Yaros lav"));
        assertFalse(InputValidator.validate(inputType, "Yaros--lav"));
        assertFalse(InputValidator.validate(inputType, "Yaros.lav"));
    }

    @Test
    public void testNewValidationNameTrue() {
        assertTrue(InputValidator.validate("Name", "Yaroslav"));
        assertTrue(InputValidator.validate("Name", "Yaros-lav"));
    }

    @Test
    public void testCommentValidation() {
        assertTrue(InputValidator.validate("Comment", "some comment of few words"));
        assertTrue(InputValidator.validate("Comment", "some comment of few words, and some ? " +
                "punctuation. that ... I need to check!"));
    }

    @Test
    public void testPhoneNumberValidation() {
        assertTrue(InputValidator.validate("Phone", "063-845-62-45"));
        assertTrue(InputValidator.validate("Phone", "+38-063-845-62-45"));
        assertFalse(InputValidator.validate("Phone", "+38-abd-845-62-45"));
        assertFalse(InputValidator.validate("Phone", "+38-063-845-62-450"));
        assertFalse(InputValidator.validate("Phone", "+38-063-845-62--5"));
        assertFalse(InputValidator.validate("Phone", "+38-063 845-62-45"));
    }

    @Test
    public void testEmailValidation() {
        assertTrue(InputValidator.validate("Email", "test@email.com"));
        assertTrue(InputValidator.validate("Email", "te.s_t@email.com"));
        assertFalse(InputValidator.validate("Email", "t/e.s_t@email.com"));
        assertFalse(InputValidator.validate("Email", "te.s_t@ema il.com"));
        assertFalse(InputValidator.validate("Email", "tes t@ema il.com"));
    }
    

}