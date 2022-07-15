import java.util.*;

public class Main {
    public static int fib_rec(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        int ans = fib_rec(n - 1) + fib_rec(n - 2);
        return ans;
    }

    public static int fib_mem(int n, int[] mem) {
        if (n == 0 || n == 1) {
            return mem[n] = n;
        }
        if (mem[n] != 0) { // already calculated
            return mem[n];
        }
        int ans = fib_mem(n - 1, mem) + fib_mem(n - 2, mem);
        return mem[n] = ans;
    }

    public static void main(String args[]) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        System.out.println(fib_rec(n));
        System.out.println(fib_mem(n, new int[n + 1]));
        scn.close();
    }
}