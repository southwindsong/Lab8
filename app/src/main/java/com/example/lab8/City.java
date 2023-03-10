package com.example.lab8;

public class City implements Comparable {

    private String city;
    private String province;

    public City(String city, String province){
        this.city = city;
        this.province = province;
    }

    String getCityName(){
        return this.city;
    }

    String getProvinceName(){
        return this.province;
    }

    /**
     * Compares to a city by its name.
     *
     * @param o the city object to be compared.
     * @return a negative integer, when this city is less than the specified object;
     *  zero, when this city is equal to the specified object;
     *  a positive integer, when this city is greater than the specified object.
     */
    @Override
    public int compareTo(Object o) {
        City city = (City) o;
        return this.city.compareTo(city.getCityName());
    }
}
