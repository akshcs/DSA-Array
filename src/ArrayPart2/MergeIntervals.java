package ArrayPart2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;

public class MergeIntervals {

    public static void main(String[] args){
        int[][] intervals = {{1,3},{2,6},{8,10},{15,18}};
        int[][] sortedIntervals = merge(intervals);
        System.out.println(Arrays.deepToString(sortedIntervals));
    }
    static int[][] merge(int[][] intervals) {
        TreeMap<Integer, List<Integer>> sortedIntervals = getSortedIntervalMap(intervals);
        List<List<Integer>> sortedIntervalsInList = getSortedIntervalsInList(intervals, sortedIntervals);
        return convertArrayListToArray(sortedIntervalsInList);
    }

    static TreeMap<Integer, List<Integer>> getSortedIntervalMap(int[][] intervals){
        TreeMap<Integer, List<Integer>> sortedIntervals = new TreeMap<>();
        for(int i=0;i<intervals.length;i++){
            int start = intervals[i][0];
            if(sortedIntervals.containsKey(start)){
                sortedIntervals.get(start).add(i);
            } else {
                List<Integer> interval = new ArrayList<>();
                interval.add(i);
                sortedIntervals.put(start, interval);
            }
        }
        return sortedIntervals;
    }

    static List<List<Integer>> getSortedIntervalsInList(int[][] intervals, TreeMap<Integer, List<Integer>> sortedIntervals){
        List<List<Integer>> sortedIntervalsInList = new ArrayList<>();
        int start = -1;
        int end = -1;
        for(int key : sortedIntervals.keySet()){
            List<Integer> indexList = sortedIntervals.get(key);
            if(key > end){
                if(start!=-1){
                    addToListOfList(sortedIntervalsInList, start, end);
                }
                start = key;
                end = -1;
            }
            for(int i : indexList){
                if(intervals[i][1] > end){
                    end = intervals[i][1];
                }
            }
        }
        if(start>-1){
            addToListOfList(sortedIntervalsInList, start, end);
        }
        return sortedIntervalsInList;
    }

    static int[][] convertArrayListToArray(List<List<Integer>> sortedIntervalsInList){
        int[][] sortedIntervalsInArray = new int[sortedIntervalsInList.size()][2];
        for(int i=0;i<sortedIntervalsInList.size();i++){
            sortedIntervalsInArray[i][0] = sortedIntervalsInList.get(i).get(0);
            sortedIntervalsInArray[i][1] = sortedIntervalsInList.get(i).get(1);
        }
        return sortedIntervalsInArray;
    }


    static void addToListOfList(List<List<Integer>> sortedIntervalsInList, int start, int end){
        List<Integer> interval = new ArrayList<>();
        interval.add(start);
        interval.add(end);
        sortedIntervalsInList.add(interval);
    }
}
