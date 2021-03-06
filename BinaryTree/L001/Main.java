import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Stack;

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
    public static Node construct(Integer arr[])
    {
        Node root=new Node(arr[0]);
        Stack<Pair> st=new Stack<>();
        st.push(new Pair(root));
        int idx=1;
        while(st.size()>0)
        {
            Pair top=st.peek();
            if(top.state==0)
            {
                Integer val=arr[idx];
                if(val!=null)
                {
                    Node child=new Node(val);
                    top.node.left=child;
                    st.push(new Pair(child));
                }
                top.state++;
                idx++;
            }
            else if(top.state==1)
            {
                Integer val=arr[idx];
                if(val!=null)
                {
                    Node child=new Node(val);
                    top.node.right=child;
                    st.push(new Pair(child));
                }
                top.state++;
                idx++;
            }
            else if(top.state==2)
            {
                st.pop();
            }
        }
        return root;
    }

    public static void display(Node node) {
        if(node==null)
        {
            return;
        }
        System.out.print(node.left==null ? "." : node.left.data);
        System.out.print(" <- "+node.data+" -> ");
        System.out.println(node.right==null ? "." : node.right.data);

        display(node.left);
        display(node.right);
    }

    public static int size(Node node) {
        if (node==null) {
            return 0;   
        }
        int lsize=size(node.left);
        int rsize=size(node.right);

        return lsize+rsize+1;
    }

    public static int sum(Node node) {
        if (node==null) {
            return 0;
        }
        int lsum=sum(node.left);
        int rsum=sum(node.right);

        return lsum+rsum+node.data;
    }

    public static int max(Node node) {
        if (node==null) {
            return Integer.MIN_VALUE;
        }
        int lmax=max(node.left);
        int rmax=max(node.right);
        
        return Math.max(Math.max(lmax, rmax), node.data);
    }
    public static int height(Node node) {
        if (node==null) {
            return -1;
            // Because the node at the lowest level has a height of 0 therefore left and right of that node will be at -1
        }
        int lht=height(node.left);
        int rht=height(node.right);
        return Math.max(lht, rht)+1;
    }

    public static void levelOrder(Node node) {
        Queue<Node> q=new ArrayDeque<>();
        q.add(node);
        while(q.size()>0)
        {
            int s=q.size();
            while(s>0)
            {
                Node rem=q.remove();
                System.out.print(rem.data+"");
                if(rem.left!=null)
                {
                    q.add(rem.left);
                }
                if(rem.right!=null)
                {
                    q.add(rem.right);
                }
                s--;
            }
            System.out.println();
        }
    }

    public static boolean find(Node node, int data){
        if(node==null)
        {
            return false;
        }
        if(node.data==data)
        {
            return true;
        }
        boolean leftchild=find(node.left, data);
        if(leftchild==true)
        {
            return true;
        }
        boolean rightchild=find(node.right,data);
        if(rightchild==true)
        {
            return true;
        }
        return false;
    }
    
    public static ArrayList<Integer> nodeToRootPath(Node node, int data){
        if(node==null)
        {
            return new ArrayList<Integer>();
        }
        if(node.data==data)
        {
            ArrayList<Integer> ans=new ArrayList<>();
            ans.add(data);
            return ans;
        }
        ArrayList<Integer> leftChild=nodeToRootPath(node.left, data);
        if(leftChild.size()>0)
        {
            leftChild.add(node.data);
            return leftChild;
        }
        ArrayList<Integer> rightChild=nodeToRootPath(node.right, data);
        if(rightChild.size()>0)
        {
            rightChild.add(node.data);
            return rightChild;
        }
        return new ArrayList<>();
    }
    public static void main(String[] args) {
        Integer arr[]={10,20,40,60,null,null,null,50,70,null,null,80,null,null,30,null,90,100,null,null,null};
        Node root=construct(arr);
        display(root);
        System.out.println("Size = "+size(root));
        System.out.println("Sum = "+sum(root));
        System.out.println("Max = "+max(root));
        System.out.println("Height = "+height(root));
    }
}
