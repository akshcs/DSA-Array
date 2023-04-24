package ArrayPart2;

import java.util.Arrays;

public class MergeArraysWithoutSpace {
    public static void main(String[] args){
        Integer[] nums1 = {1,2,10,11,12,0,0,0,0};
        Integer[] nums2 = {5,6,7,14};
        merge(nums1, nums1.length-nums2.length, nums2, nums2.length);
        System.out.println(Arrays.deepToString(nums1));
    }
    static void merge(Integer[] nums1, Integer m, Integer[] nums2, int n) {
        rightShiftNum1ByN(nums1, m,n);
        mergeArrays(nums1, nums2, m, n);
    }

    static void rightShiftNum1ByN(Integer[] nums1, int m, int n){
        for(int i=m-1;i>=0;i--){
            nums1[i+n] = nums1[i];
        }
    }

    static void mergeArrays(Integer[] nums1, Integer[]nums2, int m, int n){
        int index1 = n;
        int index2 = 0;
        int outIndex = 0;
        while(index1<(m+n) && index2<n){
            if(nums1[index1]<=nums2[index2]){
                nums1[outIndex++] = nums1[index1++];
            } else {
                nums1[outIndex++] = nums2[index2++];
            }
        }
        mergeLeftOvers(nums1, nums2, m, n, index1, index2, outIndex);
    }

    static void mergeLeftOvers(Integer[] nums1, Integer[]nums2, int m, int n, int index1, int index2, int outIndex){
        while(index1<(m+n)){
            nums1[outIndex++] = nums1[index1++];
        }
        while(index2<n){
            nums1[outIndex++] = nums2[index2++];
        }
    }
}
