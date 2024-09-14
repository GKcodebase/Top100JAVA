package LinkedList;

import LinkedList.ReverseLinkedList.Node;

public class RemoveNthNodeFromLast {

    public static void removeNthNode(Node head, int n){
        Node fast =head,slow=head;
        for(int i=0;i<n;i++)
            fast=fast.next;
        if(null==fast){
            head=head.next;
        }
        while(null!=fast.next){
            fast=fast.next;
            slow=slow.next;
        }
        slow.next=slow.next.next;
        Node curr = head;
        while (curr != null) {
            System.out.print(" " + curr.data);
            curr = curr.next;
        }
    }
    public static void main(String args[]){
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        int N = 3;
        removeNthNode(head, N);
    }
}
