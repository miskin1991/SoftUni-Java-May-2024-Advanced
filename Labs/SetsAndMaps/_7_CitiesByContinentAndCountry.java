package Labs.SetsAndMaps;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class _7_CitiesByContinentAndCountry {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        LinkedHashMap<String, LinkedHashMap<String, ArrayList<String>>> map = new LinkedHashMap<>();
        for (int i = 0; i < n; i++) {
            String[] tokens = scanner.nextLine().split("\\s+");
            String continent = tokens[0];
            String country = tokens[1];
            String city = tokens[2];
            map.putIfAbsent(continent, new LinkedHashMap<>());
            map.get(continent).putIfAbsent(country, new ArrayList<>(){{add(city);}});
        }

        for (var continent : map.entrySet()) {
            StringBuilder output = new StringBuilder();
            output.append(continent.getKey()).append(":").append(System.lineSeparator());
            for (var country : continent.getValue().entrySet()) {
                output.append("  %s -> ".formatted(country.getKey()));
                output.append(String.join(", ", country.getValue())).append(System.lineSeparator());
            }
            System.out.print(output);
        }
    }
}
