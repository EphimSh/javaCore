package javaCore.lesson1;

public class Obstacle {
    private String name;
    private double distance;


    public Obstacle(String name, double distance){
        this.name = name;
        this.distance = distance;
    }

    public String getName() {
        return name;
    }

    public double getDistance() {
        return distance;
    }
}
