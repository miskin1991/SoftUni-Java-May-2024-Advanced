package Labs.SetsAndMaps;

import java.util.HashSet;
import java.util.Scanner;
import java.util.TreeSet;

public class _2_SoftUniParty {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        TreeSet<String> attendees = new TreeSet<>();

        String input = scanner.nextLine();
        while(!"PARTY".equals(input)) {
            attendees.add(input);
            input = scanner.nextLine();
        }

        input = scanner.nextLine();
        while (!"END".equals(input)) {
            attendees.remove(input);
            input = scanner.nextLine();
        }

        System.out.println(attendees.size());
        attendees.forEach(System.out::println);
    }
}
