/*
 * Introduction to Java Logging and Testing
 * 
 * https://github.com/egalli64/jalt
 */
package com.example.jalt.m2.s8;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import com.example.jalt.m2.s6.Simple;

/**
 * Jupiter parameterized tests
 */
class SimpleTest {
    /**
     * Each test in this case work on an object created in the same way. There is no
     * need of a specific definition for each one, just put it at class level.
     */
    private Simple simple = new Simple();

    /**
     * Similar tests grouped together.
     * 
     * The parameter setting and conversion to the right type is done by JUnit
     * 
     * @param input    to be passed to the tested method
     * @param expected the expected result
     */
    @ParameterizedTest
    @CsvSource({ "12,true", "-42,false", "0,false" })
    void isPositive(int input, boolean expected) {
        boolean actual = simple.isPositive(input);
        assertEquals(expected, actual);
    }

    /**
     * Using textBlock in CsvSource could improve readability
     */
    @ParameterizedTest
    @CsvSource(textBlock = """
             42, -42
            -42,  42
              0,   0
            """)
    void negate(int input, int expected) {
        int actual = simple.negate(input);
        assertEquals(expected, actual);
    }

    /**
     * A missing CsvSource value is interpreted as null
     * 
     * A string could be delimited by _single_ quotes
     */
    @ParameterizedTest
    @CsvSource(textBlock = """
              42,
             -42, 'not a null'
               0,  not a null
            """)
    void nullIfPositive(int input, String expected) {
        String actual = simple.nullIfPositive(input);
        assertEquals(expected, actual);
    }

    /**
     * Use as many parameters as you need
     */
    @ParameterizedTest
    @CsvSource(textBlock = """
            0.29, 3.0, 0.87, 0.000_000_000_000_000_2
            2   , 3  , 6   , 0
            """)
    void multiply(double first, double second, double expected, double delta) {
        double actual = simple.multiply(first, second);
        assertEquals(expected, actual, delta);
    }
}
