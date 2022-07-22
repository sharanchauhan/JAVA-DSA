import java.util.*;

public class CountBinaryStrings {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int dp[][] = new int[2][n + 1];
        for (int i = 1; i <= n; i++) {
            if (i == 1) {
                dp[0][i] = dp[1][i] = 1;
            } else {
                dp[0][i] += dp[1][i - 1];
                dp[1][i] = dp[1][i - 1] + dp[0][i - 1];
            }
        }
        System.out.println(dp[0][n] + dp[1][n]);
        s.close();
    }

}