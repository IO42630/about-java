package generics;

/**
 * this is a dispenser, which consists of E's
 */
interface Dispenser<E> {

	 void put(E item);

	 E remove();

	 void print();
}
