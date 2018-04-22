package probs.prob37;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LeafnodeMain {
    public static void main(String[] args) {
        try {
            System.setIn(new FileInputStream("src/main/java/probs/prob37/case01.in"));
            System.setIn(new FileInputStream("src/main/java/probs/prob37/case02.in"));
            System.setIn(new FileInputStream("src/main/java/probs/prob37/case03.in"));
        } catch (FileNotFoundException ignored) {
        }

        Scanner scanner = new Scanner(System.in);
        int nodeCount = scanner.nextInt();
        scanner.nextLine();

        List<Node> nodeList = new ArrayList<>();
        List<Node> roots = new ArrayList<>();
        for (int nodeIdx = 0; nodeIdx < nodeCount; nodeIdx++) {
            nodeList.add(new Node());
        }

        for (int nodeIdx = 0; nodeIdx < nodeCount; nodeIdx++) {
            int parent = scanner.nextInt();
            Node currNode = nodeList.get(nodeIdx);
            if (parent == -1) {
                roots.add(currNode);
            } else {
                currNode.setParent(nodeList.get(parent));
            }

            nodeList.add(currNode);
        }

        scanner.nextLine();
        int removeTargetNodeIdx = scanner.nextInt();
        Node removeTargetNode = nodeList.get(removeTargetNodeIdx);
        roots.remove(removeTargetNode);
        removeTargetNode.remove();

        int leafCount = 0;
        for (Node root :
                roots) {

            leafCount += getLeafCount(root);
        }

        System.out.println(leafCount);
    }

    private static int getLeafCount(Node node) {
        int count = 0;

        if (node.children.size() == 0) {
            return 1;
        }

        for (Node child :
                node.children) {
            count += getLeafCount(child);
        }

        return count;
    }

    static class Node {
        List<Node> children = new ArrayList<>();
        Node parent;

        public Node() {
        }

        public void remove() {
            if (this.parent != null) {
                this.parent.children.remove(this);
            }

            for (Node child:
            this.children) {
                child.parent = null;
            }

            this.children.clear();
        }

        public void setParent(Node parent) {
            this.parent = parent;
            parent.children.add(this);
        }
    }
}
