package javaCore.lesson1;

public class Cat extends Animal {

    private double speed;

    public Cat(String name, String color, int age) {
        this.speed = Math.random() * 5;
        super.Animal(name, color, age);
    }


    @Override
    public void voice() {
        System.out.println("Cat goes MEOW!");
    }


    @Override
    public String toString() {
        return "Cat{" +
                "name='" + getName() + '\'' +
                ", color='" + getColor() + '\'' +
                ", age=" + getAge() +
                '}';
    }

    public double getSpeed() {
        return speed;
    }
}
