package Labs.StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class _5_PrinterQueue {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<String> operations = new ArrayDeque<>();
        String command = scanner.nextLine();
        while (!"print".equals(command)) {
            if ("cancel".equals(command)) {
                if (operations.isEmpty()) {
                    System.out.println("Printer is on standby");
                } else {
                    String job = operations.poll();
                    System.out.println("Canceled " + job);
                }
            } else {
                operations.offer(command);
            }
            command = scanner.nextLine();
        }

        while (!operations.isEmpty()) {
            System.out.println(operations.poll());
        }
    }
}
