package ArrayPart2;

import java.util.Arrays;

public class RepeatAndMissingWithoutSpace {
    public static void main(String[] args){
        int[] nums = {1,2,6,4,2,5,3};
        System.out.println(Arrays.deepToString(repeatedNumber(nums)));
    }
    static Integer[] repeatedNumber(final int[] A) {
        int n = A.length;
        int repeat;
        int missing;
        long missingMinusRepeat = 0;
        long missingSquareMinusRepeatSquare = 0;
        for(int i=1;i<=n;i++){
            missingMinusRepeat+= i-A[i-1];
            long squareActual = ((long)A[i-1])*((long)A[i-1]);
            long expected = ((long)i)*((long)i);
            missingSquareMinusRepeatSquare+= (expected-squareActual);
        }
        long missingPlusRepeat = missingSquareMinusRepeatSquare/missingMinusRepeat;
        missing =  (int) ((missingPlusRepeat + missingMinusRepeat)/2);
        repeat = (int) (missingPlusRepeat - missing);
        return new Integer[]{repeat, missing};
    }
}
