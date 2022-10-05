package javaCore.lesson1;

import java.util.Arrays;

public class Course  {

    private String courseName;
    private Obstacle[] obstacles;




    public Course(String courseName){
        this.courseName = courseName;
        this.obstacles = new Obstacle[]{new Obstacle("LabyrinthOfDeath", 1100), new Obstacle("GeekBrains", 365)};

    }


    public String gogo(Team team){
        System.out.println("******************");
        double tT = 0;
        System.out.println("Showing results");
        for(Obstacle obstacle : obstacles){
            tT = team.getTotalTime(obstacle);
            System.out.printf("Team _%s_ have finished %s with total time: %s seconds %n", team.getTeamName(), obstacle.getName(), tT);
            team.sendAnimalThrough(obstacle);
        }
        System.out.println("*****************");
        return null;
    }


}
