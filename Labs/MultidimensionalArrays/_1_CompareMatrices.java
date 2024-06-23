package Labs.MultidimensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class _1_CompareMatrices {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[][] m1 = readMatrix(scanner);
        int[][] m2 = readMatrix(scanner);

        if (equalsMatrices(m1, m2)) {
            System.out.println("equal");
        } else {
            System.out.println("not equal");
        }
    }

    private static int[][] readMatrix(Scanner scanner) {

        int[] dimensions = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int[][] matrix = new int[dimensions[0]][1];
        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        return matrix;
    }

    private static boolean equalsMatrices(int[][] m1, int[][] m2) {
        if (m1.length != m2.length) {
            return false;
        } else {
            for (int i = 0; i < m1.length; i++) {
                if (m1[i].length != m2[i].length) {
                    return false;
                } else {
                    for (int j = 0; j < m1[i].length; j++) {
                        if (m1[i][j] != m2 [i][j]) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
}
