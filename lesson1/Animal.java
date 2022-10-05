package javaCore.lesson1;

import java.util.Objects;

public abstract class Animal implements Actions {
    private String name;
    private String color;
    private int age;
    private double speed;


    public void Animal(String name, String color, int age){
            this.name = name;
            this.color = color;
            this.age = age;
        }


    public void getInfo(){
        System.out.printf("{%s, %s, %s}", this.name, this.color, this.age);
    }

    public double run(Obstacle obstacle) {
        return obstacle.getDistance() / getSpeed();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getSpeed() {
        return speed;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "name='" + getName() + '\'' +
                ", color='" + getColor() + '\'' +
                ", age=" + getAge() +
                '}';
    }
}
