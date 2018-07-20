package ua.kpi.tef2.model;

import org.junit.Test;

import static org.junit.Assert.*;

public class ModelTest {

    @Test
    public void testRegistrationLogin() {
        Model model = new Model();
        assertTrue(model.registerLogin("goodLogin"));
    }

    @Test(expected = LoginAlreadyExistsException.class)
    public void testRegistration() {
        Model model = new Model();
        model.registerLogin("login1");
    }

}