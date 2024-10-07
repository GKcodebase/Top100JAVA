package LinkedList;

import LinkedList.ReverseLinkedList.Node;

public class ReverseList {
    static void printList(Node node) {
        if (node == null) {
            return;
        }
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println("");
    }
    public static Node reverse(Node head){
        Node prev =null, curr = head, next;
        while(curr != null){
            next=curr.next;
            curr.next=prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
    public static void main(String args[]){
      // singly linked list 1->2->3->4->5
      Node head = new Node(1);
      head.next = new Node(2);
      head.next.next = new Node(3);
      head.next.next.next = new Node(4);
      head.next.next.next.next = new Node(5);
      printList(head);

      head = reverse(head);
      printList(head);
    }
}
