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
        Country canada = ctx.getBean("canada", Canada.class);

        Map<String, Country> countries = new HashMap<String, Country>();
        countries.put(finland.getCountryName().toLowerCase(), finland);
        countries.put(canada.getCountryName().toLowerCase(), canada);

        while (true) {
            System.out.print("Country info: ");
            String userInput = handleInput.getUserInput();

           // String[] inputs = userInput.split(" "); //user input: canada set name=new name;
            if (userInput.equals("exit"))
                return;

            Country userCountry = countries.get(userInput);
            if (userCountry == null)
                System.out.println("No country " + userInput);

            else {
                handleInput.showCountryInfo(userCountry);

                while (true) {
                    System.out.print("Change " + userCountry.getCountryName() +
                            " name(N), president(PR), population(PO)? Or select new country(NEW): ");
                    String input = handleInput.getUserInput().toLowerCase();

                    if (input.equals("n")) {
                        System.out.print("New country name: ");
                        input = handleInput.getUserInput();
                        userCountry.setCountryName(input);
                        countries.put(input, userCountry);
                        countries.remove(userInput);

                    } else if (input.equals("pr")) {
                        System.out.print("New president name: ");
                        input = handleInput.getUserInput();
                        userCountry.setPresident(input);

                    } else if (input.equals("po")) {
                        System.out.print("New population: ");
                        input = handleInput.getUserInput();
                        userCountry.setPopulation(input);

                    } else if (input.equals("new"))
                        break;

                    else if (input.equals("exit"))
                        return;

                    else
                        System.out.println("Invalid command");

                    handleInput.showCountryInfo(userCountry);
                }
            }
        }
    }
}
