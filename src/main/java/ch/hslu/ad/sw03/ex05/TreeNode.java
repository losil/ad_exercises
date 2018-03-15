package ch.hslu.ad.sw03.ex05;

import java.util.Objects;

public class TreeNode {
    private TreeNode parent;
    private TreeNode leftChildren;
    private TreeNode rightChildren;
    private String data;


    public TreeNode() {
        this(null, null, null);
    }

    public TreeNode(TreeNode rightChild, TreeNode leftChild, String data) {
        this.parent = parent;
        this.leftChildren = leftChild;
        this.rightChildren = rightChild;
        this.data = data;
    }

    public TreeNode getParent() {
        return parent;
    }

    public void setParent(TreeNode parent) {
        this.parent = parent;
    }

    public TreeNode getLeftChildren() {
        return leftChildren;
    }

    public void setLeftChildren(TreeNode leftChildren) {
        this.leftChildren = leftChildren;
    }

    public TreeNode getRightChildren() {
        return rightChildren;
    }

    public void setRightChildren(TreeNode rightChildren) {
        this.rightChildren = rightChildren;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TreeNode)) return false;
        TreeNode treeNode = (TreeNode) o;
        return Objects.equals(data, treeNode.data);
    }

    @Override
    public int hashCode() {

        return Objects.hash(data);
    }
}
