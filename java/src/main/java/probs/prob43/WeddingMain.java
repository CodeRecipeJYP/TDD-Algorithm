package probs.prob43;

import java.util.*;

public class WeddingMain {
    private static final Integer MYSELF = 0;
    private static int TARGET_DEPTH = 1;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int studentCountN = scanner.nextInt();
        scanner.nextLine();

        int relationCountM = scanner.nextInt();
        scanner.nextLine();

        boolean[][] relationTable = new boolean[studentCountN][studentCountN];
        for (int relationIdx = 0; relationIdx < relationCountM; relationIdx++) {
            int relationAidx = scanner.nextInt() - 1;
            int relationBidx = scanner.nextInt() - 1;
            relationTable[relationAidx][relationBidx] = true;
            relationTable[relationBidx][relationAidx] = true;
        }

        System.out.println(bfs(relationTable));
    }

    private static int bfs(boolean[][] relationTable) {
        List<Integer> currArr = new ArrayList<>();
        Set<Integer> uniqueSet = new HashSet<>();
        currArr.add(MYSELF);
        uniqueSet.add(MYSELF);
        int count = 0;

        for (int depth = 0; depth <= TARGET_DEPTH; depth++) {
            List<Integer> nextArr = new ArrayList<>();

            for (int eachStudent :
                    currArr) {
                for (int studentIdx = 0; studentIdx < relationTable.length; studentIdx++) {
                    if (relationTable[eachStudent][studentIdx]) {
                        if (uniqueSet.contains(studentIdx)) {
                            continue;
                        }

                        uniqueSet.add(studentIdx);
                        nextArr.add(studentIdx);
                        count++;
                    }
                }
            }

            currArr = nextArr;
        }

        return count;
    }
}
