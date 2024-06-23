package Exercises.MultidimensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class _2_MatrixOfPalindromes {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] input = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        String[][] matrix = new String[input[0]][input[1]];

        char[] chars = new char[] {'a', 'a', 'a'};

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = "" + chars[0] + chars[1] + chars[2];
                ++chars[1];
            }
            Arrays.stream(matrix[i]).forEach(s -> System.out.printf("%s ", s));
            System.out.println();
            chars[0]++;
            chars[1] = chars[0];
            chars[2]++;
        }
    }
}
