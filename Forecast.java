package lesson7;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Forecast {
    @JsonProperty("forecastday")
    private List<lesson7.Forecast.Forecastday> forecastday;

    public List<lesson7.Forecast.Forecastday> getForecastday() {
        return forecastday;
    }

    public static class Forecastday{
        @JsonProperty("date")
        private String date;
        @JsonProperty("day")
        private lesson7.Forecast.Forecastday.Day day;

        public String getDate(){
            return date;
        }

        public lesson7.Forecast.Forecastday.Day getDay(){
            return day;
        }

        public static class Day {
            @JsonProperty("maxtemp_c")
            private String maxTemperatureCelcius;
            @JsonProperty("mintemp_c")
            private String minTemperatureCelcius;
            @JsonProperty("condition")
            private lesson7.Forecast.Forecastday.Day.DayCondition dayCondition;
            @JsonProperty("totalsnow_cm")
            private String totalSnow;


            public String getMaxTemperatureCelcius() {
                return maxTemperatureCelcius;
            }

            public String getMinTemperatureCelcius() {
                return minTemperatureCelcius;
            }
            public String getTotalSnow(){
                return totalSnow;
            }

            public lesson7.Forecast.Forecastday.Day.DayCondition getDayCondition() {
                return dayCondition;
            }

            public static class DayCondition{
                @JsonProperty("text")
                private String text;

                public String getText(){
                    return text;
                }

                @Override
                public String toString() {
                    return text;
                }
            }
        }
    }
}
