package LinkedList;

import LinkedList.ReverseLinkedList.Node;

public class DeleteLastOcuurance {
    public static void deleteLast(Node head, int n){
        Node temp = head, ptr =null;
        while(null!=temp){
            if(n==temp.data){
                ptr=temp;
            }
            temp=temp.next;
        }
        if(ptr!=null)
        if( ptr.next==null){
            temp=head;
            while(temp.next!=ptr){
                temp=temp.next;
            }
            temp.next=null;
        }
        else{
            ptr.data=ptr.next.data;
            ptr.next=ptr.next.next;  

        }
    }
    static void display(Node head)  
{  
    Node temp = head;  
    if (head == null)  
    {  
        System.out.print("null\n");  
        return;  
    }  
    while (temp != null)  
    {  
        System.out.printf("%d --> ", temp.data);  
        temp = temp.next;  
    }  
    System.out.print("null\n");  
} 
    public static void main(String args[]){
   Node head = new Node(1);  
    head.next = new Node(2);  
    head.next.next = new Node(3);  
    head.next.next.next = new Node(4);  
    head.next.next.next.next = new Node(5);  
    head.next.next.next.next.next = new Node(4);  
    head.next.next.next.next.next.next = new Node(4);  
    System.out.print("Created Linked list: ");  
    display(head);  
    deleteLast(head, 4);  
    System.out.print("List after deletion of 4: ");  
    display(head);  
    }
}
