package Tree;

import Tree.MaximumDepthOfTree.Node;

public class ValidateBinaryTree {

    public static boolean isValidUtil(Node root , int prev){
            if(null==root) return true;
            if (!isValidUtil(root.left, prev)) return false;
            if (prev >= root.value) return false;
            prev = root.value;
            return isValidUtil(root.right, prev);
    }

    public static void validateBinarySearchTree(Node root){
        int prev = Integer.MIN_VALUE;
        if(isValidUtil(root,prev))
            System.out.println("Valid BST");
        else
             System.out.println("InValid BST");

    }
    public static void main(String args[]){

        Node root = new Node(4);
        root.left = new Node(2);
        root.right = new Node(5);
        root.left.left = new Node(1);
        root.left.right = new Node(0);
        validateBinarySearchTree(root);
    }
}
