package Labs.StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class _3_DecimalToBinaryRepresentation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = Integer.parseInt(scanner.nextLine());
        if (number == 0) {
            System.out.println(number);
            return;
        }

        Deque<Integer> stack = new ArrayDeque<>();
        while(number != 0) {
           stack.push(number % 2);
           number /= 2;
        }

        while (!stack.isEmpty()) {
            System.out.print(stack.pop());
        }
    }
}
