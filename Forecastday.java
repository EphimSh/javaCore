package lesson6.okhttp;

import com.fasterxml.jackson.annotation.JacksonAnnotationsInside;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;


public class Forecastday {
    private Day day;
    private String date;

    public String getDate() {
        return date;
    }

    public Day getDay() {
        return day;
    }
}
