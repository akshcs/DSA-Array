package ArrayPart2;

public class FindDuplicateWithoutSpace {

    public static void main(String[] args){
        int[] nums = {1,2,6,4,2,5,3};
        System.out.println(findDuplicate(nums));
    }
    static int findDuplicate(int[] nums) {
        int i=0;
        while(true){
            if(nums[i]!=0){
                int temp = nums[i];
                nums[i] = 0;
                i = temp;
            } else{
                return i;
            }
        }
    }
}
