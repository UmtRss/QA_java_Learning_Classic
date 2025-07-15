package lesson24;

import java.io.FileReader;
import java.io.IOException;

public class FileReaderExample {

    public void readFile(String path) throws IOException {
        FileReader reader = new FileReader(path);
        int data;
        while ((data = reader.read()) != -1) {
            System.out.print((char) data);
        }
        reader.close();
    }
}
