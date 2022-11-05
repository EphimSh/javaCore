package lesson6.okhttp;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.stream.Collectors;

public class Forecast {

    @JsonProperty("forecastday")
    private List<Forecastday> forecastday;

    public List<Forecastday> getForecastday() {

        return forecastday;
    }

}
