package LinkedList;

import LinkedList.ReverseLinkedList.Node;

public class AddOneInLinkedList {
    public static int addWithCarry(Node head){
        if(head==null)
            return 1;
        int res = head.data+addWithCarry(head.next);
        head.data = res%10;
        return res/10;
    }
    public static Node addOne(Node head){
        int carry =  addWithCarry(head);
        if(carry>0){
            Node newNode = new Node(carry);
            newNode.next = head;
            head = newNode;
        }
        return head;

    }
    static void printList(Node head) {
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
        System.out.println();
    }
    public static void main(String args[]){
        Node head = new Node(8);
        head.next = new Node(9);
        head.next.next = new Node(9);
        head.next.next.next = new Node(9);

        head = addOne(head);

        printList(head);
    }
}
