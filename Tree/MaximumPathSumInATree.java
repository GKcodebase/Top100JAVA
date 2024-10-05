package Tree;

import Tree.MaximumDepthOfTree.Node;

class Res{
    public int val;
}

public class MaximumPathSumInATree {
    static int  maxSum=Integer.MIN_VALUE;
    public static int findMaxSumUtil(Node node, Res res){
        if(null==node)
            return 0;
        int l = findMaxSumUtil(node.left,res);
        int r = findMaxSumUtil(node.right,res);

        int max_single = Math.max(Math.max(l, r)+node.value,node.value);
        int max_top = Math.max(max_single,l+r+node.value);
        res.val=Math.max(max_top, maxSum);
        return max_single   ;
    }
    public static int findMaxSum(Node root){

        Res res = new Res();
        res.val = Integer.MIN_VALUE;
        findMaxSumUtil(root,res);
        return res.val;
    }
    public static void main(String args[]){
        Node root = new Node(10);
        root.left = new Node(2);
        root.right = new Node(10);
        root.left.left = new Node(20);
        root.left.right = new Node(1);
        root.right.right = new Node(-25);
        root.right.right.left = new Node(3);
        root.right.right.right = new Node(4);
 
        // Function call
        System.out.println("maximum path sum is : "
                           + findMaxSum(root));
    }
}
