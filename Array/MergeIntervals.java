package Array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import Array.InsertAndMergeINterval.Interval;
import Array.InsertAndMergeINterval.IntervalComparator;

public class MergeIntervals {
    public static void mergeIntervals(List<Interval> intervals){
        Collections.sort(intervals, new IntervalComparator());
        int index=0;
        for(int i=1;i<intervals.size();i++){
            if(intervals.get(index).e>=intervals.get(i).s){
                intervals.get(i).e = Math.min(intervals.get(index).e, intervals.get(i).e);
            }else{
                index++;
                intervals.set(index, intervals.get(i));
            }
        }
        intervals.subList(index+1,intervals.size() ).clear();
        for (int i = 0; i < intervals.size(); i++)
            System.out.println(intervals.get(i).s + ", "
                   + intervals.get(i).e);  
    }
    public static void main(String args[]){
        Interval newInterval;
        List<Interval> intervals = new ArrayList<>();
        newInterval = new Interval(6, 8);
        intervals.add(newInterval);
        newInterval = new Interval(1, 9);
        intervals.add(newInterval);
        newInterval = new Interval(2, 4);
        intervals.add(newInterval);
        newInterval = new Interval(4, 7);
        intervals.add(newInterval);

        mergeIntervals(intervals);
    }
}
