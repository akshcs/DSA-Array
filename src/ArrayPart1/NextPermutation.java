package ArrayPart1;
public class NextPermutation {

    public static void main(String[] args){
        int[] nums = {2,1,3};
        nextPermutation(nums);
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }
    static void nextPermutation(int[] nums) {
        int size = nums.length;
        int pivot = findPivot(nums, size);
        int swapPivot = findSwapPivot(nums, size, pivot);
        if(swapPivot==-1){
            swapArrayFromIndexToEnd(nums, 0, size-1);
        } else {
            swapArrayElement(nums, pivot, swapPivot);
            swapArrayFromIndexToEnd(nums, pivot+1, size-1);
        }
    }

    static int findPivot(int[] nums, int size){
        int pivot = -1;
        for(int i=size-2;i>=0;i--){
            if(nums[i+1] > nums[i]){
                pivot = i;
                break;
            }
        }
        return pivot;
    }

    static int findSwapPivot(int[] nums, int size, int pivot){
        int swapPivot = -1;
        if(pivot!=-1){
            swapPivot = findNextIndexWithSmallesElementLargerThanPivot(nums, size, pivot, swapPivot);
        }
        return swapPivot;
    }

    static int findNextIndexWithSmallesElementLargerThanPivot(int[] nums, int size, int pivot, int swapPivot){
        int pivotValue = nums[pivot];
        int minVal = Integer.MAX_VALUE;
        for(int i=pivot+1;i<size;i++){
            if(nums[i] > pivotValue){
                if(nums[i]<=minVal){
                    minVal = nums[i];
                    swapPivot = i;
                }
            }
        }
        return swapPivot;
    }

    static void swapArrayElement(int[] nums, int index1, int index2){
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }

    static void swapArrayFromIndexToEnd(int[] nums, int start, int end){
        while(start<end){
            swapArrayElement(nums, start++, end--);
        }
    }
}
