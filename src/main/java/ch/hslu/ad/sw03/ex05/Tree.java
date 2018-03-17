package ch.hslu.ad.sw03.ex05;

public interface Tree<E> {
    boolean search(E item);

    void insert(E item);

    void remove(E item);

    E size();
    E first();
    E last();

    E ceiling(E item);

    E higher(E item);

    E lower(E item);
}
