package by.epam.training.xml.reader;

import java.io.IOException;
import java.util.ArrayList;

public interface Reader {
    ArrayList<String> readFromFile(String fileName) throws IOException;
}
