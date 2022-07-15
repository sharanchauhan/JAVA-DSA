import java.util.*;

public class Main {
    public static int fib_rec(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        int ans = fib_rec(n - 1) + fib_rec(n - 2);
        return ans;
    }

    public static void main(String args[]) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        System.out.println(fib_rec(n));
        scn.close();
    }
}