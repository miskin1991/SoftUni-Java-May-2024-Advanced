package Exercises.StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class _5_BalancedParentheses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        boolean isBalanced = true;
        ArrayDeque<Character> stack = new ArrayDeque<>();
        String input = scanner.nextLine();
        for (char c : input.toCharArray()) {
            switch (c) {
                case '(':
                case '[':
                case '{':
                    stack.push(c);
                    break;
            default:
                isBalanced = isBalanced && IsBalanced(c, stack);
                break;
            }
        }

        if (isBalanced) System.out.println("YES");
        else System.out.println("NO");
    }

    private static boolean IsBalanced(char second, ArrayDeque<Character> stack) {
        boolean isBalanced = true;
        if (stack.isEmpty()) return false;

        char first = stack.pop();
        switch (second) {
            case ')':
                if (first != '(') {
                    isBalanced = false;
                }
                break;
            case ']':
                if (first != '[') {
                    isBalanced = false;
                }
                break;
            case '}':
                if (first != '{') {
                    isBalanced = false;
                }
                break;
            default:
                break;
        }
        return isBalanced;
    }
}
