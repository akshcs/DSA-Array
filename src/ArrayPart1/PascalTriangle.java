package ArrayPart1;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {

    public static void main(String[] args){
        int numRows = 5;
        List<List<Integer>> pascalTriangle = generate(numRows);
        for(List<Integer> pascalTriangleRow : pascalTriangle){
            for(int value: pascalTriangleRow){
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }

    static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> pascalTriangle = new ArrayList<>();
        if(numRows > 0){
            generatePascalTriangle(pascalTriangle, numRows);
        }
        return pascalTriangle;
    }

    private static void generatePascalTriangle(List<List<Integer>> pascalTriangle, int numRows){
        int prevRowNumber = -1;
        while(prevRowNumber < numRows-1){
            pascalTriangle.add(generateCurrentRow(pascalTriangle, prevRowNumber));
            prevRowNumber++;
        }
    }

    private static List<Integer> generateCurrentRow(List<List<Integer>> pascalTriangle, int prevRowNumber){
        List<Integer> currRow = new ArrayList<>();
        if(prevRowNumber < 0){
            currRow.add(1);
        } else {
            generateCurrentRowForValidPrevRow(currRow, pascalTriangle.get(prevRowNumber));
        }
        return currRow;
    }

    private static void generateCurrentRowForValidPrevRow(List<Integer> currRow, List<Integer> prevRow){
        int prevRowSize = prevRow.size();
        for(int i=-1;i<prevRowSize;i++){
            currRow.add(generateValue(prevRow, prevRowSize, i));
        }
    }

    private static int generateValue(List<Integer> prevRow, int prevRowSize, int i){
        int secondIndex = i +1;

        int value = 0;

        if(i >= 0){
            value+= prevRow.get(i);
        }

        if(secondIndex<prevRowSize){
            value+= prevRow.get(secondIndex);
        }

        return value;
    }
}
