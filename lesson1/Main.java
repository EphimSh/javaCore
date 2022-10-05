package javaCore.lesson1;

public class Main {
    public static void main(String[] args) {

        Team team = new Team("Inglorious Bastards");
        Course course = new Course("round1");


        team.getInfo();
        course.gogo(team);
    }

}

