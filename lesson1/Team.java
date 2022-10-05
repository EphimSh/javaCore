package javaCore.lesson1;

public class Team {

    private String name;
    private Animal[] team;

    public Team(String name) {
        this.name = name;
        this.team = new Animal[]{new Cat("Buba", "black", 2), new Wolf("Jack", "grey", 6), new Cat("Tommy", "red", 999), new Turtle("Raphael", "green", 2)};
    }

    public void getInfo() {
        for (Animal animal : this.team) {
            System.out.println(animal);
        }
    }

    public double getTeamAnimalSpeed() {
        double animalSpeed = 0;
        for (Animal animal : this.team) {
            animalSpeed = animal.getSpeed();
            return animalSpeed;
        }
       return 0;
    }
    public void sendAnimalThrough(Obstacle obstacle){
        for (Animal animal : this.team){
            double personalTime = 0;
            personalTime = obstacle.getDistance() / animal.getSpeed();
            System.out.printf("%s have run through this horror with only: %s seconds %n", animal.getName(), personalTime);
            animal.voice();
        }
        System.out.println("❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤❤");
    }
    public double getTotalTime(Obstacle obstacle){
        double totalTime = 0;
        for(Animal animal: this.team){
            totalTime += obstacle.getDistance() / animal.getSpeed();
        }
        return totalTime;
    }

    public String getTeamName(){
        return this.name;
    }


}
