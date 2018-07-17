package ua.kpi.tef2;

import ua.kpi.tef2.controller.Controller;
import ua.kpi.tef2.model.Model;
import ua.kpi.tef2.view.View;

import java.util.Locale;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        Locale.setDefault(new Locale("UA"));

        Model model = new Model();
        View view = new View();

        Controller controller = new Controller(model, view);

        controller.process();
    }
}
