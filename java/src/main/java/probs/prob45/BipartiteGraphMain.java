package probs.prob45;

import java.util.*;

public class BipartiteGraphMain {
    private static final int NOT_VISITED = 0;
    private static final int GROUP_A = 1;
    private static final int GROUP_B = 2;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int caseCount = scanner.nextInt();
        scanner.nextLine();

        for (int caseIdx = 0; caseIdx < caseCount; caseIdx++) {
            int vertexCountV = scanner.nextInt();
            int edgeCountE = scanner.nextInt();
            scanner.nextLine();

            boolean[][] connectTable = new boolean[vertexCountV][vertexCountV];
            for (int edgeIdx = 0; edgeIdx < edgeCountE; edgeIdx++) {
                int edgeStIdx = scanner.nextInt() - 1;
                int edgeEdIdx = scanner.nextInt() - 1;
                connectTable[edgeStIdx][edgeEdIdx] = true;
                connectTable[edgeEdIdx][edgeStIdx] = true;
                scanner.nextLine();
            }

            if (isBipartiteGraph(connectTable, vertexCountV)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }

    private static boolean isBipartiteGraph(boolean[][] connectTable, int vertexCountV) {
        int highestDegreeVertexIdx = getHighestDegreeVertexIdx(connectTable);
        Map<Integer, Set<Integer>> groupList = new HashMap<>();
        groupList.put(GROUP_A, new HashSet<>());
        groupList.put(GROUP_B, new HashSet<>());
        groupList.get(GROUP_A).add(highestDegreeVertexIdx);
        return dfs(highestDegreeVertexIdx, GROUP_A, connectTable, groupList);
    }

    private static boolean dfs(int currIdx, int currType,
                               boolean[][] connectTable,
                               Map<Integer, Set<Integer>> groupList) {
        for (int colIdx = 0; colIdx < connectTable[0].length; colIdx++) {
            if (connectTable[currIdx][colIdx]) {
                int oppositeType = oppositeType(currType);
                if (groupList.get(currType).contains(colIdx)) {
                    return false;
                } else if (!groupList.get(oppositeType).contains(colIdx)) {
                    groupList.get(oppositeType).add(colIdx);
                    connectTable[currIdx][colIdx] = false;
                    connectTable[colIdx][currIdx] = false;

                    if (!dfs(colIdx, oppositeType, connectTable, groupList)) {
                        return false;
                    }
                }
            }
        }

        return true;
    }

    private static int oppositeType(int type) {
        if (type == GROUP_A) {
            return GROUP_B;
        }

        if (type == GROUP_B) {
            return GROUP_A;
        }

        assert(false);
        return NOT_VISITED;
    }

    private static int getHighestDegreeVertexIdx(boolean[][] connectTable) {
        int max = 0;
        int maxIdx = -1;

        for (int rowIdx = 0; rowIdx < connectTable.length; rowIdx++) {
            int count = 0;
            for (int colIdx = 0; colIdx < connectTable[0].length; colIdx++) {
                if (connectTable[rowIdx][colIdx]) {
                    count++;
                }
            }
            if (max < count) {
                max = count;
                maxIdx = rowIdx;
            }
        }

        assert(maxIdx != -1);
        return maxIdx;
    }
}
