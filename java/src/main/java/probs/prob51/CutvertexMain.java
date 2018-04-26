package probs.prob51;

import java.util.*;

public class CutvertexMain {
    private static final int VERTEX_QUERY = 1;
    private static final int BRIDGE_QUERY = 2;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int vertexCountN = scanner.nextInt();
        scanner.nextLine();

        List<Bridge> bridgeList = new ArrayList<>(vertexCountN - 1);
        Map<Integer, List<Integer>> bridgeListByVertex = new HashMap<>();
        initializeMap(bridgeListByVertex, vertexCountN);

        for (int vertexIdx = 0; vertexIdx < vertexCountN - 1; vertexIdx++) {
            int vertexAidx = scanner.nextInt() - 1;
            int vertexBidx = scanner.nextInt() - 1;
            bridgeList.add(new Bridge(vertexAidx, vertexBidx));

            bridgeListByVertex.get(vertexAidx).add(vertexBidx);
            bridgeListByVertex.get(vertexBidx).add(vertexAidx);

            scanner.nextLine();
        }

        int queryCountQ = scanner.nextInt();
        scanner.nextLine();

        for (int queryIdx = 0; queryIdx < queryCountQ; queryIdx++) {
            int queryType = scanner.nextInt();
            int targetIdx = scanner.nextInt() - 1;
            boolean result = false;

            if (queryType == VERTEX_QUERY) {
                result = isCutVertex(bridgeListByVertex, targetIdx);
            } else if (queryType == BRIDGE_QUERY) {
                result = isCutBridge(bridgeListByVertex, bridgeList.get(targetIdx));
            } else {
                assert(false);
            }

            scanner.nextLine();
            if (result) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }
        }
    }

    private static void initializeMap(Map<Integer, List<Integer>> bridgeListByVertex, int size) {
        for (int vertexIdx = 0; vertexIdx < size; vertexIdx++) {
            bridgeListByVertex.put(vertexIdx, new ArrayList<>());
        }
    }

    private static boolean isCutVertex(Map<Integer, List<Integer>> bridgeListByVertex, int targetIdx) {
        int connectedBridgeCount = new HashSet(bridgeListByVertex.get(targetIdx)).size();
        return (connectedBridgeCount >= 2);
    }

    private static boolean isCutBridge(Map<Integer, List<Integer>> bridgeListByVertex, Bridge bridge) {
        Integer count = bridgeListByVertex.get(bridge.start).stream()
                .filter(it -> it == bridge.end)
                .reduce(0, (i1, i2) -> i1 + 1);

        return count == 1;
    }

    static class Bridge {
        int start;
        int end;

        public Bridge(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}
