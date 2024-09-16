package Tree;

import Tree.MaximumDepthOfTree.Node;

public class KthSmallestInBST {
    static int count =0;
    public static Node insert(Node root, int x){
        if(root==null)
            return new Node(x);
        if(x>root.value)
            root.right=insert(root.right, x);
        else if (x<root.value)
            root.left=insert(root.left, x);
        return root;
    }
    public static Node getKthSmallest(Node root,int k){
        if(null==root)
            return null;
        Node left = getKthSmallest(root.left, k);
        if(left!=null)
            return left;
        count++;
        if(k==count)
            return root;
        return getKthSmallest(root.right,k);
    }
    public static void main(String args[]){
        Node root = null;
        int keys[] = { 20, 8, 22, 4, 12, 10, 14 };
        for (int x : keys)
            root = insert(root, x);
        int k = 3;
        Node temp=getKthSmallest(root, k);
        System.out.println(k+" smallest element is : "+temp.value);
    }
}
