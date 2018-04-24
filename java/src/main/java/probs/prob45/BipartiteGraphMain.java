package probs.prob45;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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
        int[] vertexTypeArr = new int[vertexCountV];

        List<Integer> currDepthVertexes = new ArrayList<>();
        int currType = GROUP_A;

        int highestDegreeVertexIdx = getHighestDegreeVertexIdx(connectTable);
        currDepthVertexes.add(highestDegreeVertexIdx);
        vertexTypeArr[highestDegreeVertexIdx] = currType;

        while (!currDepthVertexes.isEmpty()) {
            List<Integer> nextDepthVertex = new ArrayList<>();
            for (int currDepthVertex :
                    currDepthVertexes) {

                for (int colIdx = 0; colIdx < connectTable[0].length; colIdx++) {
                    if (connectTable[currDepthVertex][colIdx]) {
                        int oppositeType = oppositeType(currType);
                        if (vertexTypeArr[colIdx] == NOT_VISITED) {
                            vertexTypeArr[colIdx] = oppositeType;
                            nextDepthVertex.add(colIdx);
                        }

                        if (vertexTypeArr[colIdx] == currType) {
                            return false;
                        }
                    }
                }
            }

            currType = oppositeType(currType);
            currDepthVertexes = nextDepthVertex;
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
