package probs.prob11_retrievetree;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RetrieveTree {
    /**
     * 문제
     * n개의 정점을 갖는 이진 트리의 정점에 1부터 n까지의 번호가 중복 없이 매겨져 있다. 이와 같은 이진 트리의 인오더와 포스트오더가 주어졌을 때, 프리오더를 구하는 프로그램을 작성하시오.
     *
     * 입력
     * 첫째 줄에 n(1≤n≤100,000)이 주어진다. 다음 줄에는 인오더를 나타내는 n개의 자연수가 주어지고, 그 다음 줄에는 같은 식으로 포스트오더가 주어진다.
     *
     * 출력
     * 첫째 줄에 프리오더를 출력한다.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberCount = Integer.parseInt(scanner.nextLine());
        ArrayList<Integer> inOrders = new ArrayList<>();
        ArrayList<Integer> postOrders = new ArrayList<>();

        for (int currentCount = 0; currentCount < numberCount; currentCount++) {
            inOrders.add(scanner.nextInt());
        }

        for (int currentCount = 0; currentCount < numberCount; currentCount++) {
            postOrders.add(scanner.nextInt());
        }
        printListOnSingleLine(estimatePreOrder(inOrders, postOrders));
    }

    public static List<Integer> estimatePreOrder(List<Integer> inOrders, List<Integer> postOrders) {
        Tree tree = estimateTree(inOrders, postOrders);

        return tree.getRoot().retrievePreOrder();
    }

    public static Tree estimateTree(List<Integer> inOrders, List<Integer> postOrders) {
        int inorderValue = inOrders.get(0);

        Tree firstNode = new Tree(inorderValue);

        for (int postIdx = 0; postIdx < postOrders.size(); postIdx++) {
            if (inorderValue == postOrders.get(postIdx)) {
                if (postIdx != 0) {
                    List<Integer> rightChildrenPostOrders = postOrders.subList(0, postIdx);
                    List<Integer> rightChildrenInOrders = inOrders.subList(1, postIdx + 1);

                    Tree rightTree = estimateTree(rightChildrenInOrders,
                            rightChildrenPostOrders);
                    System.out.println("rightChildrenPostOrders=" + rightChildrenPostOrders.toString());
                    System.out.println("rightChildrenInOrders=" + rightChildrenInOrders.toString());
                    System.out.println("rightTree=" + rightTree.toString());

                    firstNode.setRightTree(rightTree);
                }

                if (postIdx != postOrders.size() - 1) {
                    List<Integer> parentPostOrders = postOrders.subList(postIdx + 1, postOrders.size());
                    List<Integer> parentInOrders = inOrders.subList(postIdx + 1, inOrders.size());

                    Tree parentNode = estimateTree(parentInOrders, parentPostOrders);

                    System.out.println("parentPostOrders=" + parentPostOrders.toString());
                    System.out.println("parentInOrders=" + parentInOrders.toString());
                    firstNode.setRightParent(
                            parentNode
                    );
                    System.out.println("parentNode=" + parentNode.toString());
                    System.out.println("firstNode=" + firstNode.toString());
                }

                break;
            }
        }

        return firstNode;
    }

    private static void printListOnSingleLine(List<Integer> list) {
        list.stream()
                .map(it -> it + " ")
                .forEach(System.out::println);
    }

    static class Tree {
        public static List<Tree> sTrees = new ArrayList<>();
        private Tree mLeft = null;
        private Tree mRight = null;
        private Tree mParent = null;
        private Integer mVal = null;

        public Tree(int val) {
            this.mVal = val;
            sTrees.add(this);
        }

        public Integer getVal() {
            return mVal;
        }

        public void setVal(Integer val) {
            this.mVal = val;
        }

        public Tree getLeft() {
            return mLeft;
        }

        public void setLeft(Tree left) {
            this.mLeft = left;
            if (left.getParent() == null) {
                left.setParent(this);
            }
        }

        public Tree getRight() {
            return mRight;
        }

        public void setRight(Tree right) {
            this.mRight = right;
            if (right.getParent() == null) {
                right.setParent(this);
            }
        }

        public Tree getRoot() {
            Tree currParent = this;
            while (true) {
                Tree parent = currParent.getParent();
                if (parent == null) {
                    break;
                }

                currParent = parent;
            }

            return currParent;
        }

        public void setRightParent(Tree parent) {
            this.mParent = parent;
            parent.setLeft(this);
        }

        public Tree getParent() {
            return this.mParent;
        }

        public List<Integer> retrievePreOrder() {
            ArrayList<Integer> orders = new ArrayList();
            orders.add(getVal());
            orders.addAll(Tree.retrievePreOrder(getLeft()));
            orders.addAll(Tree.retrievePreOrder(getRight()));

            return orders;
        }

        public static List<Integer> retrievePreOrder(Tree node) {
            if (node != null) {
                return node.retrievePreOrder();
            } else {
                return List.of();
            }
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("Tree{");
            sb.append(" mVal=" + mVal);
            if (mLeft != null) {
                sb.append(" mLeft=" + mLeft);
            }

            if (mRight != null) {
                sb.append(" mRight=" + mRight);
            }

            if (mParent != null) {
                sb.append(" mParentVal=" + mParent.getVal());
            }
            sb.append("}");

            return sb.toString();
        }

        public void setRightTree(Tree rightTree) {
            this.mRight = rightTree.getRoot();
        }

        public void setParent(Tree parent) {
            this.mParent = parent;
        }
    }
}
