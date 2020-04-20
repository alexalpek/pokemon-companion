package com.codecool.pokemoncompanion.service;


import org.springframework.stereotype.Service;

import java.math.RoundingMode;
import java.text.DecimalFormat;

@Service
public class CalculatorService {


    public String calculateIV(Integer hp, Integer attack, Integer defense) {
        double divider = 45;
        DecimalFormat decimalFormat = new DecimalFormat("#");
        decimalFormat.setRoundingMode(RoundingMode.DOWN);
        return decimalFormat.format((hp + attack + defense) / divider * 100);
    }

}
