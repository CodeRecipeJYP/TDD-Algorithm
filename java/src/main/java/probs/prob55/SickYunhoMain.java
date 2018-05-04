package probs.prob55;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;

public class SickYunhoMain {
    private static final String MATCHER = "BLD";
    private static final int MORNING = 0;
    private static final int LUNCH = 1;
    private static final int DINNER = 2;

    private static Map<State, Integer> sStored = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int dayN = scanner.nextInt();
        scanner.nextLine();
        String input = scanner.nextLine();

        System.out.println(getMaximumPillCount(dayN, input.toCharArray()));
        sStored.clear();
    }

    private static int getMaximumPillCount(int dayN, char[] inputs) {
        return getSubsetMaximum(inputs, 0, inputs.length - 1, MORNING);
    }

    private static int getSubsetMaximum(char[] inputs, int headIdx, int tailIdx, int time) {
        State currState = new State(headIdx, tailIdx);
        if (sStored.containsKey(currState)) {
            return sStored.get(currState);
        }

        int result = 0;

        if (headIdx == tailIdx) {
            if (MATCHER.indexOf(inputs[headIdx]) == time) {
                result = 1;
            } else {
                result = 0;
            }
        } else {
            int head = MATCHER.indexOf(inputs[headIdx]);
            int tail = MATCHER.indexOf(inputs[tailIdx]);

            if (head == tail && head == time) {
                result = Math.max(getSubsetMaximum(inputs, headIdx + 1, tailIdx, nextTime(time)),
                        getSubsetMaximum(inputs, headIdx, tailIdx - 1, nextTime(time))) + 1;
            } else if (head == time) {
                result = getSubsetMaximum(inputs, headIdx + 1, tailIdx, nextTime(time)) + 1;
            } else if (tail == time) {
                result = getSubsetMaximum(inputs, headIdx, tailIdx - 1, nextTime(time)) + 1;
            }
        }

        sStored.put(currState, result);

        return result;
    }

    private static int nextTime(int time) {
        return (time + 1) % 3;
    }

    static class State {
        int st;
        int ed;

        public State(int st, int ed) {
            this.st = st;
            this.ed = ed;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof State)) return false;
            State state = (State) o;
            return st == state.st &&
                    ed == state.ed;
        }

        @Override
        public int hashCode() {

            return Objects.hash(st, ed);
        }
    }
}
