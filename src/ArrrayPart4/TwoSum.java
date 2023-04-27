package ArrrayPart4;

import java.util.*;

public class TwoSum {

    public static void main(String[] args){
        int[] nums = {1,3,4,7,10,4,8};
        Integer[] out = twoSum(nums);
        System.out.println(Arrays.deepToString(out));
    }
    static Integer[] twoSum(int[] nums) {
        Map<Integer, ArrayList<Integer>> numsCount = buildCountMap(nums);
        for(int key: numsCount.keySet()){
            int val = 12 - key;
            if(numsCount.containsKey(val)){
                if(val == key){
                    if(numsCount.get(key).size()>1){
                        return new Integer[]{numsCount.get(key).get(0), numsCount.get(key).get(1)};
                    }
                } else {
                    return new Integer[]{numsCount.get(key).get(0), numsCount.get(val).get(0)};
                }
            }
        }
        return null;
    }

    static void addToMap(Map<Integer, ArrayList<Integer>> numsCount, int num, int index){
        if(!numsCount.containsKey(num)){
            numsCount.put(num, new ArrayList<>(List.of(index)));
        } else {
            numsCount.get(num).add(index);
        }
    }

    static Map<Integer, ArrayList<Integer>> buildCountMap(int[] nums){
        Map<Integer, ArrayList<Integer>> numsCount = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            addToMap(numsCount, nums[i], i);
        }
        return numsCount;
    }
}
