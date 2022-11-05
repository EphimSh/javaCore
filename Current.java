package lesson6.okhttp;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Current {
    private Condition condition;
    @JsonProperty("temp_C")
    @JsonAlias("temp_c")
    private String temperature;



    public String getTemperature() {
        return temperature;
    }

    @Override
    public String toString() {
        return  temperature;
    }


    public Condition getCondition(){
        return condition;
    }
    public class Condition {
        private String text;
        public String getText(){
            return text;
        }
    }
}
