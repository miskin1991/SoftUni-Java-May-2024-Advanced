package Labs.StreamFilesAndDirectories._8_NestedFolders;

import java.io.*;
import java.util.ArrayDeque;

public class _8_NestedFolders {

    public static void main(String[] args) throws IOException, NullPointerException {
        File directory = new File("Labs/StreamFilesAndDirectories/Files-and-Streams");

        PrintWriter writer = new PrintWriter(
                new FileWriter("Labs/StreamFilesAndDirectories/_8_NestedFolders/output2.txt")
        );

        ArrayDeque<File> dirs = new ArrayDeque<>();
        dirs.offer(directory);

        int counter = 0;
        while (!dirs.isEmpty()) {
            File file = dirs.poll();
            counter++;
            writer.println(file.getAbsoluteFile());
            File[] nestedFiles = file.listFiles();
            assert nestedFiles != null;
            for (File nestedFile : nestedFiles) {
                if (nestedFile.isDirectory()) {
                    dirs.offer(nestedFile);
                }
            }
        }
        writer.println(counter + " folders");
        writer.close();
    }
}
