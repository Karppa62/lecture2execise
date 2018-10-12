package com.buutcamp.countries;

import com.buutcamp.interfaces.Country;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Canada implements Country {

    @Value("${canadaName}")
    private String name;
    @Value("${canadaPresident}")
    private String president;
    @Value("${canadaPopulation}")
    private String population;


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

    public void setPopulation(String population) {
        this.population = population;
    }

    public String getPopulation() {
        return population;
    }
}
