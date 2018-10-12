package com.buutcamp.main;

import com.buutcamp.configuration.AppConfig;
import com.buutcamp.countries.Canada;
import com.buutcamp.countries.Finland;
import com.buutcamp.inputhandle.HandleInput;
import com.buutcamp.interfaces.Country;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.HashMap;
import java.util.Map;

public class RunApp {

    public RunApp() {

        AnnotationConfigApplicationContext ctx = new
                AnnotationConfigApplicationContext(AppConfig.class);

        HandleInput handleInput = ctx.getBean("handleInput", HandleInput.class);
        Country finland = ctx.getBean("finland", Finland.class);
        Country canada= ctx.getBean("canada", Canada.class);

        Map<String, Country> countries = new HashMap<String, Country>();
        countries.put(finland.getCountryName().toLowerCase(), finland);
        countries.put(canada.getCountryName().toLowerCase(), canada);

        while (true) {
            System.out.print("Country: ");
            String userInput = handleInput.getUserInput();

            if (userInput.equals("exit"))
                return;

            Country userCountry = countries.get(userInput);
            if (userCountry == null)
                System.out.println("No country " + userInput);

            else {
                System.out.println("Country: " + userCountry.getCountryName());
                System.out.println("President: " + userCountry.getPresident());
                System.out.println("Population: " + userCountry.getPopulation());
            }

        }
    }
}
