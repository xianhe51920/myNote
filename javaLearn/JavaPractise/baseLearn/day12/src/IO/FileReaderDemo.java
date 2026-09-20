package IO;

import java.io.FileReader;
import java.io.IOException;

public class FileReaderDemo {
    public static void main(String[] args) throws IOException {
        FileReader fileReader = new FileReader("day12/src/IO/text/B.txt");
        int i;
        while((i = fileReader.read()) != -1){
            System.out.print((char) i);
        }
    }
}
