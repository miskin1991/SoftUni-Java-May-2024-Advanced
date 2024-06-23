package Labs.MultidimensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class _2_PositionsOf {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimensions = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        int[][] matrix = new int[dimensions[0]][dimensions[1]];
        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        }

        int lookFor = Integer.parseInt(scanner.nextLine());
        boolean found = false;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == lookFor) {
                    System.out.printf("%d %d%n", i, j);
                    found = true;
                }
            }
        }

        if (!found) System.out.println("not found");
    }
}
