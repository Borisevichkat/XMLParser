package by.epam.training.xml.service;

import by.epam.training.xml.data.Node;

import java.util.ArrayList;

public interface ParserXML {
    Node getMainNode(ArrayList<String> fileContent) throws ServiceException;
}
