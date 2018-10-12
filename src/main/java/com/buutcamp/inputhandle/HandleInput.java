package com.buutcamp.inputhandle;

import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@Component
public class HandleInput {

    public String getUserInput(){
        String userInput = "";
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

            userInput = bufferedReader.readLine().toLowerCase().trim();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return userInput;
    }



}
