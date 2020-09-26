package collections;

public interface CollectionCopy<E> {


    /**
     * Returns true if this collection changed as a result of the call
     */
    boolean add(E e);

    /**
     * Returns true if an element was removed as a result of this call
     */
    boolean remove​(Object o);

    /**
     * Returns the number of elements in this collection
     */
    int size();

    /**
     * Returns true if this collection contains no elements
     */
    boolean isEmpty();


    /**
     * Removes all of the elements from this collection
     */
    void clear();
}
