package ua.kpi.tef2.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DataReader {

    private BufferedReader reader;

    public DataReader() {
        reader = new BufferedReader(new InputStreamReader(System.in));
    }

    public String readInput() {
        String input = "";
        try {
            return reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return input;
    }

}
