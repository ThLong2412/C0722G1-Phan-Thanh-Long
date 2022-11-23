package com.codegym.service.impl;

import com.codegym.service.ICalculatorService;
import org.springframework.stereotype.Service;

@Service
public class CalculatorService implements ICalculatorService {


    @Override
    public double func(double num1, double num2, String func) {
        double result;
        switch (func) {
            case "+":
              result = num1 + num2;
              break;
            case "-":
                result = num1 - num2;
                break;
            case "*":
                result = num1 * num2;
                break;
            case "/":
                result = num1 / num2;
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + func);
        }
        return result;
    }
}
