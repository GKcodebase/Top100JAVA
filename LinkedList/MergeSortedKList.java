package LinkedList;

import LinkedList.ReverseLinkedList.Node;

public class MergeSortedKList {
    static void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println();
    }

    static Node mergedKList(Node arr[], int k) {
        Node head = null;
        Node curr = null;

        while (true) {
            int a = 0;
            int z = 0;
            int min = Integer.MAX_VALUE;

            for (int i = 0; i < k; i++) {
                if (arr[i] != null) {
                    a++;
                    if (arr[i].data < min) {
                        min = arr[i].data;
                        z = i;
                    }
                }
            }
            if (a != 0) {
                arr[z] = arr[z].next;
                Node temp = new Node(min);
                if (head == null) {
                    head = temp;
                    curr = temp;
                } else {
                    curr.next = temp;
                    curr = temp;
                }
            } else {
                return head;
            }
        }
    }

    public static void main(String args[]) {
        int k = 3; // Number of linked lists
        int n = 4; // Number of elements in each list

        // an array of pointers storing the head nodes
        // of the linked lists
        Node[] arr = new Node[k];

        arr[0] = new Node(1);
        arr[0].next = new Node(3);
        arr[0].next.next = new Node(5);
        arr[0].next.next.next = new Node(7);

        arr[1] = new Node(2);
        arr[1].next = new Node(4);
        arr[1].next.next = new Node(6);
        arr[1].next.next.next = new Node(8);

        arr[2] = new Node(0);
        arr[2].next = new Node(9);
        arr[2].next.next = new Node(10);
        arr[2].next.next.next = new Node(11);

        Node head = mergedKList(arr, k);
        printList(head);

    }
}
