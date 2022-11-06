package javaCore.lesson6.OkHttp.WeatherResponseInterfaace;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Forecast {
    @JsonProperty("forecastday")
    private List<javaCore.lesson6.OkHttp.Forecast.Forecastday> forecastday;

    public List<javaCore.lesson6.OkHttp.Forecast.Forecastday> getForecastday() {
        return forecastday;
    }

    public static class Forecastday{
        @JsonProperty("date")
        private String date;
        @JsonProperty("day")
        private javaCore.lesson6.OkHttp.Forecast.Forecastday.Day day;

        public String getDate(){
            return date;
        }

        public javaCore.lesson6.OkHttp.Forecast.Forecastday.Day getDay(){
            return day;
        }

        public static class Day {
            @JsonProperty("maxtemp_c")
            private String maxTemperatureCelcius;
            @JsonProperty("mintemp_c")
            private String minTemperatureCelcius;
            @JsonProperty("condition")
            private javaCore.lesson6.OkHttp.Forecast.Forecastday.Day.DayCondition dayCondition;
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

            public javaCore.lesson6.OkHttp.Forecast.Forecastday.Day.DayCondition getDayCondition() {
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
