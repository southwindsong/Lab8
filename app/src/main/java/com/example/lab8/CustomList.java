package com.example.lab8;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class CustomList extends ArrayAdapter<City> {

    private ArrayList<City> cities;
    private Context context;

    public CustomList(Context context, ArrayList<City> cities) {
        super(context, 0, cities);
        this.cities = cities;
        this.context = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View view = convertView;

        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.content, parent, false);
        }

        City city = cities.get(position);

        TextView cityName = view.findViewById(R.id.city_text);
        TextView provinceName = view.findViewById(R.id.province_text);

        cityName.setText(city.getCityName());
        provinceName.setText(city.getProvinceName());

        return view;

    }

    public int getCount() {
        return cities.size();
    }

    /**
     * this adds a city object to the list
     * the second phase, you can add the city
     *
     * @param city
     */
    public void addCity(City city) {
        cities.add(city);
    }

    /**
     * Determines if a given city belongs in the list.
     *
     * @param city This is a candidate city to check
     * @return true if this list contains the city;
     * false if list doesn't contain the city.
     */
    public boolean hasCity(City city) {
        for (City loopCity : cities) {
            if (loopCity.compareTo(city) == 0)
                return true;
        }
        return false;
    }


    /**
     * Deletes a city from the list if the city is present.
     * throws: IllegalArgumentException, if the city is not present
     *
     * @param city This is a candidate city to delete
     */
    public void deleteCity(City city) {
        boolean hasCity = false;

        for (int i = 0; i < cities.size(); i++) {
            if (cities.get(i).compareTo(city) == 0) {
                // found the city
                hasCity = true;
                cities.remove(i);
            }
        }

        // when out of the loop, no such city, will raise exception
        if (hasCity == false) {
            throw new IllegalArgumentException();
        }
    }

    /**
     * Counts how many cities in the list.
     *
     * @return the cities counter
     */
    public int countCities() {
        return cities.size();
    }
}
