package ch.hslu.ad.sw03.ex05;

import java.util.Objects;

public final class TreeNode {

    private TreeNode leftChild;
    private TreeNode rightChild;
    private int data;
    private int hash;

    public TreeNode(TreeNode leftChild, TreeNode rightChild, int data) {
        this.leftChild = leftChild;
        this.rightChild = rightChild;
        this.data = data;
        hash = this.hashCode();
    }

    public TreeNode(int data) {
        this(null, null, data);
    }

    public TreeNode() {
        this(null, null, 0);
    }

    public TreeNode getRightChild() {
        return rightChild;
    }

    public void setRightChild(TreeNode rightChild) {
        this.rightChild = rightChild;
    }

    public TreeNode getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(TreeNode leftChild) {
        this.leftChild = leftChild;
    }


    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "leftChild=" + leftChild +
                ", rightChild=" + rightChild +
                ", data='" + data + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }

        if (!(obj instanceof TreeNode)) {
            return false;
        }

        TreeNode other = (TreeNode) obj;
        return other.getData() == this.getData() && Objects.equals(other.leftChild, this.leftChild) && Objects.equals(other.rightChild, this.rightChild);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.data, this.leftChild, this.rightChild);
    }


}