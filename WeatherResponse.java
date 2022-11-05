package lesson6.okhttp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class WeatherResponse {
    @JsonIgnoreProperties(ignoreUnknown = true)
    static final String WEATHER_API =
            "https://api.weatherapi.com/v1/forecast.json?key=27120ec828d145d4bba92345223010&q=Saint-Petersburg&days=6&aqi=no&alerts=no";

    public static void main(String[] args) {
        final OkHttpClient client = new OkHttpClient.Builder()
                .connectTimeout(5, TimeUnit.SECONDS) // Configuring our client in case of timeout
                .build();

        Request request = new Request.Builder()
                .url(WEATHER_API)
                .build();

        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES); //Configuring our mapper to ignore unknown properties

            Response response = client.newCall(request).execute();
            MyJsonObject jsonWeatherResponse = mapper.readValue(response.body().string(), MyJsonObject.class);
            System.out.printf("Weather broadcast: \n" +
                            "City: %s\n" +
                            "Date: %s\n" +
                            "Temperature C: %s\n" +
                            "Weather_description: %s\n",
                    jsonWeatherResponse.getLocation().getName(),
                    jsonWeatherResponse.getLocation().getLocaltime(),
                    jsonWeatherResponse.getCurrent().getTemperature(),
                    jsonWeatherResponse.getCurrent().getCondition().getText());
            System.out.println("****");
            System.out.printf("Weather forecast on %s days\n", jsonWeatherResponse.getForecast().getForecastday().size());

            //Getting data from each of days
            for (int day = 0; day < jsonWeatherResponse.getForecast().getForecastday().size(); day++) {
                System.out.printf(
                        "City: %s\n" +
                                "Date: %s\n" +
                                "Max_Temperature C: %s\n" +
                                "Min_Temperature C: %s\n" +
                                "Weather_description: %s\n",
                        jsonWeatherResponse.getLocation().getName(),
                        jsonWeatherResponse.getForecast().getForecastday().get(day).getDate(),
                        jsonWeatherResponse.getForecast().getForecastday().get(day).getDay().getMaxTemp(),
                        jsonWeatherResponse.getForecast().getForecastday().get(day).getDay().getMinTemp(),
                        jsonWeatherResponse.getForecast().getForecastday().get(day).getDay().getDayCondition());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}


