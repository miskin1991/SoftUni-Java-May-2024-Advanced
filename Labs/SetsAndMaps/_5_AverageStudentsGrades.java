package Labs.SetsAndMaps;

import java.util.*;
import java.util.stream.Collectors;

public class _5_AverageStudentsGrades {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        TreeMap<String, List<Double>> grades = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            String[] tokens = scanner.nextLine().split(" ");
            String name = tokens[0];
            double grade = Double.parseDouble(tokens[1]);
            grades.putIfAbsent(name, new ArrayList<>());
            grades.get(name).add(grade);
        }

        grades.forEach((key, value) -> {
            double average = value.stream().collect(Collectors.averagingDouble(Double::doubleValue));
            System.out.print(key + " -> ");
            value.forEach(grade -> System.out.printf("%.2f ", grade));
            System.out.printf("(avg: %.2f)%n", average);
        });

    }
}
