package javaCore.lesson3.homework3;

import javaCore.lesson3.GenericBox;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        FruitBox<Apple> appleFruitBox = new FruitBox<>();
        FruitBox<Orange> orangeFruitBox = new FruitBox<>();
        FruitBox<Orange> orangeFruitBox2 = new FruitBox<>();

        for (int i = 0; i < 5; i++) {
            appleFruitBox.add(new Apple());
        }
        for (int i = 0; i < 6; i++) {
            orangeFruitBox.add(new Orange());
        }
        for (int i = 0; i < 7; i++) {
            orangeFruitBox2.add(new Orange());
        }
        System.out.println(appleFruitBox);
        System.out.println(orangeFruitBox);



        System.out.println(appleFruitBox.getFruitBoxWeight());
        System.out.println(orangeFruitBox.getFruitBoxWeight());
        System.out.println(appleFruitBox.compare(orangeFruitBox));
        System.out.println(orangeFruitBox.size());

        System.out.println(orangeFruitBox);
        orangeFruitBox.pourOver(orangeFruitBox2);
        System.out.println(orangeFruitBox.size());
        System.out.println(orangeFruitBox2.size());

    }


}


