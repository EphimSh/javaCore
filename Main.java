package javaCore.lesson2.homework2;

public class Main {
    public static void main(String[] args) {
        StringToIntTransmuteAndSum stringToIntTransmuteAndSum = new StringToIntTransmuteAndSum();

        String[][] str = new String[][]{
                {"1", "2", "3", "4"},
                {"1", "2", "3", "4"},
                {"1", "2", "3", "4"},
                {"1", "2", "3", "four"},
//                {"1", "2", "3", "four"}
        };

        try {
            stringToIntTransmuteAndSum.transmuteStringToIntAndSum(str);
        } catch (MyArrayDataException | MyArraySizeException mde) {
            System.out.println(mde.getMessage());
            System.out.printf("Result of sum of all parsed integers is: %s",stringToIntTransmuteAndSum.transmuteStringToIntSumResult());
        }

    }
}



