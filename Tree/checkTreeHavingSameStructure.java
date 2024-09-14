package Tree;

import Tree.MaximumDepthOfTree.Node;

public class checkTreeHavingSameStructure {
    public static boolean isSameStructure(Node a, Node b){
        if(a==null && b== null){
            return true;
        }
        if(a!=null || b!=null){
            return isSameStructure(a.left, b.left)&&isSameStructure(a.right, b.right);
        }
        return false;
    }
    public static void main(String args[]){
        Node root1 = new Node(10); 
        Node root2 = new Node(100); 
        root1.left = new Node(7); 
        root1.right = new Node(15); 
        root1.left.left = new Node(4); 
        root1.left.right = new Node(9); 
        root1.right.right = new Node(20); 
     
        root2.left = new Node(70); 
        root2.right = new Node(150); 
        root2.left.left = new Node(40); 
        root2.left.right = new Node(90); 
        root2.right.right = new Node(200); 
     
        if (isSameStructure(root1, root2)) 
            System.out.printf("Both trees have same structure"); 
        else
            System.out.printf("Trees do not have same structure"); 
    }
}
