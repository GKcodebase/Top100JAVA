package Tree;

import java.util.LinkedList;
import java.util.Queue;

import Tree.MaximumDepthOfTree.Node;

public class LevelOrderTraversal {
    public static void levelorderTraversal(Node root){
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            Node temp = queue.poll();
            System.out.print(temp.value+" ");
            if(null!=temp.left)
                queue.add(temp.left);
            if(null!=temp.right)
                queue.add(temp.right);
        }
    }
    public static void main(String[] args){
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        levelorderTraversal(root);
    }
}
