package com.dharun;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Calculator {

    private static final Logger log =
            LoggerFactory.getLogger(Calculator.class);

    public static void main(String[] args) {

        int a = 10;
        int b = 5;

        log.info("Addition: {}", a + b);
        log.info("Subtraction: {}", a - b);
        log.info("Multiplication: {}", a * b);
        log.info("Division: {}", a / b);
    }
}