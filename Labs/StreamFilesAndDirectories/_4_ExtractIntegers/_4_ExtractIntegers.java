package Labs.StreamFilesAndDirectories._4_ExtractIntegers;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class _4_ExtractIntegers {

    public static void main(String[] args) throws IOException {
        String pathIn = "Labs/StreamFilesAndDirectories/input.txt";
        String pathOut = "Labs/StreamFilesAndDirectories/_4_ExtractIntegers/output.txt";
        FileInputStream inputStream = new FileInputStream(pathIn);
        Scanner scanner = new Scanner(inputStream);
        PrintWriter writer = new PrintWriter(pathOut);

        while (scanner.hasNext()) {
            if (scanner.hasNextInt()) {
                writer.println(scanner.nextInt());
            }
            scanner.next();
        }
        writer.close();
    }
}
