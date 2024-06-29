package Labs.StreamFilesAndDirectories._3_CopyBytes;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class _3_CopyBytes {

    public static void main(String[] args) throws IOException {
        String pathIn = "Labs/StreamFilesAndDirectories/input.txt";
        String pathOut = "Labs/StreamFilesAndDirectories/_3_CopyBytes/output.txt";

        // Open the input file for reading
        FileInputStream inputStream = new FileInputStream(pathIn);
        FileOutputStream outputStream = new FileOutputStream(pathOut);
        int asciiCode = inputStream.read();
        while (asciiCode != -1) {
            // if character is space or new line, write it in the output file directly
            if (asciiCode == ' ' || asciiCode == '\n') {
                outputStream.write(asciiCode);
            } else {
                // write the ascii code of the character in the output file
                outputStream.write(String.valueOf(asciiCode).getBytes());
            }
            asciiCode = inputStream.read();
        }
    }
}
