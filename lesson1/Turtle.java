package javaCore.lesson1;

public class Turtle extends Animal{

    private double speed;

    public Turtle(String name, String color, int age) {
        this.speed = Math.random() * 3;
        super.Animal(name, color, age);
    }

    @Override
    public void voice() {
        System.out.println("CAWABANGA");
    }



    public String toString() {
        return "Turtle{" +
                "name='" + getName() + '\'' +
                ", color='" + getColor() + '\'' +
                ", age=" + getAge() +
                '}';
    }

    public double getSpeed() {
        return speed;
    }
}
