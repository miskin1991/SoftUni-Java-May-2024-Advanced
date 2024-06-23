package Labs.SetsAndMaps;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class _6_ProductShop {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        TreeMap<String, LinkedHashMap<String, Double>> shops = new TreeMap<>();

        String input = scanner.nextLine();
        while (!"Revision".equals(input)) {
            String[] tokens = input.split(",\\s+");
            String shop = tokens[0];
            String product = tokens[1];
            double price = Double.parseDouble(tokens[2]);

            shops.putIfAbsent(shop, new LinkedHashMap<>());
            Map<String, Double> entry = shops.get(shop);
            entry.putIfAbsent(product, price);
            input = scanner.nextLine();
        }

        for (var shop : shops.entrySet()) {
            StringBuilder output = new StringBuilder();
            output.append(shop.getKey()).append("->").append(System.lineSeparator());
            for (var product : shop.getValue().entrySet()) {
                output.append("Product: %s, Price: %.1f".formatted(product.getKey(), product.getValue()))
                        .append(System.lineSeparator());
            }
            System.out.print(output);
        }
    }
}
