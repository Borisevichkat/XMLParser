package by.epam.training.xml.controller.impl;

import by.epam.training.xml.controller.ParserController;
import by.epam.training.xml.data.Node;
import by.epam.training.xml.reader.ReaderProvider;
import by.epam.training.xml.service.ServiceException;
import by.epam.training.xml.service.ServiceProvider;

import javax.imageio.IIOException;
import java.io.IOException;
import java.rmi.server.ExportException;
import java.util.ArrayList;

public class ParserControllerImpl implements ParserController {
    @Override
    public String parse() throws IOException {
        String respone = "";
        ReaderProvider readerProvider = ReaderProvider.getInstance();
        try {
            ArrayList<String> fileContent = readerProvider.getFileReader().readFromFile("resources/simple.xml");
            ServiceProvider serviceProvider = ServiceProvider.getInstance();
            Node tree = serviceProvider.getParser().getMainNode(fileContent);
        } catch (IIOException ex) {
            throw new ExportException(ex.getMessage());
        }
        catch (ServiceException e) {
            throw new ExportException(e.getMessage());
        }
        return respone;
    }
}
