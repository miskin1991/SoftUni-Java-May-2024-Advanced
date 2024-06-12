package Exercises.StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class _4_BasicStackOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] tokens = scanner.nextLine().split("\\s+");
        int offerCount = Integer.parseInt(tokens[0]);
        int pollCount = Integer.parseInt(tokens[1]);
        int findElement = Integer.parseInt(tokens[2]);

        tokens = scanner.nextLine().split("\\s+");
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        for (String token : tokens) {
            if (queue.size() < offerCount) {
                queue.offer(Integer.parseInt(token));
            }
        }

        for (int i = 0; i < pollCount; i++) {
            if (queue.isEmpty()) {
                break;
            } else {
                queue.poll();
            }
        }

        if (queue.isEmpty()) {
            System.out.println(0);
        } else if (queue.contains(findElement)) {
            System.out.println("true");
        } else {
            System.out.println(Collections.min(queue));
        }
    }
}
