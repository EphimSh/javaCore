package javaCore.lesson6.OkHttp.WeatherResponseInterfaace;

import java.io.IOException;

public interface VöderModel {

    void getWeather(String city, Period period) throws IOException;
}
