package com.agit.jdc.bootcamp.main.model;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 *
 * @author bayutridewanto
 */
public class ComboData {

    private static String[] categories;
    private static Map<String, Integer[]> consumption;
    private static final int unitSize = 5;

    static {
        categories = new String[]{
            "Jan", "Feb", "Mar", "Apr",
            "May", "Jun", "Jul", "Aug",
            "Sep", "Oct", "Nov", "Dec"
        };
        consumption = new LinkedHashMap<String, Integer[]>();
        consumption.put("Jane", new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12});
        consumption.put("John", new Integer[]{2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13});
        consumption.put("Joe", new Integer[]{3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14});
    }

    public static Map<String, Integer[]> getConsumption() {
        return consumption;
    }

    public static Double[] getAverage() {
        Double[] average = new Double[]{0.0, 0.1, 0.2, 0.3, 0.4, 0.2, 0.3, 0.4, 0.3, 0.2, 0.1, 0.0};
        for (Integer[] values : consumption.values()) {
            for (int i = 0; i < unitSize; i++) {
                average[i] += values[i];
            }
        }
        for (int i = 0, size = consumption.size(); i < unitSize; i++) {
            average[i] = (double) (Math.round(average[i] / size * 100)) / 100;
        }
        return average;
    }

    public static Integer getSum(String person) {
        Integer sum = 0;
        for (Integer value : consumption.get(person)) {
            sum += value;
        }
        return sum;
    }

    public static String[] getCategories() {
        return categories;
    }
}
