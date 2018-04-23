package probs.prob38;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StartAndLinkMain {
    private static int[][] sSynergeTable;
    private static int sMin = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int memberCountN = scanner.nextInt();
        scanner.nextLine();

        sSynergeTable = new int[memberCountN][memberCountN];
        for (int rowIdx = 0; rowIdx < memberCountN; rowIdx++) {
            for (int colIdx = 0; colIdx < memberCountN; colIdx++) {
                sSynergeTable[rowIdx][colIdx] = scanner.nextInt();
            }
            scanner.nextLine();
        }

        backTrack(1, 1, 1, memberCountN);
        System.out.println(sMin);
    }

    private static void backTrack(int checked, int selectedCount, int depth, int length) {
        if (selectedCount == (length / 2)) {
            sMin = Math.min(getSynergeDiff(checked), sMin);
            return;
        }

        if ((length - depth) < (length / 2 - selectedCount)) {
            return;
        }

        if (depth == length) {
            return;
        }

        backTrack(checked, selectedCount, depth + 1, length);
        backTrack(checked + (1 << depth), selectedCount + 1, depth + 1, length);
    }

    private static int getSynergeDiff(int checked) {
        List<Integer> firstTeam = new ArrayList<>();
        List<Integer> secondTeam = new ArrayList<>();
        for (int memberIdx = 0; memberIdx < sSynergeTable.length; memberIdx++) {
            if ((checked & (1 << memberIdx)) != 0) {
                firstTeam.add(memberIdx);
            } else {
                secondTeam.add(memberIdx);
            }
        }

        return Math.abs(getSynergeSum(firstTeam) - getSynergeSum(secondTeam));
    }

    private static int getSynergeSum(List<Integer> team) {
        int synergeSum = 0;
        for (int teamMemberIdx = 0; teamMemberIdx < team.size(); teamMemberIdx++) {
            int teamMember = team.get(teamMemberIdx);

            for (int otherTeamMemerIdx = 0; otherTeamMemerIdx < team.size(); otherTeamMemerIdx++) {
                if (teamMemberIdx == otherTeamMemerIdx) {
                    continue;
                }
                int otherMember = team.get(otherTeamMemerIdx);
                synergeSum += sSynergeTable[teamMember][otherMember];
            }
        }

        return synergeSum;
    }
}
