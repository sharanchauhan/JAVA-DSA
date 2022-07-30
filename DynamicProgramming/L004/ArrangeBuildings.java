import java.util.*;

class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        long n = scn.nextLong();
        scn.close();
        long ob = 1;
        long os = 1;
        for (int i = 2; i <= n; i++) {
            long nb = os;
            long ns = os + ob;

            ob = nb;
            os = ns;
        }
        long total = ob + os;
        System.out.println(total * total);
    }

}
