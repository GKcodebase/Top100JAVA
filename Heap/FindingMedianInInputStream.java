package Heap;

import java.util.PriorityQueue;

public class FindingMedianInInputStream {

    public static void getMedian(int a[]){
        int n = a.length;
        PriorityQueue<Integer> g = new PriorityQueue<>();
        PriorityQueue<Integer> s = new PriorityQueue<>();
        for(int i=0;i<n;i++){
            s.add(-1*a[i]);
            g.add(-1*s.poll());
            if(g.size()>s.size()){
                s.add(-1*g.poll());
            }
            if(g.size()!=s.size()){
                System.out.println(-1*s.peek());
            }else{
                System.out.println((g.peek() - s.peek())
                / 2);
            }
        }
    }
    public static void main( String args[]){
        int A[] = { 5, 15, 1, 3, 2, 8, 7, 9, 10, 6, 11, 4 };
        getMedian(A);
    }
}
