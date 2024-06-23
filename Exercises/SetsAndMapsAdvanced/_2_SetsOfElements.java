package Exercises.SetsAndMapsAdvanced;

import java.util.LinkedHashSet;
import java.util.Scanner;

public class _2_SetsOfElements {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] sizes = scanner.nextLine().split("\\s+");
        int N = Integer.parseInt(sizes[0]);
        int M = Integer.parseInt(sizes[1]);


        LinkedHashSet<Integer> nSet = new LinkedHashSet<>();
        for (int i = 0; i < N; i++) {
            nSet.add(Integer.parseInt(scanner.nextLine()));
        }
        LinkedHashSet<Integer> mSet = new LinkedHashSet<>();
        for (int i = 0; i < M; i++) {
            mSet.add(Integer.parseInt(scanner.nextLine()));
        }

        nSet.forEach(number -> {
            if (mSet.contains(number)) {
                System.out.printf("%d ", number);
            }
        });

    }
}
