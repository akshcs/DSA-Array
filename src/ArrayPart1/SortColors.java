package ArrayPart1;

import java.util.HashMap;
import java.util.Map;

public class SortColors {
    public static void main(String[] args){
        int[] nums = {2,1,0,0,1,0,2,1,0};
        sortColors(nums);
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }
    static void sortColors(int[] nums) {
        Map<Integer, Integer> colorCount = getColorCount(nums);
        updateArrayWithCount(nums, colorCount);
    }

    static Map<Integer, Integer> getColorCount(int[] nums){
        Map<Integer, Integer> colorCount = new HashMap<>();
        for (int num : nums) {
            if (!colorCount.containsKey(num)) {
                colorCount.put(num, 1);
            } else {
                int val = colorCount.get(num);
                colorCount.put(num, val + 1);
            }
        }
        return colorCount;
    }

    static void updateArrayWithCount(int[] nums, Map<Integer, Integer> colorCount){
        int start = 0;
        for(int i=0;i<=2;i++){
            if(colorCount.containsKey(i)){
                start = updateArrayForValue(nums, i, colorCount.get(i), start);
            }
        }
    }

    static int updateArrayForValue(int[] nums, int value, int count, int start){
        while(count>0){
            nums[start++] = value;
            count--;
        }
        return start;
    }
}
