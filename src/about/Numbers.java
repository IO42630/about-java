package about;

public class Numbers {

	public static void main(String args[]) {

		double x1 = 1 / 2;
		System.out.println(x1);//0.0
		double x2 = 1.0 / 2;
		System.out.println(x2);//0.5
		double x3 = 1 / 2.0;
		System.out.println(x3);//0.5
		
		double x4 = 5 / 2;
		System.out.println(x4);//2.0	arrondie vers 0
		double x5 = -5 / 2;
		System.out.println(x5);//-2.0
		
		// static variables are shared among all instances of a class
		int c = (int)2.0; 
		//int d = 2.0; //error

		double w = (double)1/2;//0.5
		double w2 = (double)(1/2);//0.0

		double y2 = Math.sqrt(2.0);
		
		int b4 =0;// primitive type, mutable, 2==2 true
		// value  stocked in the variable
		Integer b5 = 0;// class, immutable, 2==2 false
		// pointer stored in the variable
		boolean t = b5.equals(b5);// only true if b5 != null
		
		Object o= null;
		String s=null;
		s = (String)o;
		o = (Object) s;


		
	}

}
