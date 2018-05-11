package probs.prob50;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TreeMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int nodeCountN = scanner.nextInt();
        scanner.nextLine();

        List<Node> nodeList = new ArrayList<>(nodeCountN);
        List<Node> rootNodeList = new ArrayList<>();

        for (int nodeIdx = 0; nodeIdx < nodeCountN; nodeIdx++) {
            nodeList.add(new Node());
        }

        for (int nodeIdx = 0; nodeIdx < nodeCountN; nodeIdx++) {
            Node currNode = nodeList.get(nodeIdx);
            int parentIdx = scanner.nextInt();

            Node parentNode = null;
            if (parentIdx == -1) {
                rootNodeList.add(currNode);
                continue;
            }

            parentNode = nodeList.get(parentIdx);

            currNode.parent = parentNode;
            parentNode.children.add(currNode);
        }

        scanner.nextLine();

        int targetIdx = scanner.nextInt();
        Node targetNode = nodeList.get(targetIdx);
        if (targetNode.isRoot()) {
            rootNodeList.remove(targetNode);
        } else {
            nodeList.get(targetIdx).delete();
        }


        int countSum = 0;
        for (Node rootNode:
                rootNodeList) {
            countSum += getLeafnodeCount(rootNode);
        }

        System.out.println(countSum);
    }

    private static int getLeafnodeCount(Node rootNode) {
        int count = 0;

        if (rootNode.children.size() == 0) {
            return 1;
        }

        for (Node child:
             rootNode.children) {
            count += getLeafnodeCount(child);
        }

        return count;
    }

    static class Node {
        Node parent = null;
        List<Node> children = new ArrayList<>();

        public boolean isRoot() {
            return parent == null;
        }

        public void delete() {
            if (parent == null) {
                return;
            }

            parent.children.remove(this);
        }
    }
}
