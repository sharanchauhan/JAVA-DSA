public class Main {
    public static void traversals(Node node){
        System.out.println("Node Pre "+node.data);
        for (Node child : node.children) {
          System.out.println("Edge Pre "+node.data+"--"+child.data);
          traversals(child);
          System.out.println("Edge Post "+node.data+"--"+child.data);
        }
        System.out.println("Node Post "+node.data);
      }

      public static void levelOrder(Node node){
        Queue<Node> q=new ArrayDeque<>();
        q.add(node);
        while(q.size()>0)
        {
          Node rem=q.remove();
          System.out.print(rem.data+" ");
          for(Node child:rem.children)
          {
            q.add(child);
          }
        }
        System.out.println(".");
        }
}
