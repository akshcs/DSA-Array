package ArrayPart1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SetMatrixZeroes {
    public static void main(String[] args) {
        int[][] matrix = {{0,1,2,0},{3,4,5,2},{1,3,1,5}};
        setZeroes(matrix);
        System.out.println(Arrays.deepToString(matrix));
    }

    static void setZeroes(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;

        List<Integer> rowList = new ArrayList<>();
        List<Integer> colList = new ArrayList<>();

        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(matrix[i][j] == 0){
                    rowList.add(i);
                    colList.add(j);
                }
            }
        }

        for(int r: rowList){
            for(int i=0;i<col;i++){
                matrix[r][i] = 0;
            }
        }


        for(int c: colList){
            for(int i=0;i<row;i++){
                matrix[i][c] = 0;
            }
        }
    }
}
