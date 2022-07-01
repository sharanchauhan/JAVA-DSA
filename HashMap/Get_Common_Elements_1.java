import java.util.HashMap;
import java.util.Scanner;

class Get_Common_Elements_1 {
    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner s = new Scanner(System.in);
        HashMap<Integer, Integer> hm = new HashMap<>();
        int n1 = s.nextInt();
        for (int i = 0; i < n1; i++) {
            hm.put(s.nextInt(), 0);
        }
        int n2 = s.nextInt();
        int arr[] = new int[n2];
        for (int i = 0; i < n2; i++) {
            arr[i] = s.nextInt();
        }

        for (int i = 0; i < n2; i++) {
            if (hm.containsKey(arr[i])) {
                System.out.println(arr[i]);
                hm.remove(arr[i]);
            }
        }
        s.close();
    }
}
