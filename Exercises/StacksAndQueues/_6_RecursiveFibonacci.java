package Exercises.StacksAndQueues;

import java.util.Scanner;

public class _6_RecursiveFibonacci {
    private static long[] fibonacciMemory;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        fibonacciMemory = new long[n + 1];
        System.out.println(CalculateFibonacci(n));
    }

    private static long CalculateFibonacci(int n) {
        if (n <= 1) {
            return 1;
        } else {
            if (fibonacciMemory[n] == 0) {
                long result = CalculateFibonacci(n - 1) + CalculateFibonacci(n - 2);
                fibonacciMemory[n] = result;
            }
            return fibonacciMemory[n];
        }
    }
}
