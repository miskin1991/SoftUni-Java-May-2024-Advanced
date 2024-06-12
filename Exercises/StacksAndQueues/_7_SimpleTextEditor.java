package Exercises.StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class _7_SimpleTextEditor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        StringBuilder text = new StringBuilder();
        ArrayDeque<String> history = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            String[] tokens = scanner.nextLine().split(" ");
            switch (Integer.parseInt(tokens[0])) {
                case 1: {
                    history.push(text.toString());
                    text.append(tokens[1]);
                    break;
                }
                case 2: {
                    history.push(text.toString());
                    text = new StringBuilder(text.substring(0, text.length() - Integer.parseInt(tokens[1])));
                    break;
                }
                case 3: {
                    System.out.println(text.charAt(Integer.parseInt(tokens[1]) - 1));
                    break;
                }
                case 4: {
                    text = new StringBuilder(history.pop());
                    break;
                }
                default:
                    break;
            }
        }

    }
}