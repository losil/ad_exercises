package ch.hslu.ad.sw03.ex05;

public interface Tree<E> {

    /**
     * Returns root element of the Tree.
     *
     * @return root
     */
    E getRoot();

    /**
     * Returns first elemement of tree;
     *
     * @return first
     */
    E first();

    /**
     * Returns last element of the list.
     *
     * @return last
     */
    E last();


    /**
     * Goes one higher
     *
     * @param e
     * @return
     */
    E higher(E e);

    /**
     * Step lower in the tree.
     *
     * @param e
     * @return
     */
    E lower(E e);

    /**
     * do something
     *
     * @param e
     * @return
     */
    E ceiling(E e);
}
