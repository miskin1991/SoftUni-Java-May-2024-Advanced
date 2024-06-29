package Labs.FunctionalProgramming;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class _5_FilterByAge {

    private record Person(String name, int age) {
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        List<Person> persons = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] info = scanner.nextLine().split(",\\s+");
            persons.add(new Person(info[0], Integer.parseInt(info[1])));
        }

        String condition = scanner.nextLine();
        int age = Integer.parseInt(scanner.nextLine());
        String format = scanner.nextLine();

        Predicate<Person> younger = person -> switch (condition) {
            case "younger" -> person.age() < age;
            case "older" -> person.age() >= age;
            default -> throw new IllegalArgumentException("Unsupported input condition: " + condition);
        };

        Consumer<Person> personConsumer = person -> {
            switch (format) {
                case "name":
                    System.out.println(person.name());
                    break;
                case "age":
                    System.out.println(person.age());
                    break;
                case "name age":
                    System.out.println(person.name() + " - " + person.age());
                    break;
            }
        };

        persons.stream().filter(younger).forEach(personConsumer);

    }
}
