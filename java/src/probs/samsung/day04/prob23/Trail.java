package probs.samsung.day04.prob23;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Trail {
    public static void main(String[] args) {
        List<Input> inputs = getInputs(new Scanner(System.in));

        for (int caseIdx = 0; caseIdx < inputs.size(); caseIdx++) {
            Input input = inputs.get(caseIdx);

            System.out.print(String.format("#%d ", caseIdx + 1));
            System.out.println(getLongestTrail(input.map, input.kSize));
        }
    }

    public static int getLongestTrail(int[][] map, int kSize) {
        return 0;
    }

    public static List<Input> getInputs(Scanner sc) {
        int caseCount = sc.nextInt();
        sc.nextLine();

        List<Input> inputs = new ArrayList<>();

        for (int caseIdx = 0; caseIdx < caseCount; caseIdx++) {
            inputs.add(getInput(sc));
        }

        return inputs;
    }

    public static Input getInput(Scanner sc) {
        int mapSize = sc.nextInt();
        int kSize = sc.nextInt();
        sc.nextLine();

        int[][] map = new int[mapSize][mapSize];

        for (int rowIdx = 0; rowIdx < mapSize; rowIdx++) {
            for (int colIdx = 0; colIdx < rowIdx; colIdx++) {
                map[rowIdx][colIdx] = sc.nextInt();
            }
            sc.nextLine();
        }

        return new Input(map, mapSize, kSize);
    }

    static class Input {
        public int map[][];
        public int mapSize;
        public int kSize;

        public Input(int[][] map, int mapSize, int kSize) {
            this.map = map;
            this.mapSize = mapSize;
            this.kSize = kSize;
        }
    }
}
