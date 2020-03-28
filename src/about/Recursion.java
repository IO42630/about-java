

public class Recursion {


    public int sum(int n) {// no loop but uses lots of memory (overall worse performance)
        if (n <= 1) {
            return n;
        }
        return n + sum(n - 1);
    }


    public static void main(String[] args) {
        System.out.println(new Recursion().sum(3));
    }
}
