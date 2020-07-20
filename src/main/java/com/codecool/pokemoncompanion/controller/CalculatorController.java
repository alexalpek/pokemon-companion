package com.codecool.pokemoncompanion.controller;

import com.codecool.pokemoncompanion.model.IVValues;
import com.codecool.pokemoncompanion.service.CalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin
@RequestMapping("/pokemon")
public class CalculatorController {

    @Autowired
    CalculatorService calculatorService;


    @PostMapping("/ivcalculator")
    public String sendIvValue(@RequestBody IVValues ivValues) {
        return calculatorService.calculateIV(ivValues.getHp(), ivValues.getAttack(), ivValues.getDefense());
    }

}
