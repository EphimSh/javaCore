package javaCore.lesson1;

public class Wolf extends Animal{
    private double speed;


    public Wolf(String name, String color, int age) {
        this.speed = Math.random() * 7;
        super.Animal(name, color, age);
    }

    @Override
    public void voice() {
        System.out.println("HOWLING AT THE MOON");
    }



    public String toString() {
        return "Wolf{" +
                "name='" + getName() + '\'' +
                ", color='" + getColor() + '\'' +
                ", age=" + getAge() +
                '}';
    }

    public double getSpeed() {
        return speed;
    }
}
