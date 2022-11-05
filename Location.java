package lesson6.okhttp;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Location {


    @JsonProperty("name")
    private String name;
    @JsonProperty("local_time")
    @JsonAlias("localtime")
    private String localTime;

    public String getName() {
        return name;
    }

    public String getLocaltime() {
        return localTime;
    }

    public String toString() {
        return name + localTime;
    }
}
