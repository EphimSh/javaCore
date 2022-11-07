package lesson7;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Current {
    @JsonProperty("current_temperature_c")
    @JsonAlias("temp_c")
    private String temperatureCelcius;
    @JsonProperty("condition")
    private lesson7.Current.Condition condition;

    public String getTemperatureCelcius(){
        return temperatureCelcius;
    }

    public lesson7.Current.Condition getCondition(){
        return condition;
    }

    @Override
    public String toString() {
        return  temperatureCelcius + condition;
    }

    public static class Condition{
        @JsonAlias("text")
        private String text;

        public Condition(){}

        public String getText(){
            return text;
        }

        @Override
        public String toString() {
            return text;
        }
    }
}
