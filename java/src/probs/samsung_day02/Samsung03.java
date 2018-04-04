package probs.samsung_day02;

import java.util.Scanner;

public class Samsung03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int memberCount = scanner.nextInt();

        scanner.nextLine();
        char[][] synergyTable = new char[memberCount][memberCount];
        for (int rowIdx = 0; rowIdx < memberCount; rowIdx++) {
            for (int colIdx = 0; colIdx < memberCount; colIdx++) {
                synergyTable[rowIdx][colIdx] = (char) scanner.nextInt();
            }
        }

        System.out.println(getMinimumAbilityDiff(synergyTable));
    }

    private static int getMinimumAbilityDiff(char[][] table) {


        return 0;
    }
}
