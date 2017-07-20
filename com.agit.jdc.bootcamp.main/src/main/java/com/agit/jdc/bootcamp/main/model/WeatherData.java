package com.agit.jdc.bootcamp.main.model;

/**
 *
 * @author bayutridewanto
 */
public class WeatherData {

    private static String[] categories;
    private static Number[] rainfall, temperature, pressure;

    static {
        categories = new String[]{
            "Jan", "Feb", "Mar", "Apr",
            "May", "Jun", "Jul", "Aug",
            "Sep", "Oct", "Nov", "Dec"
        };
        rainfall = new Double[]{
            49.9, 71.5, 106.4, 129.2,
            144.0, 176.0, 135.6, 148.5,
            216.4, 194.1, 95.6, 155.4};
        temperature = new Double[]{
            2.0, 3.9, 5.5, 7.5,
            9.2, 12.5, 15.2, 17.5,
            18.3, 19.3, 22.9, 25.6};
        pressure = new Number[]{
            1016, 1016, 1015.9, 1015.5,
            1012.3, 1009.5, 1009.6, 1010.2,
            1013.1, 1016.9, 1018.2, 1016.7};
    }

    public static Number[] getRainfall() {
        return rainfall;
    }

    public static Number[] getTemperature() {
        return temperature;
    }

    public static Number[] getPressure() {
        return pressure;
    }

    public static String[] getCategories() {
        return categories;
    }
}
