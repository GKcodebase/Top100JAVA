package LinkedList;

import LinkedList.ReverseLinkedList.Node;

public class DetectCycleInLinkedList {
    public static boolean detectCycle(Node head){
        Node fast = head.next,slow=head;
        while(fast.next !=null && slow !=null){
            if(fast==slow)
                return true;
            fast = fast.next.next;
            slow = slow.next;
        }
        return false;
    }
    public static void main(String[] args) {

        // Create a hard-coded linked list:
        // 10 -> 20 -> 30 -> 40 -> 50 -> 60
        Node head = new Node(10);
        head.next = new Node(20);
        head.next.next = new Node(30);
        head.next.next.next = new Node(40);
        head.next.next.next.next = new Node(50);
        head.next.next.next.next.next = new Node(60);
      
        head.next.next.next.next = head;

       System.out.println(detectCycle(head));
    }
}
