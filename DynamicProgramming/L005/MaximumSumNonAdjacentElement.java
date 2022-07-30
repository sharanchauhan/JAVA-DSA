import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner s=new Scanner(System.in);
        int n=s.nextInt();
        int arr[]=new int[n];
        for(int i=0;i<n;i++)
        {
            arr[i]=s.nextInt();
        }
        int inc=arr[0];
        int exc=0;
        for(int i=1;i<n;i++)
        {
            int ninc=exc+arr[i];
            int nexc=Math.max(inc,exc);

            inc=ninc;
            exc=nexc;
        }
        System.out.println(Math.max(inc,exc));
    }
}