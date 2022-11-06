package javaCore.lesson6.OkHttp.WeatherResponseInterfaace;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Location {
    @JsonProperty("name")
    private String name;
    @JsonProperty("local_time")
    @JsonAlias("localtime")
    private String localtime;

    private String time;

    public String getName() {
        return name;
    }

    public String getTime(){
        return localtime.split(" ")[1];
    }

    public String getDate() {
        return localtime.split(" ")[0];
    }

    @Override
    public String toString() {
        return name + getDate();
    }
}
