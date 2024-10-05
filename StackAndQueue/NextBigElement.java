package StackAndQueue;
import java.util.*;;
public class NextBigElement {
    public static void getElements(int arr[]){
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i:arr)
            pq.add(i);
        int i=1;
        while(!pq.isEmpty()){
            System.out.println(i+" - "+pq.poll());
            i++;
        }
    }
    public static void main(String args[]){
        int arr[] = { 11, 13, 21, 3 };
        getElements(arr);
    }
    
}
