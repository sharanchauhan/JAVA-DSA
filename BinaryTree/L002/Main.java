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

    public static void printSingleChildNodes(Node node){
        if(node == null) return;
        if(node.left != null && node.right == null){
            System.out.println(node.left.data);
        }
        if(node.left == null && node.right != null){
            System.out.println(node.right.data);
        }
        printSingleChildNodes(node.left);
        printSingleChildNodes(node.right);
    }

    public static Node removeLeaves(Node node)
    {
        if(node==null || (node.left==null && node.right==null))
        {
            return null;
        }
        node.left=removeLeaves(node.left);
        node.right=removeLeaves(node.right);
        return node;
    }
    public static class DiameterPair{
        int ht,dia;
        DiameterPair(int ht,int dia){
          this.ht = ht;
          this.dia = dia;
        }
      }
      public static DiameterPair diameter(Node node) {
        if(node == null){
          return new DiameterPair(-1,-1);
        }
    
        DiameterPair lpair = diameter(node.left);
        DiameterPair rpair = diameter(node.right);
    
        int myDia = lpair.ht + rpair.ht + 2;
        int myht = Math.max(lpair.ht,rpair.ht)+1;
        int oDia = Math.max(myDia,Math.max(lpair.dia,rpair.dia));
    
        return new DiameterPair(myht,oDia);
      }
}
