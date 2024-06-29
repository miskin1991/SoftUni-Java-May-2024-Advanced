package Labs.StreamFilesAndDirectories._1_ReadFromFile;

import java.io.FileInputStream;
import java.io.IOException;

public class _1_ReadFromFile {

    public static void main(String[] args) throws IOException {
        // Keep this file in the same directory as the project
        String path = "Labs/StreamFilesAndDirectories/input.txt";

        FileInputStream inputStream = new FileInputStream(path);

        int asciiCode = inputStream.read();

        while (asciiCode != -1) {
            System.out.print(Integer.toBinaryString(asciiCode) + " ");
            asciiCode = inputStream.read();
        }
    }
}
