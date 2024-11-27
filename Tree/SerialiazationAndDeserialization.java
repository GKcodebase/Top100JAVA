package Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import javax.swing.tree.TreeNode;

import Tree.MaximumDepthOfTree.Node;

public class SerialiazationAndDeserialization {

    static class BinaryTree {
        Node root;

        public static String serialize(Node root) {
            if (null == root)
                return null;
            Stack<Node> st = new Stack<>();
            st.push(root);
            List<String> list = new ArrayList<>();
            while (!st.isEmpty()) {
                Node t = st.pop();
                if (null == t) {
                    list.add("#");
                } else {
                    list.add("" + t.value);
                    st.push(t.right);
                    st.push(t.left);
                }
            }
            return String.join(",", list);
        }

        static int t;

        public static Node deSerialize(String data) {
            if (null == data)
                return null;
            String[] arr = data.split(",");
            return helper(arr);
        }

        public static Node helper(String arr[]) {
            if (arr[t].equals("#"))
                return null;
            Node root = new Node(Integer.parseInt(arr[t]));
            t++;
            root.left = helper(arr);
            t++;
            root.right = helper(arr);
            return root;
        }

        static void inorder(Node root) {
            if (root != null) {
                inorder(root.left);
                System.out.print(root.value + " ");
                inorder(root.right);
            }
        }
    }

    public static void main(String args[]) {
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(20);
        tree.root.left = new Node(8);
        tree.root.right = new Node(22);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(12);
        tree.root.left.right.left = new Node(10);
        tree.root.left.right.right = new Node(14);

        String serialized = tree.serialize(tree.root);
        System.out.println("Serialized view of the tree:");
        System.out.println(serialized);
        System.out.println();
        Node t = tree.deSerialize(serialized);

        System.out.println(
                "Inorder Traversal of the tree constructed"
                        + " from serialized String:");
        tree.inorder(t);
    }
}
