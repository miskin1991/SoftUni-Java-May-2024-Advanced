package Labs.MultidimensionalArrays;

import java.util.Scanner;

public class _7_FindTheRealQueen {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char[][] chessboard = new char[8][8];

        for (int i = 0; i < chessboard.length; i++) {
            chessboard[i] = scanner.nextLine().replaceAll(" ", "").toCharArray();
        }

        for (int i = 0; i < chessboard.length; i++) {
            // for each row find the unique queen
            int col = getQueenColumn(chessboard[i]);
            if (col >= 0) {
                if (isUniqueQueenInColumn(chessboard, col) && isUniqueQueenInDiagonal(chessboard, i, col)) {
                    System.out.println(i + " " + col);
                }
            } // it is not
        }
    }

    public static int getQueenColumn(char[] row) {
        int queens = 0;
        int index = 0;
        for (int i = 0; i < row.length; i++) {
            if (row[i] == 'q') {
                queens++;
                index = i;
            }
        }

        if (queens == 1) return index;
        else return -1;
    }

    public static boolean isUniqueQueenInColumn(char[][] chessboard, int col) {
        int queens = 0;
        for (char[] chars : chessboard) {
            if (chars[col] == 'q') {
                queens++;
            }
        }
        return queens == 1;
    }

    public static boolean isUniqueQueenInDiagonal(char[][] chessboard, int row, int col) {

        if (!isUniqueQueen(chessboard, row, col, 1, 1, (size, x, y) -> (x < size && y < size))) {
            return false;
        }

        if (!isUniqueQueen(chessboard, row, col, -1, -1, (size, x, y) -> (x >= 0 && y >= 0))) {
            return false;
        }

        if (!isUniqueQueen(chessboard, row, col, -1, 1, (size, x, y) -> (x >= 0 && y < size))) {
            return false;
        }

        return isUniqueQueen(chessboard, row, col, 1, -1, (size, x, y) -> (x < size && y >= 0));
    }

    public static boolean isUniqueQueen(char[][] chessboard, int row, int col, int rInc, int cInc,
                                    PredicateInterface predicate) {
        int queens = 0;
        while (predicate.inRange(chessboard.length, row, col)) {
            if (chessboard[row][col] == 'q') {
                queens++;
            }
            row += rInc;
            col += cInc;
        }

        return (queens == 1);
    }

    @FunctionalInterface
    public interface PredicateInterface {
        boolean inRange(int size, int x, int y);
    }
}
