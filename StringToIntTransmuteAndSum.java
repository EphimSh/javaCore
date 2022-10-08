package javaCore.lesson2.homework2;

import java.text.Format;

public class StringToIntTransmuteAndSum {
    int result = 0;

    public void transmuteStringToIntAndSum(String[][] strArr) throws MyArraySizeException, MyArrayDataException {

        for(int i = 0; i <= strArr.length; i++){
            if(strArr.length > 4) throw new MyArraySizeException("ayo");
            for (int j = 0; j < strArr.length; j++) {
                if(strArr[i].length > 4) throw new MyArraySizeException("ayo");
                try {
                    result += Integer.parseInt(strArr[i][j]);
                } catch(Exception e){
                    System.out.printf("%s, lays in the cell: [%s] [%s]%n",e, i, j);
                    throw new MyArrayDataException("Please check your input");
                }

            }
        }
    }
    public int transmuteStringToIntSumResult(){
        return result;
    }


}






