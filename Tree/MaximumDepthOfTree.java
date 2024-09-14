package Tree;

import java.util.LinkedList;
import java.util.Queue;

import javax.naming.LinkLoopException;

public class MaximumDepthOfTree {
    public static class Node{
        int value;
        Node left,right;
        Node(int data){
            value=data;
            left=null;
            right=null;
        }
    }
    
    public static int maxDepth(Node root){
        if(root==null)
            return 0;
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        return Math.max(leftDepth,rightDepth)+1;

    }

    public static int maxDepthLevelOrder(Node root){
        int depth=0;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);
        while(!queue.isEmpty()){
            Node temp = queue.poll();
            if(null==temp){
                depth++;
                if(!queue.isEmpty())
                    queue.add(null);
            }
            else{
                if(null!=temp.left)queue.add(temp.left);
                if(null!=temp.right)queue.add(temp.right);
            }
        }
        return depth;
    }
    public static void main(String args[]){
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        System.out.println(maxDepthLevelOrder(root));
    }
}
