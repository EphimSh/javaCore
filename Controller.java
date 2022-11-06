package javaCore.lesson6.OkHttp.WeatherResponseInterfaace;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static javaCore.lesson6.OkHttp.WeatherResponseInterfaace.Period.FIVE_DAY_FORECAST;
import static javaCore.lesson6.OkHttp.WeatherResponseInterfaace.Period.NOW;



public class Controller {



    private VöderModel weatherModel = new WeatherAPIModel();

    private Map<Integer, Period> variants = new HashMap<>();


    public Controller(){
        variants.put(1, NOW);
        variants.put(5, FIVE_DAY_FORECAST);

    }

    public void getWeather(String userInput, String cityName) throws IOException {
        Integer command = Integer.parseInt(userInput);

        switch (variants.get(command)){
            case NOW:
                weatherModel.getWeather(cityName, NOW);
                break;

            case FIVE_DAY_FORECAST:
                weatherModel.getWeather(cityName, FIVE_DAY_FORECAST);

        }
    }
}
