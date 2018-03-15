package ch.hslu.ad.sw03.ex05;

import java.util.Objects;

public class BinaryTree implements Tree<String> {

    private int itemCount;
    private TreeNode root;
    private TreeNode firstItem;
    private TreeNode lastItem;

    public BinaryTree(TreeNode root) {
        this.itemCount = 0;
        this.root = root;
        this.firstItem = root;
        this.lastItem = root;
    }

    public static BinaryTree createStaticTree() {
        BinaryTree staticTree = new BinaryTree();

        staticTree.root = new TreeNode(NewTreeNode(), new TreeNode(), "K");
    }

    public int getItemCount() {
        return itemCount;
    }

    public void setItemCount(int itemCount) {
        this.itemCount = itemCount;
    }

    public TreeNode getFirstItem() {
        return firstItem;
    }

    public void setFirstItem(TreeNode firstItem) {
        this.firstItem = firstItem;
    }

    public TreeNode getLastItem() {
        return lastItem;
    }

    public void setLastItem(TreeNode lastItem) {
        this.lastItem = lastItem;
    }

    @Override
    public String getRoot() {
        return null;
    }

    public void setRoot(TreeNode root) {
        this.root = root;
    }

    @Override
    public String first() {
        return null;
    }

    @Override
    public String last() {
        return null;
    }

    @Override
    public String higher(String s) {
        return null;
    }

    @Override
    public String lower(String s) {
        return null;
    }

    @Override
    public String ceiling(String s) {
        return null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BinaryTree)) return false;
        BinaryTree that = (BinaryTree) o;
        return itemCount == that.itemCount &&
                Objects.equals(root, that.root) &&
                Objects.equals(firstItem, that.firstItem) &&
                Objects.equals(lastItem, that.lastItem);
    }

    @Override
    public int hashCode() {

        return Objects.hash(itemCount, root, firstItem, lastItem);
    }

    @Override
    public String toString() {
        return "BinaryTree{" +
                "itemCount=" + itemCount +
                ", root=" + root +
                ", firstItem=" + firstItem +
                ", lastItem=" + lastItem +
                '}';
    }
}
