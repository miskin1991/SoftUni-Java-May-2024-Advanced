package Labs.StreamFilesAndDirectories._6_SortLines;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class _6_SortLines {

    public static void main(String[] args) throws IOException {

        List<String> lines = Files.readAllLines(Paths.get("Labs/StreamFilesAndDirectories/input.txt"))
                .stream().sorted().toList();
        Files.write(Paths.get("Labs/StreamFilesAndDirectories/_6_SortLines/output.txt"), lines);
    }
}
