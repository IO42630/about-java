package about;

/*
 * Advantages: 
 *  > basic method library usable on different object types
 *  > avoid overcharging (using multiple methods with same name but different input type)
 *		> same name and same argument tyes not ok, even if differnt return type
 */
public class Generics {
	public static void main(String[] args) {
	}
}

/*
 * "Generic Method"
 */
class Demo1 {
	<T extends Comparable<T>> T haste(T in) {
		T a = null;
		int i = a.compareTo(in);

		return a;
	}
}

/*
 * "Generic Class"
 * 
 * (1) generic type declaration, introduces the type variable, T, that can be
 * used anywhere inside the class
 * 
 * (2) generic type invocation " parameterized type", which replaces T with some
 * concrete value, such as Integer
 * 
 * 
 * E - Element K - Key N - Number T - Type V - Value
 */
class Demo2 {
	Box<Integer> integerBox = new Box<Integer>(4);// (2)
	// Box<T>[] abc = new Box<T>[2]; not possible, arrays must be of specific
	// type

	class Box<T> {// (1)
		Box(int n) {

		}
		class Boxx {
			Object T = new Object();
			int a = 4;
		}
	}

}


