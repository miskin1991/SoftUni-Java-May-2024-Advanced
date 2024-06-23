package Labs.SetsAndMaps;

import java.util.*;

public class _1_ParkingLot {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LinkedHashSet<String> lot = new LinkedHashSet<>();
        String input = scanner.nextLine();
        while (!"END".equals(input)) {
            String[] tokens = input.split(", ");
            if (tokens[0].equals("IN")) {
                lot.add(tokens[1]);
            } else {
                lot.remove(tokens[1]);
            }
            input = scanner.nextLine();
        }

        if (!lot.isEmpty()) {
            lot.forEach(System.out::println);
        } else {
            System.out.println("Parking Lot is Empty");
        }
    }
}
