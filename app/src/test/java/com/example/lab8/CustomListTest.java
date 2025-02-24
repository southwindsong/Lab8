package com.example.lab8;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


//import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class CustomListTest {

    private CustomList list;

    /**
     * create a mocklist for my citylist
     *
     * @return
     */
    public CustomList MockCityList() {
        list = new CustomList(null, new ArrayList<>());
        return list;
    }

    /**
     * get the size of the list
     * increase the list by adding a new city
     * check if our current size matches the initial size plus one
     */
    @Test
    public void addCityTest() {
        list = MockCityList();
        int listSize = list.getCount();
        list.addCity((new City("Estevan", "SK")));
        assertEquals(list.getCount(), listSize + 1);
    }

    /**
     * initialize the list
     * increase the list by adding a new city
     * check if list hasCity method returns true
     */
    @Test
    public void hasCityTest() {
        list = MockCityList();
        City city = new City("Edmonton", "AB");
        list.addCity(city);
        assertTrue(list.hasCity(city));
    }

    /**
     * add a new city
     * get the size of the list
     * decrease the list by deleting the newly added city
     * check if our current size matches the size minus one
     */
    @Test
    public void deleteCityTest() {
        list = MockCityList();
        City city = new City("Edmonton", "AB");
        list.addCity(city);
        int listSize = list.getCount();
        list.deleteCity(city);
        assertEquals(list.getCount(), listSize - 1);
    }

    /**
     * get the size of the list
     * increase the list by adding a new city
     * check if our countCities method matches the initial size plus one
     */
    @Test
    public void countCitiesTest() {
        list = MockCityList();
        int listSize = list.getCount();
        list.addCity((new City("Edmonton", "AB")));
        assertEquals(list.countCities(), listSize + 1);
    }
}
