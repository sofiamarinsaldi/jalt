/*
 * Introduction to Java Logging and Testing
 * 
 * https://github.com/egalli64/jalt
 */
package com.example.jalt.m2.s09;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.withPrecision;

import org.junit.jupiter.api.Test;

import com.example.jalt.m2.s06.Simple;

/**
 * AssertJ assertions
 */
class SimpleAJTest {
    /** The instance to be tested is initialized in the same way for each test */
    private Simple simple = new Simple();

    /**
     * Assert that the actual value is true
     */
    @Test
    void isPositiveTrue() {
        boolean actual = simple.isPositive(42);
        assertThat(actual).isTrue();
    }

    /**
     * Assert that the actual value is true (more verbose)
     */
    @Test
    void isPositiveEqualTrue() {
        boolean actual = simple.isPositive(42);
        assertThat(actual).isEqualTo(true);
    }

    /**
     * Assert that the actual value is false
     */
    @Test
    void isPositiveFalse() {
        boolean actual = simple.isPositive(-2);
        assertThat(actual).isFalse();
    }

    /**
     * Assert that the actual reference is null
     */
    @Test
    void nullIfPositive() {
        String actual = simple.nullIfPositive(12);
        assertThat(actual).isNull();
    }

    /**
     * Assert that the actual reference is null (more verbose)
     */
    @Test
    void nullIfPositiveEqual() {
        String actual = simple.nullIfPositive(42);
        assertThat(actual).isEqualTo(null);
    }

    /**
     * Assert that the actual reference is null
     */
    @Test
    void nullIfPositiveNot() {
        String actual = simple.nullIfPositive(-12);
        assertThat(actual).isNotNull();
    }

    /**
     * Assert that the actual int value is equal to the expected int value
     */
    @Test
    void negatePositive() {
        int actual = simple.negate(12);
        int expected = -12;
        assertThat(actual).isEqualTo(expected);
    }

    /**
     * Assert that the actual double value is close to the expected double value with a stated
     * precision.
     * <p>
     * With a lower precision the assertion should fail
     */
    @Test
    void multiplyClose() {
        double actual = simple.multiply(0.29, 3.0);
        double expected = .87;
        assertThat(actual).isCloseTo(expected, withPrecision(.000_000_000_000_000_2));
    }

    /**
     * Assert that actual starts with prefix
     */
    @Test
    void startsWith() {
        String prefix = "Tom";
        String actual = "Tom Jones";
        assertThat(actual).startsWith(prefix);
    }

    /**
     * Assert that actual does not start with prefix
     */
    @Test
    void doesNotStartWith() {
        String prefix = "Ton";
        String actual = "Tom Jones";
        assertThat(actual).doesNotStartWith(prefix);
    }
}
