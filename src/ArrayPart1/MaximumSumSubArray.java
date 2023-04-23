package ArrayPart1;

import java.util.ArrayList;
import java.util.List;

public class MaximumSumSubArray {

    public static void main(String[] args){
        int[] nums = {2,-1,3, -2, -5, 5, 4, 8 -4, 10, 2, -6};
        System.out.print("MaxSum SubArray Sum : " + maxSubArray(nums));
    }
    static int maxSubArray(int[] nums) {
        int size = nums.length;
        List<Integer> indexes = getStartEndIndex(nums, size);
        if(indexes.get(0)<0){
            findMaxInArray(nums, size, indexes);
        }
        return findSum(nums, indexes.get(0), indexes.get(1));
    }

    static List<Integer> getStartEndIndex(int[] nums, int size){
        List<Integer> indexes = new ArrayList<>();
        int sum, maxSum, start, maxStart, end, maxEnd;
        maxSum = maxStart = maxEnd = -1;
        sum = start = 0;
        for(int i=0;i<size;i++){
            sum+=nums[i];
            if(sum < 0){
                sum = 0;
                start = i+1;
            } else {
                end = i;
                if(maxSum<sum){
                    maxSum = sum;
                    maxStart = start;
                    maxEnd = end;
                }
            }
        }
        indexes.add(maxStart);
        indexes.add(maxEnd);
        return indexes;
    }

    static void findMaxInArray(int[] nums, int size, List<Integer> indexes){
        int maxVal = nums[0];
        int index = 0;
        for(int i=1;i<size;i++){
            if(nums[i]>maxVal){
                maxVal = nums[i];
                index = i;
            }
        }
        System.out.println("Index : "+ index);
        indexes.add(0, index);
        indexes.add(1, index);
    }

    static int findSum(int[] nums, int start, int end){
        int sum = 0;
        System.out.println("Start : " + start + " End : "+ end);
        for(int i=start;i<=end;i++){
            sum+=nums[i];
        }
        return sum;
    }
}
