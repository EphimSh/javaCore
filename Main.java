package javaCore.lesson2.homework2;

public class Main {
    public static void main(String[] args) {
        StringToIntTransmuteAndSum stringToIntTransmuteAndSum = new StringToIntTransmuteAndSum();

        String[][] str = new String[][]{
                {"one", "2", "3", "4"},
                {"1", "two", "3", "4"},
                {"1", "2", "three", "4"},
                {"1", "2", "3", "four"},
//                {"6", "4", "3", "2", "1"}
        };

        try {
            stringToIntTransmuteAndSum.transmuteStringToInt(str);
        } catch (MyArrayDataException | MyArraySizeException mde) {
            System.out.println(mde.getMessage());
        }

    }
}



