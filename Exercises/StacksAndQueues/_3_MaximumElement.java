package Exercises.StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class _3_MaximumElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numCommands = Integer.parseInt(scanner.nextLine());

        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < numCommands; i++) {
            String[] tokens = scanner.nextLine().split(" ");
            int type = Integer.parseInt(tokens[0]);
            switch (type) {
                case 1:
                    int element = Integer.parseInt(tokens[1]);
                    stack.push(element);
                    break;
                case 2:
                    stack.pop();
                    break;
                case 3:
                    System.out.println(Collections.max(stack));
                    break;
                default:
                    break;
            }
        }
    }
}
