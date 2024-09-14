package Array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class InsertAndMergeINterval {
    static class Interval {
        int s, e;
        Interval(int s, int e)
        {
            this.s = s;
            this.e = e;
        }
    }
    static class IntervalComparator implements Comparator<Interval >{

        @Override
        public int compare(Interval o1, Interval o2) {
            // TODO Auto-generated method stub
            return o1.s-o2.s;
        }
        
    }
    public static void insertInterval(List<Interval> intervals,
                                  Interval newInterval){
            List<Interval> ans = new ArrayList<>();
            int n = intervals.size();
            intervals.add(newInterval);
            Collections.sort(intervals,new IntervalComparator());
            int index=0;
            for(int i=1;i<=n;i++){
                if(intervals.get(index).e>=intervals.get(i).s){
                    intervals.get(index).e = Math.max(intervals.get(index).e,intervals.get(i).e);
                }
                else{
                    index++;
                    intervals.set(index, intervals.get(i));
                }
            } 
            for (int i = 0; i <= index; i++)
                System.out.println(intervals.get(i).s + ", "
                           + intervals.get(i).e);                      

    }
    public static void main(String args[]){
        List<Interval> intervals = new ArrayList<>();
        Interval newInterval;

        newInterval = new Interval(6, 2);
        intervals.add(newInterval);
        newInterval = new Interval(3, 5);
        intervals.add(newInterval);
        newInterval = new Interval(6, 7);
        intervals.add(newInterval);
        newInterval = new Interval(8, 10);
        intervals.add(newInterval);
        newInterval = new Interval(12, 16);
        intervals.add(newInterval);
        newInterval = new Interval(4, 9);

        insertInterval(intervals, newInterval);

    }
}
