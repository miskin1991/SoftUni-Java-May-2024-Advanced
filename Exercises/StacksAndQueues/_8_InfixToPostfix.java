package Exercises.StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class _8_InfixToPostfix {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] tokens = scanner.nextLine().split(" ");

        ArrayDeque<String> output = new ArrayDeque<>();
        ArrayDeque<String> operators = new ArrayDeque<>();
        for (String token : tokens) {
            if(token.length() > 1) {
                // it is a function
                output.offer(token);
            } else {
                if (isOperator(token)) {
                    // check the precedence
                    if (operators.isEmpty()) {
                        operators.push(token);
                    } else {
                        while (!operators.isEmpty() && !operators.peek().equals("(")
                                && hasPrecedence(token, operators.peek())) {
                            output.offer(operators.pop());
                        }
                        operators.push(token);
                    }
                } else if (token.equals("(")) {
                    operators.push(token);
                } else if (token.equals(")")) {
                    while (!operators.isEmpty() && !operators.peek().equals("(")) {
                        output.offer(operators.pop());
                    }
                    operators.pop();
                } else {
                    output.offer(token);
                }
            }
        }

        while (!operators.isEmpty()) {
            output.offer(operators.pop());
        }

        while (!output.isEmpty()) {
            System.out.printf("%s ", output.poll());
        }
        System.out.println();
    }

    private static boolean isOperator(String op) {
        return (op.equals("+")) || (op.equals("-")) || ( op.equals("*")) || (op.equals("/"));
    }

    private static boolean hasPrecedence(String op1, String op2) {
        return (!op1.equals("*") && !op1.equals("/")) || (!op2.equals("+") && !op2.equals("-"));
    }
}
