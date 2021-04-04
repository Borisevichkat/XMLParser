package by.epam.training.xml.reader;

import by.epam.training.xml.reader.impl.FileReaderImpl;

public class ReaderProvider {
    private static final ReaderProvider instance = new ReaderProvider();
    private final Reader fileReader = new FileReaderImpl();

    public ReaderProvider() {
    }

    public static ReaderProvider getInstance() {
        return instance;
    }

    public Reader getFileReader() {
        return fileReader;
    }
}
