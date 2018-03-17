package ch.hslu.ad.sw03.ex05;

public class Main {

    public static void main(String[] args) {


        BinaryTree dynamicTree = new BinaryTree(5);
        dynamicTree.insert(4);
        dynamicTree.insert(20);
        dynamicTree.insert(19);
        dynamicTree.insert(1);
        dynamicTree.remove(1);
        dynamicTree.traversTreeInorder();

        TreeNode node = new TreeNode(1);
        System.out.println(node.hashCode());


    }
}