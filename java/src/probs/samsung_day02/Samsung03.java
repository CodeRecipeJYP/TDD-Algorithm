package probs.samsung_day02;

import java.util.*;

public class Samsung03 {
    private static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int memberCount = scanner.nextInt();

        scanner.nextLine();
        int[][] synergyTable = new int[memberCount][memberCount];
        for (int rowIdx = 0; rowIdx < memberCount; rowIdx++) {
            for (int colIdx = 0; colIdx < memberCount; colIdx++) {
                synergyTable[rowIdx][colIdx] = scanner.nextInt();
            }
        }

        System.out.println(getMinimumAbilityDiff(synergyTable));
    }

    public static int getMinimumAbilityDiff(int[][] table) {
        int memberCount = table.length;
        int minimumDiff = INF;

        List<List<Integer>> everyCombination = getEveryCombination(memberCount);

        for (List<Integer> firstTeam:
         everyCombination) {
            List<Integer> secondTeam = getEnemyTeam(firstTeam);

            int diff = Math.abs(evaluate(table, firstTeam) - evaluate(table, secondTeam));
            if (minimumDiff > diff) {
                minimumDiff = diff;
            }
        }

        return minimumDiff;
    }

    public static int evaluate(int[][] table, List<Integer> team) {
        int sum = 0;

        List<List<Integer>> pairCombinations
                = getCombinations(0, team.size() - 1, 2);

        for (List<Integer> eachPair:
                pairCombinations){
            int firstTeammate = team.get(eachPair.get(0));
            int secondTeammate = team.get(eachPair.get(1));
            sum += table[firstTeammate][secondTeammate];
            sum += table[secondTeammate][firstTeammate];
        }

        return sum;
    }

    public static List<Integer> getEnemyTeam(List<Integer> team) {
        List<Integer> enemy = new ArrayList<>();

        int teamCount = team.size() * 2;

        int teamIdx = 0;
        int member = team.get(teamIdx);
        for (int teamMember = 0; teamMember < teamCount; teamMember++) {
            if (member == teamMember) {
                teamIdx += 1;
                if (teamIdx < team.size()) {
                    member = team.get(teamIdx);
                } else {
                    member = -1;
                }
            } else {
                enemy.add(teamMember);
            }
        }
        return enemy;
    }

    public static List<List<Integer>> getEveryCombination(int memberCount) {
        List<List<Integer>> combinationList = new ArrayList<>();
        int firstMember = 0;
        int eachTeamMemberCount = memberCount / 2;

        for (List<Integer> postFixCombination :
        getCombinations(1, memberCount - 1, eachTeamMemberCount - 1)) {
            List<Integer> eachCombination = new ArrayList<>();
            eachCombination.add(firstMember);
            eachCombination.addAll(postFixCombination);
            combinationList.add(eachCombination);
        }

        return combinationList;
    }

    public static List<List<Integer>> getCombinations(int start, int end, int count) {
        List<List<Integer>> combinationList = new ArrayList<>();

        if (count == 1) {
            for (int item = start; item <= end; item++) {
                List list = new ArrayList();
                list.add(item);
                combinationList.add(list);
            }
        } else {
            int itemMaximum = end - (count - 1);
            for (int item = start; item <= itemMaximum; item++) {
                for (List<Integer> postFixCombination :
                        getCombinations(item + 1, end, count - 1)) {
                    ArrayList<Integer> eachCombination = new ArrayList<>();
                    eachCombination.add(item);
                    eachCombination.addAll(postFixCombination);
                    combinationList.add(eachCombination);
                }
            }
        }

        return combinationList;
    }
}
