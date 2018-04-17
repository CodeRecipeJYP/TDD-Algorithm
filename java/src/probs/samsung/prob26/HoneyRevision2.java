package probs.samsung.prob26;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class HoneyRevision2 {
    static boolean[] sChecked = new boolean[6];
    static int[] sCurrBoxRow;
    static int sDfsResult;

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("src/probs/samsung/prob26/case02.in"));

        int caseCount = scanner.nextInt();
        scanner.nextLine();
        for (int caseIdx = 1; caseIdx <= caseCount; caseIdx++) {
            int boxSize = scanner.nextInt();
            int selectLengthM = scanner.nextInt();
            int capacityC = scanner.nextInt();
            scanner.nextLine();

            Queue<Integer> pq = new PriorityQueue<>();

            int[][] honeybox = new int[11][11];
            for (int rowIdx = 1; rowIdx <= boxSize; rowIdx++) {
                for (int colIdx = 1; colIdx <= boxSize; colIdx++) {
                    honeybox[rowIdx][colIdx] = scanner.nextInt();
                }
                searchProfits(pq, honeybox[rowIdx], boxSize);
            }

            int first = sPq.poll();
            int second = sPq.poll();
            System.out.println(String.format("#%d %d", caseIdx, first + second));
        }
    }

    private static void searchProfits(Queue<Integer> pq, int[] honeybox, int boxSize) {

    }

    static class Honey implements Comparable<Honey> {
        int profit;
        int rowIdx;
        int colIdxStart;
        int colIdxEnd;

        public int isCovered(Honey o) {
            i
        }

        @Override
        public int compareTo(Honey o) {
            return Integer.compare(profit, o.profit);
        }
    }
}
