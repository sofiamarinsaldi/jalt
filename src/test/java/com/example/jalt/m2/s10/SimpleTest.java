/*
 * Introduction to Java Logging and Testing
 * 
 * https://github.com/egalli64/jalt
 */
package com.example.jalt.m2.s10;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

/**
 * Test case for Simple::negate()
 * 
 * How to test a method that could throw an exception
 */
class SimpleTest {
    private Simple simple = new Simple();

    @ParameterizedTest
    @CsvSource(textBlock = """
              0,   0
             42, -42
            -25,  25
            """)
    void negate(int input, int expected) {
        int actual = simple.negate(input);
        assertThat(actual).isEqualTo(expected);
    }

    /**
     * Negate max integer value
     */
    @Test
    void negateMaxValue() {

        int value = Integer.MAX_VALUE;
        int expected = -Integer.MAX_VALUE;

        int result = simple.negate(value);
        assertThat(result).isEqualTo(expected);
    }

    /**
     * This test, when enabled, would crash with an IllegalArgumentException
     */
    @Test
    @Disabled
    void negateExceptionUncaught() {
        int actual = simple.negate(Integer.MIN_VALUE);
        assertThat(actual).isEqualTo(Integer.MIN_VALUE);
    }

    /**
     * Can't negate minimum integer value - legacy test
     */
    @Test
    void negateException() {
        try {
            int actual = simple.negate(Integer.MIN_VALUE);
            fail("An IllegalArgumentException was expected, instead I've got " + actual);
        } catch (IllegalArgumentException ex) {
            String message = ex.getMessage();
            assertThat(message).isEqualTo("Can't negate MIN_VALUE");
        }
    }

    /**
     * Can't negate minimum integer value - alternative legacy test
     */
    @Test
    void negateExceptionAlternative() {
        try {
            simple.negate(Integer.MIN_VALUE);
        } catch (IllegalArgumentException ex) {
            String message = ex.getMessage();
            assertThat(message).isEqualTo("Can't negate MIN_VALUE");
            return;
        }
        fail("An IllegalArgumentException was expected");
    }
}
