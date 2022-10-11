package javaCore.lesson3.homework3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class FruitBox<F extends Fruit> extends ArrayList<F> {
    private float fruitBoxWeight;


    public float getFruitBoxWeight() {
        for (F f : this) {
            fruitBoxWeight += f.getWeight();
        }
        return fruitBoxWeight;
    }

    public boolean compare(FruitBox<?> another) {
        return this.getFruitBoxWeight() == another.getFruitBoxWeight();
    }

    ;


    public void pourOver(FruitBox<F> another) {

        for (int i = 0; i < this.size(); i++) {
            another.add(this.remove(i));
        }
        this.clear();
    }


}
