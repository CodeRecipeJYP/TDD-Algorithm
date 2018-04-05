package probs.samsung.day03.prob19;

import java.util.Scanner;

public class Zzaero2 {
    public static void main(String[] args) {
        char[][] map = getInput(new Scanner(System.in));

        System.out.println(getMinimumTrials(map));
    }

    public static int getMinimumTrials(char[][] map) {
        return 0;
    }

    public static char[][] getInput(Scanner scanner) {
        int rowCount = scanner.nextInt();
        int colCount = scanner.nextInt();

        scanner.nextLine();

        char[][] map = new char[rowCount][colCount];
        for (int rowIdx = 0; rowIdx < rowCount; rowIdx++) {
            String eachRow = scanner.nextLine();
            for (int colIdx = 0; colIdx < colCount; colIdx++) {
                map[rowIdx][colIdx] = eachRow.charAt(colIdx);
            }
        }

        return map;
    }
    //5 5
    //#####
    //#..B#
    //#.#.#
    //#RO.#
    //#####
}
