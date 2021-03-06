import java.util.*;

public class Main {
  static class Node {
    int data;
    ArrayList<Node> children;

    Node(int data) {
      this.data = data;
      children = new ArrayList<>();
    }
  }

  public static void traversals(Node node) {
    System.out.println("Node Pre " + node.data);
    for (Node child : node.children) {
      System.out.println("Edge Pre " + node.data + "--" + child.data);
      traversals(child);
      System.out.println("Edge Post " + node.data + "--" + child.data);
    }
    System.out.println("Node Post " + node.data);
  }

  public static void levelOrder(Node node) {
    Queue<Node> q = new ArrayDeque<>();
    q.add(node);
    while (q.size() > 0) {
      Node rem = q.remove();
      System.out.print(rem.data + " ");
      for (Node child : rem.children) {
        q.add(child);
      }
    }
    System.out.println(".");
  }

  public static void levelOrderLinewise(Node node) {
    // write your code here
    Queue<Node> mq = new ArrayDeque<>();
    Queue<Node> hq = new ArrayDeque<>();
    mq.add(node);
    while (mq.size() > 0) {
      Node rem = mq.remove();
      System.out.print(rem.data + " ");
      for (Node child : rem.children) {
        hq.add(child);
      }
      if (mq.size() == 0) {
        System.out.println();
        Queue<Node> tq = mq;
        mq = hq;
        hq = tq;
      }
    }
  }

  public static boolean find(Node node, int data) {
    if(node.data==data)
    {
      return true;
    }
    for (Node child : node.children) 
    {
      boolean ans=find(child,data);
      if(ans)
      {
        return true;
      }
    }
    return false;
  }

  public static ArrayList<Integer> nodeToRootPath(Node node, int data){
    if(node.data==data)
    {
      ArrayList<Integer> ans = new ArrayList<Integer>();
      ans.add(node.data);
      return ans;
    }
    for(Node child:node.children)
    {
      ArrayList<Integer> a=nodeToRootPath(child,data);
      if(a.size()>0)
      {
        a.add(node.data);
        return a;
      }
    }
    return new ArrayList<Integer>();
 }

 public static void levelOrderLinewiseZZ(Node node){
  // write your code here
  Queue<Node> q=new ArrayDeque<>();
  Stack<Node> st=new Stack<>();
  q.add(node);
  int lvl=1;
  while(q.size()>0)
  {
    int s=q.size();
    while(s>0)
    {
      if(lvl%2!=0)
      {
        Node rem=q.remove();
        System.out.print(rem.data+" ");
        for (Node child : rem.children) {
          q.add(child);
          st.push(child);
        }
      }
      else
      {
        Node remq=q.remove();
        Node rems=st.pop();
        System.out.print(rems.data+" ");
        for (Node child : remq.children) {
          q.add(child);
        }
      }
      s--;
    }
    lvl++;
    System.out.println();
  }
}
}
