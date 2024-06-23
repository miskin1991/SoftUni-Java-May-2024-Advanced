package Labs.MultidimensionalArrays;

import java.util.*;

public class _6_PrintDiagonalSquareMatrix {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        int[][] matrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            matrix[i] = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        for (int i = 0; i < matrix.length; i++) {
            System.out.print(matrix[i][i] + " ");
        }
        System.out.println();

        int row = n - 1;
        int col = 0;

        while (row >= 0 && col < n) {
            System.out.print(matrix[row][col] + " ");
            row--;
            col++;
        }
    }
}
