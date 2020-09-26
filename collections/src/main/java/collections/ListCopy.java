package collections;

public interface ListCopy<E> extends CollectionCopy<E> {

    /**
     * Insert at the end.
     */
    @Override
    boolean add(E e);




    /**
     * Inserts the specified element at the specified position in this list
     */
    void add​(int index, E element);


    E get(int index);

    int indexOf(Object o);

    int lastIndexOf(Object o);

    /**
     * Returns the element previously at the specified position
     */
    E remove​(int index);


    /**
     * Replaces the element at the specified position in this list with the specified element<p>
     * Returns the element previously at the specified position
     */
    E set​(int index, E element);


}
