package javaCore.lesson6.OkHttp.WeatherResponseInterfaace;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class WeatherAPIModel implements VöderModel {


    //CURRENT
    // https://api.weatherapi.com/v1/current.json?key=27120ec828d145d4bba92345223010&q=Yakutsk&aqi=no
    private static final String PROTOCOL = "https";
    private static final String BASE_HOST = "api.weatherapi.com";
    private static final String VERSION = "v1";
    private static final String CURRENT = "current.json";
    private static final String FORECAST_JSON = "forecast.json";
    private static final String KEY_QUERY_PARAM = "key";
    private static final String API_KEY = "27120ec828d145d4bba92345223010";
    private static final String CITY_QUERY_PARAM = "q";
    private static final String CITY = "";
    private static final String DAYS_QUERY_PARAM = "days";
    private static final String DAYS_AMOUNT = null;
    private static final String AQI_QUERY_PARAM = "aqi";
    private static final String AQI_STATUS = "no";
    private static final String ALERTS_QUERY_PARAM = "alerts";
    private static final String ALERTS_STATUS = "no";

    private static final OkHttpClient client = new OkHttpClient();
    private static final ObjectMapper mapper = new ObjectMapper();



    @Override
    public void getWeather(String city, Period period) throws IOException {

        switch (period) {
            case NOW:
                currentDayWeatherRequest(city);

                break;


            case FIVE_DAY_FORECAST:
                FiveDayWeatherForecastOnNextDays(city);


        }

    }

    private void FiveDayWeatherForecastOnNextDays(String city) throws IOException {
        //FORECASThttps://api.weatherapi.com/v1/forecast.json?key=27120ec828d145d4bba92345223010&q=Yakutsk&days=10&aqi=no&alerts=no

        HttpUrl url = new HttpUrl.Builder()
                .scheme(PROTOCOL)
                .host(BASE_HOST)
                .addPathSegment(VERSION)
                .addPathSegment(FORECAST_JSON)
                .addQueryParameter(KEY_QUERY_PARAM, API_KEY)
                .addQueryParameter(CITY_QUERY_PARAM, detectCity(city))
                .addQueryParameter(DAYS_QUERY_PARAM, "5")
                .addQueryParameter(AQI_QUERY_PARAM, "no")
                .addQueryParameter(ALERTS_QUERY_PARAM, "no")
                .build();

        Request request = new Request.Builder()
                .url(url)
                .build();

        Response forecastWeatherResponse = client.newCall(request).execute();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        String jsonString = mapper.readTree(forecastWeatherResponse.body().string()).toString();

        MyWeatherJsonObject myWeatherJsonObject = mapper.readValue(jsonString, MyWeatherJsonObject.class);

        for (int day = 0; day < myWeatherJsonObject.getForecast().getForecastday().size(); day++) {
            System.out.printf(
                    "CITY: %s\n" +
                            "DATE: %s\n" +
                            "MAX_TEMPERATURE_CELCIUS: %s\n" +
                            "MIN_TEMPERATURE_CELCIUS: %s\n" +
                            "TOTAL_SNOW: %s\n" +
                            "WEATHER_CONDITION: %s\n",
                    myWeatherJsonObject.getLocation().getName(),
                    myWeatherJsonObject.getForecast().getForecastday().get(day).getDate(),
                    myWeatherJsonObject.getForecast().getForecastday().get(day).getDay().getMaxTemperatureCelcius(),
                    myWeatherJsonObject.getForecast().getForecastday().get(day).getDay().getMinTemperatureCelcius(),
                    myWeatherJsonObject.getForecast().getForecastday().get(day).getDay().getTotalSnow(),
                    myWeatherJsonObject.getForecast().getForecastday().get(day).getDay().getDayCondition());
            System.out.println("*****");

        }
    }

    private void currentDayWeatherRequest(String city) throws IOException {
        HttpUrl url = new HttpUrl.Builder()
                .scheme(PROTOCOL)
                .host(BASE_HOST)
                .addPathSegment(VERSION)
                .addPathSegment(CURRENT)
                .addQueryParameter(KEY_QUERY_PARAM, API_KEY)
                .addQueryParameter(CITY_QUERY_PARAM, detectCity(city))
                .addQueryParameter(AQI_QUERY_PARAM, "no")
                .build();

        Request request = new Request.Builder()
                .url(url)
                .build();

        Response OneDayWeatherResponse = client.newCall(request).execute();

        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        String jsonString = mapper.readTree(OneDayWeatherResponse.body().string()).toString();

        MyWeatherJsonObject myWeatherJsonObject = mapper.readValue(jsonString, MyWeatherJsonObject.class);

        System.out.printf(
                "CITY: %s\n" +
                        "DATE: %s\n" +
                        "TIME: %s\n" +
                        "TEMPERATURE_CELCIUS: %s\n" +
                        "WEATHER_CONDITION: %s\n",
                myWeatherJsonObject.getLocation().getName(),
                myWeatherJsonObject.getLocation().getDate(),
                myWeatherJsonObject.getLocation().getTime(),
                myWeatherJsonObject.getCurrent().getTemperatureCelcius(),
                myWeatherJsonObject.getCurrent().getCondition());
    }

    private String detectCity(String city) throws IOException {
        HttpUrl httpUrl = new HttpUrl.Builder()
                .scheme(PROTOCOL)
                .host(BASE_HOST)
                .addPathSegment(VERSION)
                .addPathSegment(CURRENT)
                .addQueryParameter(KEY_QUERY_PARAM, API_KEY)
                .addQueryParameter(CITY_QUERY_PARAM, city)
                .addQueryParameter(AQI_QUERY_PARAM, "no")
                .build();

        Request request = new Request.Builder()
                .url(httpUrl)
                .get()
                .addHeader("accept", "application/json")
                .build();


        Response OneDayWeatherResponse = client.newCall(request).execute();
        String weatherResponse = OneDayWeatherResponse.body().string();


        return mapper.readTree(weatherResponse).get("location").at("/name").toString();
    }





}
