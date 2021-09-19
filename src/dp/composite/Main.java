package dp.composite;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: yangzhiyao
 * @DateTime: 2021/9/19 21:08
 */
public class Main {
    public static void main(String[] args) {
        BranchNode root = new BranchNode("root");
        BranchNode chapter1 = new BranchNode("chapter1");
        BranchNode chapter2 = new BranchNode("chapter2");
        Node c11 = new LeafNode("c11");
        Node c12 = new LeafNode("c12");
        BranchNode b21 = new BranchNode("section21");
        Node c211 = new LeafNode("c211");
        Node c212 = new LeafNode("c212");

        root.add(chapter1);
        root.add(chapter2);
        chapter1.add(c11);
        chapter1.add(c12);
        chapter2.add(b21);
        b21.add(c211);
        b21.add(c212);

        tree(root, 0);
    }

    private static void tree(Node root, int depth) {
        for (int i = 0; i < depth; i++) {
            System.out.print("--");
        }
        root.p();
        if (root instanceof BranchNode) {
            for (Node node : ((BranchNode) root).nodeList) {
                tree(node, depth + 1);
            }
        }
    }
}

abstract class Node {
    abstract void p();
}

class LeafNode extends Node {
    private String name;

    public LeafNode(String name) {
        this.name = name;
    }

    @Override
    void p() {
        System.out.println(name);
    }
}

class BranchNode extends Node {
    private String name;
    List<Node> nodeList;

    public BranchNode(String name) {
        this.name = name;
        nodeList = new ArrayList<>();
    }

    @Override
    void p() {
        System.out.println(name);
    }

    public void add(Node node) {
        nodeList.add(node);
    }
}
