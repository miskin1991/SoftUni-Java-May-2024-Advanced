package Exams.Exam20231021;


import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class _1_OffRoadChallenge {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> fuelQuantity = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).forEach(fuelQuantity::push);
        ArrayDeque<Integer> consumptionIndex = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).forEach(consumptionIndex::offer);
        ArrayDeque<Integer> neededFuel = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).forEach(neededFuel::offer);

        ArrayDeque<Integer> fuelRemaining = new ArrayDeque<>(fuelQuantity.size());
        while (!fuelQuantity.isEmpty()) {
            fuelRemaining.offer(fuelQuantity.pop() - consumptionIndex.poll());
        }

        while (!fuelRemaining.isEmpty()) {
            fuelQuantity.offer(fuelRemaining.poll() - neededFuel.poll());
        }

        StringBuilder output = new StringBuilder();
        int altitudes = 0;
        boolean reachedAltitude = true;
        while (!fuelQuantity.isEmpty() && reachedAltitude) {
            int fuel = fuelQuantity.poll();
            if (fuel >= 0) {
                output.append("John has reached: Altitude ").append(++altitudes).append("\r\n");
            } else {
                output.append("John did not reach: Altitude ").append(altitudes + 1).append("\r\n");
                reachedAltitude = false;
            }
        }
        if (!reachedAltitude) {
            output.append("John failed to reach the top.\r\n");
            if (altitudes == 0) {
                output.append("John didn't reach any altitude.");
            } else {
                output.append("Reached altitudes: ");
                for (int i = 1; i < altitudes; i++) {
                    output.append("Altitude ").append(i).append(", ");
                }
                output.append("Altitude ").append(altitudes);
            }
        } else {
            output.append("John has reached all the altitudes and managed to reach the top!");
        }
        System.out.println(output);
    }
}
