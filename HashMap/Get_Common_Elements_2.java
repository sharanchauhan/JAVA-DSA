import java.util.HashMap;
import java.util.Scanner;

public class Get_Common_Elements_2 {
    public static void main(String[] args) throws Exception {

        Scanner scn = new Scanner(System.in);
        int n1 = scn.nextInt();
        int[] a1 = new int[n1];
        for (int i = 0; i < n1; i++) {
            a1[i] = scn.nextInt();
        }
        int n2 = scn.nextInt();
        int[] a2 = new int[n2];
        for (int i = 0; i < n2; i++) {
            a2[i] = scn.nextInt();
        }

        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int val : a1) {
            if (hm.containsKey(val)) {
                hm.put(val, hm.get(val) + 1);
            } else {
                hm.put(val, 1);
            }
        }
        for (int val : a2) {
            if (hm.containsKey(val)) {
                System.out.println(val);
                if (hm.get(val) > 1)
                    hm.put(val, hm.get(val) - 1);
                else
                    hm.remove(val);
            }
        }
        scn.close();
    }
}
