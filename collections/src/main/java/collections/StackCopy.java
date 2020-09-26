package collections;

public interface StackCopy {

    boolean empty();

    /**
     * Returns the element on the top of the stack, but does not remove it.
     */
    Object peek();

    /**
     * Returns the element on the top of the stack, removing it in the process.
     */
    Object pop();

}
