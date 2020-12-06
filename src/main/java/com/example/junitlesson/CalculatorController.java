package com.example.junitlesson;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/calculator")
public class CalculatorController {

    @Autowired
    CalculatorService calculatorService;

    @GetMapping("/multiply")
    public int multiply(@RequestParam("x") int x, @RequestParam("y") int y) {
        return calculatorService.multiply(x, y);
    }

    @GetMapping("/divide")
    public double divide(@RequestParam("dividend") int dividend, @RequestParam("divisor") int divisor) throws CalculatorException {
        return calculatorService.divide(dividend, divisor);
    }
}
