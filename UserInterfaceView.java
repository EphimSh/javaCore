package lesson7;

import java.io.IOException;
import java.sql.SQLOutput;
import java.util.Scanner;

public class UserInterfaceView {
    WeatherAPIModel model = new WeatherAPIModel();


    public void runInterface() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Enter the city name:");
            String city = scanner.nextLine();

            System.out.println("Type 1 to get a current weather broadcast\n" +
                    "Type from 2 to 10 to get a forecast on amount of days\n" +
                    "Type 0 to exit program\n");

            String command = scanner.nextLine();


            if ("0".equals(command)) break;


            try {
                model.getWeather(city,Integer.parseInt(command));


            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("Error. Wrong request. Check if your input city name right");
            }
            System.out.println("Do you want to continue? Y/N");
            command = scanner.nextLine().toUpperCase();
            if ("N".equals(command)) {
                break;
            } else if ("Y".equals(command)) ;
        }
    }

    public static void main(String[] args) {
        UserInterfaceView view = new UserInterfaceView();
        view.runInterface();
    }
}
