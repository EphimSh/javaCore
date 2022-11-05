package lesson6.okhttp;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Day {
    @JsonProperty("maxtemp_c")
    private String maxTemp;
    @JsonProperty("mintemp_c")
    private String minTemp;
    @JsonProperty("forecast_day_condition")
    @JsonAlias("condition")
    private ForecastDayCondition dayCondition;

    private String text;

    public String getMaxTemp() {
        return maxTemp;
    }

    public String getMinTemp() {
        return minTemp;
    }

    public ForecastDayCondition getDayCondition() {
        return dayCondition;
    }

    public class ForecastDayCondition {
        @JsonProperty("text")
        private String text;

        public String text() {
            return text;
        }

        @Override
        public String toString() {
            return text;
        }
    }

}
