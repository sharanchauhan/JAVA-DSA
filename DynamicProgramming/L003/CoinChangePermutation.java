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
        int tar=s.nextInt();
        int dp[]=new int[tar+1];
        dp[0]=1;
        for(int amt=1;amt<=tar;amt++)
        {
            for(int coin : coins) 
            {
                if(coin<=amt)
                {
                    int ramt=amt-coin;
                    dp[amt]+=dp[ramt];
                }
            }
        }
        s.close();
        System.out.println(dp[tar]);
    }
}