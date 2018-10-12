package com.buutcamp.countries;

import com.buutcamp.interfaces.Country;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Finland implements Country {
    @Value("${finlandName}")
    private String name;
    @Value("${finlandPresident}")
    private String president;
    @Value("${finlandPopulation}")
    private int population ;

    public void setCountryName(String name) {
        this.name = name;
    }

    public String getCountryName() {
        return name;
    }

    public void setPresident(String president) {
        this.president = president;
    }

    public String getPresident() {
        return president;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public int getPopulation() {
        return population;
    }
}
