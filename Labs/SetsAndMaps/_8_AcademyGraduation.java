package Labs.SetsAndMaps;

import java.util.Arrays;
import java.util.Scanner;
import java.util.TreeMap;

public class _8_AcademyGraduation {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        TreeMap<String, double[]> agenda = new TreeMap<>();

        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String name = scanner.nextLine();
            double[] scores = Arrays.stream(scanner.nextLine().split(" "))
                    .mapToDouble(Double::parseDouble).toArray();
            agenda.putIfAbsent(name, scores);
        }

        agenda.forEach((s, doubles) ->
                System.out.printf("%s is graduated with %s%n", s, Arrays.stream(doubles).average().orElse(0.0)));
    }
}
