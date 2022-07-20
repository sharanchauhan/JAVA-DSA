import java.util.*;

class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner s=new Scanner(System.in);
        int n=s.nextInt();
        int m=s.nextInt();
        int arr[][]=new int[n][m];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                arr[i][j]=s.nextInt();
            }
        }
        s.close();
        int cost=minCost(arr);
        System.out.println(cost);
    }

    public static int minCost(int cost[][])
    {
        int nr = cost.length , nc = cost[0].length;
        int mem[][] = new int[nr][nc];

        for(int r = nr-1 ; r >= 0 ; r--){
            for(int c = nc-1; c >= 0 ; c--){
                if(r == nr-1 && c == nc-1){
                    mem[r][c] = cost[r][c];
                }else if(r == nr-1){
                    mem[r][c] = mem[r][c+1] + cost[r][c];
                }else if(c == nc-1){
                    mem[r][c] = mem[r+1][c] + cost[r][c];
                }else{
                    mem[r][c] = Math.min(mem[r][c+1],mem[r+1][c])+cost[r][c];
                }
            }
        }
        return mem[0][0];
    }
}