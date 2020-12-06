package com.example.junitlesson;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CalculatorServiceImplTest {

    @Autowired
    CalculatorService calculatorService;

    @Test
    void multiply() {
        assertEquals(6, calculatorService.multiply(2, 3));
    }

    @Test
    void divide() throws CalculatorException {
        assertEquals(2, calculatorService.divide(6, 3));
    }
}