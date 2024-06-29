package Labs.StreamFilesAndDirectories._2_WriteToFile;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashSet;

public class _2_WriteToFile {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        String pathIn = "Labs/StreamFilesAndDirectories/input.txt";
        String pathOut = "Labs/StreamFilesAndDirectories/_2_WriteToFile/output.txt";
        HashSet<Character> punctuation = new HashSet<>() {{
            add('.');
            add(',');
            add('!');
            add('?');
        }};

        // Open the input file for reading
        FileInputStream inputStream = new FileInputStream(pathIn);
        FileOutputStream outputStream = new FileOutputStream(pathOut);

        int asciiCode = inputStream.read();
        while (asciiCode != -1) {
            char symbol = (char) asciiCode;
            if (!punctuation.contains(symbol)) {
                outputStream.write(asciiCode);
            }
            asciiCode = inputStream.read();
        }
    }
}
