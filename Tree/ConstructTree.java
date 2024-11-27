package Tree;

import java.util.HashMap;
import java.util.Map;

import Tree.MaximumDepthOfTree.Node;

public class ConstructTree {
    private static Node buildTreeRecur(HashMap<Integer, Integer> map, int[] pre, int[] preIndex, int s, int e) {
        if (s > e)
            return null;

        Node root = new Node(pre[preIndex[0]]);
        preIndex[0]++;
        int index = map.get(pre[preIndex[0] - 1]);
        root.left = buildTreeRecur(map, pre, preIndex, s, index - 1);
        root.right = buildTreeRecur(map, pre, preIndex, index + 1, e);

        return root;

    }

    public static Node buildTree(int[] pre, int in[]) {
        int l = in.length;
        int[] preIndex = { 0 };

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < l; i++) {
            map.put(in[i], i);
        }

        return buildTreeRecur(map, pre, preIndex, 0, l - 1);
    }

    static void printPostorder(Node root) {
        if (root == null)
            return;
        printPostorder(root.left);
        printPostorder(root.right);
        System.out.print(root.value + " ");
    }

    public static void main(String args[]) {
        int[] in = { 3, 1, 4, 0, 5, 2 };
        int[] pre = { 0, 1, 3, 4, 2, 5 };
        Node root = buildTree(pre, in);

        printPostorder(root);
    }
}
