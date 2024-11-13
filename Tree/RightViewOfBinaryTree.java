package Tree;

import java.util.ArrayList;

import Tree.MaximumDepthOfTree.Node;

public class RightViewOfBinaryTree{

    static void RecursiveRightView(Node root,int level,int[] maxLevel, 
    ArrayList<Integer> result){
        if (null == root)
            return;
        if (level > maxLevel[0]) {
            result.add(root.value);
            maxLevel[0] = level;
        }
        RecursiveRightView(root.right, level + 1,
        maxLevel, result);
       RecursiveRightView(root.left, level + 1,
        maxLevel, result);
    }

    static ArrayList<Integer> rightView(Node root) {
        ArrayList<Integer> result = new ArrayList<>();
        int[] maxLevel = new int[] {-1};
        
        // Start recursion with root at level 0
        RecursiveRightView(root, 0, maxLevel, result);
        
        return result;
    }
    static void printArray(ArrayList<Integer> arr) {
        for (int val : arr) {
            System.out.print(val + " ");
        }
        System.out.println();
    }
    public static void main(String args[]){
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.right.left = new Node(4);
        root.right.right = new Node(5);

        ArrayList<Integer> result = rightView(root);
        
        printArray(result);
    }
}
