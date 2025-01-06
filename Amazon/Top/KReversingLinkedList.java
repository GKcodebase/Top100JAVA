package Amazon.Top;

/**
 * The type K reversing linked list.
 */
public class KReversingLinkedList {
    /**
     * Reverse by k node.
     *
     * @param root the root
     * @param k    the k
     * @return the node
     */
    static Node reverseByK(Node root, int k) {
        if (root == null || k == 1)
            return root;

        Node curr = root;
        Node newHead = null;
        Node tail = null;

        while (curr != null) {

            Node groupHead = curr;
            Node pre = null;
            Node nextNode = null;

            int count = 0;

            while (curr != null && count < k) {
                nextNode = curr.next;
                curr.next = pre;
                pre = curr;
                curr = nextNode;
                count++;
            }
            if (newHead == null)
                newHead = pre;

            if (tail != null) {
                tail.next = pre;
            }

            tail = groupHead;
        }

        return newHead;
    }

    /**
     * Print list.
     *
     * @param root the root
     */
    static void printList(Node root) {
        Node temp = root;
        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        Node root = new Node(10);
        root.next = new Node(20);
        root.next.next = new Node(30);
        root.next.next.next = new Node(35);
        root.next.next.next.next = new Node(45);
        root.next.next.next.next.next = new Node(55);
        printList(root);
        root = reverseByK(root, 2);
        printList(root);

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
         * The Next.
         */
        Node next;

        /**
         * Instantiates a new Node.
         *
         * @param val the val
         */
        Node(int val) {
            this.val = val;
        }
    }
}
