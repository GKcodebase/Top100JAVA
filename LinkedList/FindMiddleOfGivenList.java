package LinkedList;

import LinkedList.ReverseLinkedList.Node;

public class FindMiddleOfGivenList {

    public static void findMiddle(Node head){
        Node fastNode = head, slowNode = head;
        while(fastNode !=null && fastNode.next != null){
            fastNode=fastNode.next.next;
            slowNode=slowNode.next;
        }
        System.out.println("Middle Element is :: "+slowNode.data);
    }
    public static void main(String args[]){
        Node head = new Node(1);
        head.next= new Node(2);
        head.next.next= new Node(3);
        head.next.next.next= new Node(4);
        head.next.next.next.next= new Node(5);
        head.next.next.next.next.next= new Node(6);
        head.next.next.next.next.next.next= new Node(7);
        findMiddle(head);
    }
}
