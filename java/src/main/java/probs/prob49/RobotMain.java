package probs.prob49;

import java.util.Objects;
import java.util.Scanner;

public class RobotMain {
    private static final int IMPOSSIBLE = -1;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rowCountM = scanner.nextInt();
        int colCountN = scanner.nextInt();
        scanner.nextLine();

        int[][] map = new int[rowCountM][colCountN];
        for (int rowIdx = 0; rowIdx < rowCountM; rowIdx++) {
            for (int colIdx = 0; colIdx < colCountN; colIdx++) {
                map[rowIdx][colIdx] = scanner.nextInt();
            }
            scanner.nextLine();
        }

        int rowStartIdx = scanner.nextInt() - 1;
        int colStartIdx = scanner.nextInt() - 1;
        int directionStartIdx = scanner.nextInt() - 1;
        State startState = new State(rowStartIdx, colStartIdx, directionStartIdx);
        scanner.nextLine();

        int rowEndIdx = scanner.nextInt() - 1;
        int colEndIdx = scanner.nextInt() - 1;
        int directionEndIdx = scanner.nextInt() - 1;
        State endState = new State(rowEndIdx, colEndIdx, directionEndIdx);
        scanner.nextLine();

        System.out.println(getShortestPath(map, startState, endState));
    }

    private static int getShortestPath(int[][] map, State startState, State endState) {
        return IMPOSSIBLE;
    }

    static class State {
        int row;
        int col;
        int direction;

        public State(int row, int col, int direction) {
            this.row = row;
            this.col = col;
            this.direction = direction;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            State state = (State) o;
            return row == state.row &&
                    col == state.col &&
                    direction == state.direction;
        }

        @Override
        public int hashCode() {

            return Objects.hash(row, col, direction);
        }
    }
}
