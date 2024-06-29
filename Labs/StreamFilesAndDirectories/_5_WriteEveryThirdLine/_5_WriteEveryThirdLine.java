package Labs.StreamFilesAndDirectories._5_WriteEveryThirdLine;

import java.io.*;

public class _5_WriteEveryThirdLine {

    public static void main(String[] args) throws IOException {
        String pathIn = "Labs/StreamFilesAndDirectories/input.txt";
        String pathOut = "Labs/StreamFilesAndDirectories/_5_WriteEveryThirdLine/output.txt";

        BufferedReader reader = new BufferedReader(new FileReader(pathIn));
        PrintWriter writer = new PrintWriter(new FileWriter(pathOut));

        int count = 1;
        while (reader.ready()) {
            if (count % 3 == 0) {
                writer.println(reader.readLine());
            } else {
                reader.readLine();
            }
            count++;
        }
        writer.close();
    }
}
