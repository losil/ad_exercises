package ch.hslu.ad.sw04.ex01;

/**
 * This interface provides methods which are required for a class to work as a Set.
 *
 * @param <E> Generic implementation allows different Objects.
 */
public interface Set<E> {

    boolean add(E item);

    boolean contains(E item);

    boolean remove(E item);

    boolean isEmpty();

    boolean isFull();

    /** This method should return the actual count of elements in this set.
     * @return Returns the actual element count as an integer.
     */
    int size();

}
