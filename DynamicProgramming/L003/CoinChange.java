import java.util.*;

class Main {

    public static void main(String[] args) throws Exception {
        Scanner s=new Scanner(System.in);
        int n=s.nextInt();
        int coins[]=new int[n];
        for(int i=0;i<n;i++)
        {
            coins[i]=s.nextInt();
        }
        int amt=s.nextInt();
        int[] dp = new int[amt + 1];
        dp[0] = 1;

        for (int coin : coins) {
            for (int i = coin; i < dp.length; i++) {
                dp[i] += dp[i - coin];
            }
        }
        System.out.println(dp[amt]);
        s.close();
    }
}