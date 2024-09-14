package LinkedList;

public class ReverseLinkedList {
    static class Node{
        int data;
        Node next;
        Node(int data){
            this.data=data;
            this.next=null;
        }
    }
    public static Node reverse(Node head){
        if(head == null)
            return head;
        Node curr=head,prev=null,next;
        while(curr!=null){
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        return prev;
    }
    public static void printList(Node head){
        Node temp = head;
        while(temp!=null){
            System.out.print(temp.data+" ");
            temp=temp.next;
        }
    }
    public static void main(String args[]){
        Node head = new Node(1);
        head.next= new Node(2);
        head.next.next= new Node(3);
        head.next.next.next= new Node(4);
        head.next.next.next.next= new Node(5);
        // printList(head);
        head=reverse(head);
        printList(head);

    }
}
