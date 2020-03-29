package collections;

public interface ListCopy<E> extends CollectionCopy {

    /**
     * Inserts the specified element at the specified position in this list
     */
    void add​(int index, E element);

    /**
     * Replaces the element at the specified position in this list with the specified element<p>
     * Returns the element previously at the specified position
     */
    E set​(int index, E element);

    /**
     * Returns the element previously at the specified position
     */
    E remove​(int index);
}