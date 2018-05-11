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

            Map<Integer, Set<Integer>> adjacencyMap = new HashMap<>();
            for (int edgeIdx = 0; edgeIdx < edgeCountE; edgeIdx++) {
                int edgeAidx = scanner.nextInt() - 1;
                int edgeBidx = scanner.nextInt() - 1;

                safePut(adjacencyMap, edgeAidx, edgeBidx);
                safePut(adjacencyMap, edgeBidx, edgeAidx);
                scanner.nextLine();
            }

            if (isBipartiteGraph(adjacencyMap, vertexCountV)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }

    private static void safePut(Map<Integer, Set<Integer>> edgeList, int stIdx, int edIdx) {
        if (!edgeList.containsKey(stIdx)) {
            edgeList.put(stIdx, new HashSet<>());
        }

        edgeList.get(stIdx).add(edIdx);
    }

    private static boolean isBipartiteGraph(Map<Integer, Set<Integer>> adjacencyMap, int vertexCountV) {
        Map<Integer, Set<Integer>> groupList = new HashMap<>();
        groupList.put(GROUP_A, new HashSet<>());
        groupList.put(GROUP_B, new HashSet<>());

        while (true) {

            int highestDegreeVertexIdx = getHighestDegreeVertexIdx(adjacencyMap);
            if (highestDegreeVertexIdx == -1) {
                break;
            }

            groupList.get(GROUP_A).add(highestDegreeVertexIdx);

            if (!dfs(highestDegreeVertexIdx, GROUP_A, adjacencyMap, groupList)) {
                return false;
            }
        }

        return true;
    }

    private static boolean dfs(int currIdx, int currType,
                               Map<Integer, Set<Integer>> adjacencyMap,
                               Map<Integer, Set<Integer>> groupList) {
        if (!adjacencyMap.containsKey(currIdx)) {
            return true;
        }

        Set<Integer> adjacencies = adjacencyMap.get(currIdx);
        adjacencyMap.remove(currIdx);
        int oppositeType = oppositeType(currType);

        for (int adjacency:
        adjacencies) {
            if (groupList.get(currType).contains(adjacency)) {
                return false;
            } else if (!groupList.get(oppositeType).contains(adjacency)) {
                groupList.get(oppositeType).add(adjacency);

                if (!dfs(adjacency, oppositeType, adjacencyMap, groupList)) {
                    return false;
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

    private static int getHighestDegreeVertexIdx(Map<Integer, Set<Integer>> connectTable) {
        Optional<Integer> maxIdx = connectTable.entrySet()
                .stream()
                .reduce(((entry1, entry2) -> {
                    Set<Integer> value1 = entry1.getValue();
                    Set<Integer> value2 = entry2.getValue();
                    if (value1.size() < value2.size()) {
                        return entry2;
                    } else {
                        return entry1;
                    }
                }))
                .map(Map.Entry::getKey);

        if (!maxIdx.isPresent()) {
            return -1;
        }

        return maxIdx.get();
    }
}
