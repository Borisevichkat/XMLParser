package by.epam.training.xml.service;

import by.epam.training.xml.service.impl.ParseXml2Impl;
import by.epam.training.xml.service.impl.ParserXMLImpl;

public class ServiceProvider {
        private static final ServiceProvider instance = new ServiceProvider();

        private final ParserXML parser = new ParserXMLImpl();

        private ServiceProvider() {}

        public static ServiceProvider getInstance() {
                return instance;
        }

        public ParserXML getParser() { return parser; }
}
