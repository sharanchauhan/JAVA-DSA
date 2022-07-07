import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static class Edge
    {
        int src,nbr;
        Edge(int src,int nbr)
        {
            this.src=src;
            this.nbr=nbr;
        }
    }
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        int nvtces=s.nextInt();
        ArrayList<Edge>[] graph=new ArrayList[nvtces];
        for(int i=0;i<nvtces;i++)
        {
            graph[i]=new ArrayList<>();
        }
        int nedges=s.nextInt();
        for (int i = 1; i <= nedges; i++) {
            int v1=s.nextInt();
            int v2=s.nextInt();
            graph[v1].add(new Edge(v1, v2));
            graph[v2].add(new Edge(v2, v1));
        }

        for (ArrayList<Edge> list : graph) {
            for (Edge e : list) {
                System.out.println(e.src+"->"+e.nbr);
            }
        }
        s.close();
    }
}


/*
7
8
0 1
1 2
2 3
0 3
3 4
4 5
5 6
4 6
*/