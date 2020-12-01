package com.company;

import java.lang.reflect.Array;
import java.util.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Collection;

public class pr26 {

    public static void main(String[] args) {
        //Задание 1
        HashMap<String, String> slovar = new HashMap<>();
        slovar.put("Полетаев", "Владимир");
        slovar.put("Яшунин", "Егор");
        slovar.put("Якунина", "Лина");
        slovar.put("Касьянов", "Мирослав");
        slovar.put("Верцихин", "Карл");
        slovar.put("Яковлев", "Вадим");
        slovar.put("Беляев", "Егор");
        slovar.put("Погодин", "Вадим");
        slovar.put("Фролов", "Иван");
        slovar.put("Мясников", "Вячеслав");
        HashMap<String, String> copy1 = new HashMap<>(slovar);
        HashMap<String, String> copy2 = new HashMap<>(slovar);
        for (Map.Entry<String, String> hash : copy1.entrySet()) {
            String name = hash.getValue();
            for (Map.Entry<String, String> map : copy2.entrySet()) {
                if (map.getValue().equals(name) && !map.equals(hash)) {
                    slovar.remove(map.getKey());
                    break;
                }
            }
        }
        System.out.println(slovar);
        //Задание 2
        HashMap<String, ArrayList<String>> hash = new HashMap<>();
        ArrayList<City> cities = new ArrayList<>();
        cities.add(new City("Moscow", "Russia"));
        cities.add(new City("Orel", "Russia"));
        cities.add(new City("New-York", "USA"));
        cities.add(new City("Detroit", "USA"));
        cities.add(new City("Lourense", "USA"));
        cities.add(new City("Berlin", "Germany"));
        for (City c : cities) {
            if (!hash.containsKey(c.getCountry())) {
                ArrayList<String> array = new ArrayList<>();
                hash.put(c.getCountry(), array);
            }
            hash.get(c.getCountry()).add(c.getCity());
        }
            System.out.println(hash);
        }
    }

class City{
    public String city;
    public String country;

    public City(String city, String country){
        this.city=city;
        this.country=country;
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }
}
