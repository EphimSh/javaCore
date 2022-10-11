package javaCore.lesson3.homework3;

import java.util.ArrayList;

public abstract class Fruit {
    private String name;
    private float weight;

    public Fruit() {

    }

    public String getName() {
        return name;
    }

    public float getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return "Fruit{" +
                "name='" + getName() + '\'' +
                ", weight=" + getWeight() +
                '}';
    }
}
