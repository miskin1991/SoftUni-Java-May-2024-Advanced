package Labs.StreamFilesAndDirectories._7_ListFiles;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class _7_ListFiles {

    public static void main(String[] args) throws IOException {
        File directory = new File("Labs/StreamFilesAndDirectories/Files-and-Streams");
        PrintWriter writer = new PrintWriter(
                new FileWriter("Labs/StreamFilesAndDirectories/_7_ListFiles/output.txt")
        );

        File[] files = directory.listFiles();
        assert files != null;
        for (File file : files) {
            if (file.isFile()) {
                writer.printf("%s: [%d]%n", file.getName(), file.length());
            }
        }
        writer.close();
    }
}
