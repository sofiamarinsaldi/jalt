/*
 * Introduction to Java Logging and Testing
 * 
 * https://github.com/egalli64/jalt
 */
package com.example.jalt.m2.s9;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.withPrecision;

import org.junit.jupiter.api.Test;

import com.example.jalt.m2.s6.Simple;

/**
 * AssertJ assertions
 */
class SimpleAJTest {
    /**
     * Each test in this case work on an object created in the same way. There is no
     * need of a specific definition for each one, just put it at class level.
     */
    private Simple simple = new Simple();

    /**
     * Assert that the actual value is true
     */
    @Test
    void isPositiveWhenPositiveThenTrue() {
        boolean actual = simple.isPositive(42);
        assertThat(actual).isTrue();
    }

    /**
     * Assert that the actual value is true (more verbose)
     */
    @Test
    void isPositiveWhenPositiveThenTrueVerbose() {
        int input = 42;
        boolean actual = simple.isPositive(input);
        assertThat(actual).isEqualTo(true);
    }

    /**
     * Assert that the actual value is false
     */
    @Test
    void isPositiveWhenNegativeThenFalse() {
        boolean actual = simple.isPositive(-2);
        assertThat(actual).isFalse();
    }

    /**
     * Assert that the actual reference is null
     */
    @Test
    void nullIfWhenPositiveThenNull() {
        String actual = simple.nullIfPositive(12);
        assertThat(actual).isNull();
    }

    /**
     * Assert that the actual reference is null (more verbose)
     */
    @Test
    void nullIfWhenPositiveThenNullVerbose() {
        int input = 42;
        String actual = simple.nullIfPositive(input);
        assertThat(actual).isEqualTo(null);
    }

    /**
     * Assert that the actual reference is null
     */
    @Test
    void nullIfPositiveWhenNegativeThenNotNull() {
        String actual = simple.nullIfPositive(-12);
        assertThat(actual).isNotNull();
    }

    /**
     * Assert that the actual int value is equal to the expected int value
     */
    @Test
    void negateWhenPositiveThenEqualToNegate() {
        int input = 12;
        int actual = simple.negate(input);
        int expected = -input;
        assertThat(actual).isEqualTo(expected);
    }

    /**
     * Assert that the actual double value is close to the expected double value
     * with a stated precision.
     * <p>
     * With a lower precision the assertion should fail
     */
    @Test
    void multiplyWhenCloseWithPrecisionThenPass() {
        double actual = simple.multiply(0.29, 3.0);
        double expected = .87;
        assertThat(actual).isCloseTo(expected, withPrecision(.000_000_000_000_000_2));
    }

    /**
     * Assert that actual starts with prefix
     */
    @Test
    void whenStartsWithThenPass() {
        String prefix = "Tom";
        String actual = "Tom Jones";
        assertThat(actual).startsWith(prefix);
    }

    /**
     * Assert that actual does not start with prefix
     */
    @Test
    void whenDoesNotStartWithThenPass() {
        String prefix = "Ton";
        String actual = "Tom Jones";
        assertThat(actual).doesNotStartWith(prefix);
    }
}
