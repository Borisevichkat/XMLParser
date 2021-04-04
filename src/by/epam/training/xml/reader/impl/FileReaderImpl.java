package by.epam.training.xml.reader.impl;

import by.epam.training.xml.reader.Reader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class FileReaderImpl implements Reader {
    @Override
    public ArrayList<String> readFromFile(String fileName) throws IOException {
        ArrayList<String> content = new ArrayList<>();
        FileReader fileReader = new FileReader(fileName);
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        try {
            String line;
            while ((line = bufferedReader.readLine().trim() ) != null) {
                content.add(line);
            }
        } catch (Exception e) {
            // TODO...
        } finally {
            bufferedReader.close();
        }
        return content;
    }
}
