package Labs.StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class _2_SimpleCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> numbers = new ArrayDeque<>();
        ArrayDeque<Character> operators = new ArrayDeque<>();

        String[] input = scanner.nextLine().split("\\s+");
        for (String s : input) {
            if (s.equals("+") || s.equals("-")) {
                operators.add(s.charAt(0));
            } else {
                numbers.add(Integer.parseInt(s));
            }
        }

        while (!operators.isEmpty()) {
            Character operation = operators.pop();
            int result;
            if (operation == '+') {
                result = numbers.pop() + numbers.pop();
            } else {
                result = numbers.pop() - numbers.pop();
            }
            numbers.push(result);
        }

        System.out.println(numbers.peek());
    }
}
