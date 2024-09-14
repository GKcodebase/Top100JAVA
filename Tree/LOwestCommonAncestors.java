package Tree;

import Tree.MaximumDepthOfTree.Node;

public class LOwestCommonAncestors {
    public static int getLCA(Node root, int n1,int n2){
        while(null!=root){
            if(root.value>n1 && root.value>n2)
                root=root.left;
            else if(root.value<n1 && root.value<n2)
                root=root.right;
            else
                break;
        }
        return root.value;
    }
    public static void main(String args[]){
        Node tree = new Node(20);
        tree.left = new Node(8);
        tree.right = new Node(22);
        tree.left.left = new Node(4);
        tree.left.right = new Node(12);
        tree.left.right.left = new Node(10);
        tree.left.right.right = new Node(14);

          // Function calls
        int n1 = 10, n2 = 14;
        int t = getLCA(tree, n1, n2);
        System.out.println("LCA of " + n1 + " and " + n2
                           + " is " + t);

        n1 = 14;
        n2 = 8;
        t = getLCA(tree, n1, n2);
        System.out.println("LCA of " + n1 + " and " + n2
                           + " is " + t);

        n1 = 10;
        n2 = 22;
        t = getLCA(tree, n1, n2);
        System.out.println("LCA of " + n1 + " and " + n2
                           + " is " + t);
    }
}
