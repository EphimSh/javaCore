package javaCore.lesson2.homework2;

import java.text.Format;

public class StringToIntTransmuteAndSum {


    public void transmuteStringToInt(String[][] strArr) throws MyArraySizeException, MyArrayDataException {

        if (strArr.length == 4) {

            int result = 0;
            int i = 0;
            for (i = 0; i < strArr.length; i++) {

                for (int j = 0; j < strArr[i].length; j++) {

                    try {
                        int foo = Integer.parseInt(strArr[i][j]);
                        result += foo;
                    } catch (Exception e) {
                        System.out.printf("%s is in array cell[%s][%s] %n", e, i, j);

                        if(i == 3 && j == 3) {
                            System.out.printf("Total result of all integers in this array is: %s%n", result);
                            throw new MyArrayDataException("Please check your variables in array");
                        }
                    }

                }


            }


        }

        throw new MyArraySizeException("ayo, wrong array size");
    }

}



