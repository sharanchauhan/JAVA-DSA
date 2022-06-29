public class Main {
    public static class Node
    {
        int data;
        Node left,right;
        Node(int val)
        {
            this.data=val;
        }
    }
    public static class Pair
    {
        Node node;
        int state;
        Pair(Node node)
        {
            this.node=node;
            this.state=0;
        }
    }
    public static void printKLevelsDown(Node node, int k){
        if(node==null)
        {
            return;
        }
        if(k==0)
        {
            System.out.println(node.data);
            return;
        }
        printKLevelsDown(node.left, k-1);
        printKLevelsDown(node.right, k-1);
    }

    public static void printSingleChildNodes(Node node,Node parent){
        if(node==null)
        {
            return;
        }
        if(parent!=null)
        {
            if(node==parent.left && parent.right==null)
            {
                System.out.println(node.data);
            }
            if(null==parent.left && parent.right==node)
            {
                System.out.println(node.data);
            }
        }
        printSingleChildNodes(node.left, node);
        printSingleChildNodes(node.right, node);
    }
}
