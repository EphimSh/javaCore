package javaCore.lesson6.OkHttp.WeatherResponseInterfaace;



public class MyWeatherJsonObject {
    private Location location;
    private Current current;
    private Forecast forecast;

    public Location getLocation() {
        return location;
    }

    public Current getCurrent() {
        return current;
    }

    public Forecast getForecast() {
        return forecast;
    }


}
