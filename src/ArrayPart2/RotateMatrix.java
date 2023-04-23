package ArrayPart2;

public class RotateMatrix {
    public static void main(String[] args){
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        rotate(matrix);
        printMatrix(matrix);
    }
    static void rotate(int[][] matrix) {
        transposeMatrix(matrix);
        reverseEachRow(matrix);
    }

    static void transposeMatrix(int[][] matrix){
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix.length;j++){
                if(i < j) swap(matrix, i, j, j, i);
            }
        }
    }

    static void reverseEachRow(int[][] matrix){
        for(int i=0;i<matrix.length;i++){
            reverseRow(matrix, i);
        }
    }

    static void reverseRow(int[][] matrix, int row){
        int start = 0;
        int end = matrix.length-1;
        while(start<end){
            swap(matrix, row, row, start++, end--);
        }
    }

    static void swap(int[][] matrix, int row1, int row2, int col1, int col2){
        // System.out.println(" Row 1 : " + row1 + " Col 1: " + col1 + " Row 2 :" + row2 + " Col 2 : " +col2);
        int temp = matrix[row1][col1];
        matrix[row1][col1] = matrix[row2][col2];
        matrix[row2][col2] = temp;
    }

    static void printMatrix(int[][] matrix){
        for (int[] ints : matrix) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.print(ints[j] + " ");
            }
            System.out.println(" ");
        }
    }
}
