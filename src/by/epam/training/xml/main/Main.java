package by.epam.training.xml.main;

import by.epam.training.xml.controller.ParserController;
import by.epam.training.xml.controller.impl.ParserControllerImpl;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        ParserController controller = new ParserControllerImpl();
        String response = controller.parse();
        System.out.println(response);
    }
}
