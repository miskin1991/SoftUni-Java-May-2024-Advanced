package Exams.Exam20240722;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class _1_RapidCourier {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> pkgStack = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).forEach(pkgStack::push);
        ArrayDeque<Integer> courierQueue = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).forEach(courierQueue::offer);

        int totalWeight = 0;

        while (!pkgStack.isEmpty() && !courierQueue.isEmpty()) {
            int pkg = pkgStack.pop();
            int courier = courierQueue.poll();
            if (courier >= pkg) {
                // delivers
                courier -= (pkg * 2);
                if (courier > 0) {
                    courierQueue.offer(courier);
                }
                totalWeight += pkg;
            } else {
                pkg -= courier;
                pkgStack.push(pkg);
                totalWeight += courier;
            }
        }

        System.out.printf("Total weight: %d kg%n", totalWeight);
        if (pkgStack.isEmpty() && courierQueue.isEmpty()) {
            System.out.println("Congratulations, all packages were delivered successfully by the couriers today.");
        } else if (!pkgStack.isEmpty()) {
            System.out.print("Unfortunately, there are no more available couriers to deliver the following packages: ");
            int[] remaining = new int[pkgStack.size()];
            for (int i = remaining.length - 1; i >= 0; i--) {
                remaining[i] = pkgStack.pop();
            }
            for (int i = 0; i < remaining.length - 1; i++) {
                System.out.printf("%d, ", remaining[i]);
            }
            System.out.printf("%d%n ", remaining[remaining.length - 1]);
        } else {
            System.out.print("Couriers are still on duty: ");
            while (courierQueue.size() > 1) {
                System.out.printf("%d, ", courierQueue.poll());
            }
            System.out.printf("%d ", courierQueue.poll());
            System.out.print("but there are no more packages to deliver.");
        }
    }
}
