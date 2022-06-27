import java.util.*;

public class Main {
    private static class Node {
        int data;
        ArrayList<Node> children = new ArrayList<>();
    }

    public static ArrayList<Integer> nodeToRootPath(Node node, int data) {
        if (node.data == data) {
            ArrayList<Integer> path = new ArrayList<>();
            path.add(node.data);
            return path;
        }

        for (Node child : node.children) {
            ArrayList<Integer> ptc = nodeToRootPath(child, data);
            if (ptc.size() > 0) {
                ptc.add(node.data);
                return ptc;
            }
        }

        return new ArrayList<>();
    }

    public static int lca(Node node, int d1, int d2) {
        ArrayList<Integer> path1, path2;
        path1 = nodeToRootPath(node, d1);
        path2 = nodeToRootPath(node, d2);
        int i = path1.size() - 1;
        int j = path2.size() - 1;
        while (i >= 0 && j >= 0) {
            if (path1.get(i) == path2.get(j)) {
                i--;
                j--;
            } else {
                break;
            }
        }
        return path1.get(i + 1);
    }

    public static Node getTailNode(Node node) {
        while (node.children.size() != 0) {
            node = node.children.get(0);
        }
        return node;
    }

    public static void linearize(Node node) {
        for (Node child : node.children) {
            linearize(child);
        }

        while (node.children.size() > 1) {
            Node lc = node.children.get(node.children.size() - 1);
            Node slc = node.children.get(node.children.size() - 2);
            node.children.remove(node.children.size() - 1);
            Node tailNode = getTailNode(slc);
            tailNode.children.add(lc);
        }
    }

    public static int distanceBetweenNodes(Node node, int d1, int d2) {
        ArrayList<Integer> p1 = nodeToRootPath(node, d1);
        ArrayList<Integer> p2 = nodeToRootPath(node, d2);
        int lc = lca(node, d1, d2);
        return (p1.indexOf(lc) + p2.indexOf(lc));
    }
}
