package ch.hslu.ad.sw03.ex05;

import java.util.Objects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BinaryTree implements Tree<Integer> {

    public static final Logger LOG = LogManager.getLogger(BinaryTree.class);
    private int itemCount;
    private TreeNode root;
    private TreeNode firstNode;
    private TreeNode lastNode;

    public BinaryTree(int data) {
        this.root = new TreeNode(null, null, data);
        firstNode = this.root;
        lastNode = this.root;
        this.itemCount = 1;
    }

    public BinaryTree() {

        this.root = null;
        this.firstNode = null;
        this.lastNode = null;
        itemCount = 0;

        /*TreeNode H = new TreeNode(null, null, 8);
        TreeNode J = new TreeNode(null, null, 10);
        TreeNode I = new TreeNode(H, J, 9);
        TreeNode A = new TreeNode(null, null, 1);
        TreeNode F = new TreeNode(A, I, 6);
        TreeNode Q = new TreeNode(null, null, 17);
        TreeNode R = new TreeNode(Q, null, 18);
        TreeNode M = new TreeNode(null, null, 13);
        TreeNode P = new TreeNode(M, R, 16);
        this.root = new TreeNode(F, P, 11);
        */

    }


    @Override
    public boolean search(Integer item) {
        TreeNode current = root;
        if (root == null) {
            return false;
        } else {

            while (current != null) {
                if (current.getData() == item) {
                    return true;
                } else if (current.getData() > item) {
                    current = current.getLeftChild();
                } else {
                    current = current.getRightChild();
                }
            }
            return false;
        }
    }


    @Override
    public void insert(Integer item) {
        TreeNode current = root;
        TreeNode newNode = new TreeNode(null, null, item);

        if (this.search(item) == false) {

            if (root == null) {
                root = newNode;
            } else {
                while (current != null) {
                    if (current.getData() > item) {
                        if (current.getLeftChild() != null) {
                            current = current.getLeftChild();
                        } else {
                            current.setLeftChild(newNode);
                            this.firstNode = newNode;
                            itemCount++;
                            return;
                        }

                    } else {
                        if (current.getRightChild() != null) {
                            current = current.getRightChild();
                        } else {
                            current.setRightChild(newNode);
                            this.lastNode = newNode;
                            itemCount++;
                            return;
                        }

                    }
                }
            }
        } else {
            throw new IllegalArgumentException("Cannot add item to this datastructure, because it's already available.");
        }


    }

    public void traversTreeInorder() {
        if (root != null) {
            recursiveTraversTreeInorder(root);
        } else {
            LOG.error("Cannot traverse an empty tree! Please insert a value.");
        }
    }

    public void traversTreePreorder() {
        if (root != null) {
            recursiveTraversTreePreorder(root);
        } else {
            LOG.error("Cannot traverse an empty tree! Please insert a value.");
        }
    }

    public void traversTreePostorder() {
        if (root != null) {
            recursiveTraversTreePostorder(root);
        } else {
            LOG.error("Cannot traverse an empty tree! Please insert a value.");
        }
    }


    @Override
    public void remove(Integer item) {

        TreeNode parent = null;
        TreeNode curr = root;

        if (this.search(item) == true) {

            while (curr != null) {

                if (curr.getData() == item) {
                    if (curr.getLeftChild() == null && curr.getRightChild() == null) {
                        if (parent.getLeftChild() == curr) {
                            parent.setLeftChild(null);
                            return;
                        } else {
                            parent.setRightChild(null);
                            return;
                        }
                    } else if (curr.getLeftChild() != null) {

                    } else if (curr.getRightChild() != null) {

                    } else {

                    }
                } else if (curr.getData() > item) {
                    parent = curr;
                    curr = curr.getLeftChild();
                } else {
                    parent = curr;
                    curr = curr.getRightChild();
                }


            }


        }


    }

    @Override
    public Integer first() {
        return this.firstNode.getData();
    }

    @Override
    public Integer last() {
        return this.lastNode.getData();
    }


    @Override
    public Integer ceiling(Integer item) {
        return null;
    }

    @Override
    public Integer higher(Integer item) {
        return null;
    }

    @Override
    public Integer lower(Integer item) {
        return null;
    }

    @Override
    public Integer size() {
        return this.itemCount;
    }

    private void recursiveTraversTreeInorder(TreeNode node) {
        if (node.getLeftChild() != null) {
            recursiveTraversTreeInorder(node.getLeftChild());
        }
        System.out.println(node.getData());
        if (node.getRightChild() != null) {
            recursiveTraversTreeInorder(node.getRightChild());
        }
    }

    private void recursiveTraversTreePreorder(TreeNode node) {
        System.out.println(node.getData());
        if (node.getLeftChild() != null) {
            recursiveTraversTreePreorder(node.getLeftChild());
        }
        if (node.getRightChild() != null) {
            recursiveTraversTreePreorder(node.getRightChild());
        }
    }

    private void recursiveTraversTreePostorder(TreeNode node) {
        if (node.getLeftChild() != null) {
            recursiveTraversTreePostorder(node.getLeftChild());
        }
        if (node.getRightChild() != null) {
            recursiveTraversTreePostorder(node.getRightChild());
        }
        System.out.println(node.getData());
    }


}