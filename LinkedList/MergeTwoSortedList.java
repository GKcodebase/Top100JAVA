package LinkedList;

import LinkedList.ReverseLinkedList.Node;

public class MergeTwoSortedList {
    public static Node merge(Node a, Node b){
        Node head =null;
        Node tail =null;
        if(a.data<=b.data){
            head=tail=a;
            a=a.next;
        }else{
            head=tail=b;
            b=b.next;
        }
        while(a!=null && b!=null){
            if(a.data<=b.data){
                tail.next=a;
                tail=a;
                a=a.next;
            }else{
                tail.next=b;
                tail=b;
                b=b.next;
            }
        }
        tail.next = (a != null) ? a : b;
        return head;
    }
    public static void main(String[] args) {
        Node a = new Node(2);
        a.next = new Node(4);
        a.next.next = new Node(8);
        a.next.next.next = new Node(9);

        Node b = new Node(1);
        b.next = new Node(3);
        b.next.next = new Node(8);
        b.next.next.next = new Node(10);

        Node res = merge(a, b);

        System.out.println("Merged Linked List is:");
        while (res != null) {
            System.out.print(res.data + " ");
            res = res.next;
        }
    }
}
