package Amazon.Frquent;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * The type Trees.
 */
public class Trees {

    /**
     * The Max diameter.
     */
    int maxDiameter = 0;

    /**
     * Gets left view.
     *
     * @param root the root
     * @return the left view
     */
    static List<Integer> getLeftView(Node root) {
        List<Integer> result = new ArrayList<>();
        if (root == null)
            return result;

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int l = queue.size();
            for (int i = 0; i < l; i++) {
                Node temp = queue.poll();
                if (i == 0)
                    result.add(temp.val);
                if (temp.left != null)
                    queue.add(temp.left);
                if (temp.right != null)
                    queue.add(temp.right);
            }
        }


        return result;
    }

    /**
     * Gets right view.
     *
     * @param root the root
     * @return the right view
     */
    static List<Integer> getRightView(Node root) {
        List<Integer> result = new ArrayList<>();
        if (root == null)
            return result;

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int l = queue.size();
            for (int i = 0; i < l; i++) {
                Node temp = queue.poll();
                if (i == l - 1)
                    result.add(temp.val);
                if (temp.left != null)
                    queue.add(temp.left);
                if (temp.right != null)
                    queue.add(temp.right);
            }
        }


        return result;
    }

    /**
     * Gets top view.
     *
     * @param root the root
     * @return the top view
     */
    static List<Integer> getTopView(Node root) {
        List<Integer> result = new ArrayList<>();

        return result;
    }

    /**
     * Gets bottom view.
     *
     * @param root the root
     * @return the bottom view
     */
    static List<Integer> getBottomView(Node root) {
        List<Integer> result = new ArrayList<>();

        return result;
    }

    /**
     * Gets max of level.
     *
     * @param root the root
     * @return the max of level
     */
    static List<Integer> getMaxOfLevel(Node root) {
        List<Integer> result = new ArrayList<>();
        if (root == null)
            return result;

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int l = queue.size();
            int max = 0;
            for (int i = 0; i < l; i++) {
                Node temp = queue.poll();
                max = Math.max(max, temp.val);
                if (temp.left != null)
                    queue.add(temp.left);
                if (temp.right != null)
                    queue.add(temp.right);
            }
            result.add(max);
        }


        return result;
    }

    /**
     * Does follow children sum property boolean.
     *
     * @param root the root
     * @return the boolean
     */
    static boolean doesFollowChildrenSumProperty(Node root) {
        if (root == null)
            return false;

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int sum = 0;
            Node temp = queue.poll();
            if (temp.left == null && temp.right == null)
                continue;

            if (temp.left != null) {
                sum += temp.left.val;
                queue.add(temp.left);
            }

            if (temp.right != null) {
                sum += temp.right.val;
                queue.add(temp.right);
            }

            if (sum != temp.val)
                return false;
        }
        return true;
    }

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        // Representation of the input tree:
        //         1
        //        / \
        //       2   3
        //      / \
        //     4   5
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);

        List<Integer> leftView = getLeftView(root);
        System.out.println("Left View");
        for (int i : leftView)
            System.out.print(i + " ");

        System.out.println();

        System.out.println("Right View");
        List<Integer> rightView = getRightView(root);
        for (int i : rightView)
            System.out.print(i + " ");

        System.out.println();
        Trees trees = new Trees();
        System.out.println("Maximum Diameter :: " + trees.getMaxDiameter(root));


        System.out.println();
        List<Integer> maxInEachLevel = getMaxOfLevel(root);
        for (int i : maxInEachLevel)
            System.out.print(i + " ");
        System.out.println();

        System.out.println("Does it follow child sum property : " + doesFollowChildrenSumProperty(root));

        // Create a hard coded tree.
        //         35
        //       /   \
        //      20    15
        //     /  \  /  \
        //   15   5 10   25

        Node root2 = new Node(35);
        root2.left = new Node(20);
        root2.right = new Node(15);
        root2.left.left = new Node(15);
        root2.left.right = new Node(5);
        root2.right.left = new Node(10);
        root2.right.right = new Node(25);
        System.out.println("Does it follow child sum property : " + doesFollowChildrenSumProperty(root2));

        System.out.println("LCA of Binary Tree :" + getLeastCommonAncestor(root2, 20, 5).val);

    }

    /**
     * Gets least common ancestor.
     *
     * @param root the root
     * @param p    the p
     * @param q    the q
     * @return the least common ancestor
     */
    static Node getLeastCommonAncestor(Node root, int p, int q) {
        if (root == null)
            return null;

        if (root.val == p || root.val == q)
            return root;

        Node leftLCA = getLeastCommonAncestor(root.left, p, q);
        Node rightLCA = getLeastCommonAncestor(root.right, p, q);

        if (leftLCA != null && rightLCA != null)
            return root;

        return (leftLCA != null) ? leftLCA : rightLCA;

    }


    /**
     * Number of edges between two nodes is it diameter
     *
     * @param root the root
     * @return the max diameter
     */
    int getMaxDiameter(Node root) {
        getMaxDiameterHelper(root);
        return maxDiameter;
    }

    /**
     * Gets max diameter helper.
     *
     * @param root the root
     * @return the max diameter helper
     */
    int getMaxDiameterHelper(Node root) {
        if (root == null)
            return 0;

        int left = getMaxDiameterHelper(root.left);
        int right = getMaxDiameterHelper(root.right);

        maxDiameter = Math.max(maxDiameter, left + right);
        return Math.max(left, right) + 1;

    }

    /**
     * The type Node.
     */
    static class Node {
        /**
         * The Val.
         */
        int val;
        /**
         * The Left.
         */
        Node left;
        /**
         * The Right.
         */
        Node right;

        /**
         * Instantiates a new Node.
         *
         * @param val the val
         */
        Node(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }
}
