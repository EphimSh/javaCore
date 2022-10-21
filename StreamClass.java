package javaCore.lesson5.hw;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class StreamClass {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        String file = "result.csv";
        File csvFile = new File("result1.csv");
        String line = "";
        String[] values;

        PrintWriter bwr = new PrintWriter(new FileWriter(csvFile));
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));

            while ((line = br.readLine()) != null) {
                values = line.split(";");
                bwr.println(values[0] + ";" + values[1] + ";" + values[2]);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        bwr.close();


    }
}
