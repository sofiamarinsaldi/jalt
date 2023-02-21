/*
 * Introduction to Java Logging and Testing
 * 
 * https://github.com/egalli64/jalt
 */
package com.example.jalt.m2.s06;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * Jupiter assertions
 */
class SimpleTest {
    /** The instance to be tested is initialized in the same way for each test */
    private Simple simple = new Simple();

    /**
     * Assert that a condition is true
     */
    @Test
    void checkTrue() {
        boolean condition = simple.isPositive(12);
        assertTrue(condition);
    }

    /**
     * Assert that a condition is false
     */
    @Test
    void checkFalse() {
        boolean condition = simple.isPositive(-42);
        assertFalse(condition);
    }

    /**
     * Assert that a reference is null
     */
    @Test
    void checkNull() {
        String reference = simple.nullIfPositive(42);
        assertNull(reference);
    }

    /**
     * Assert that a reference is not null
     */
    @Test
    void checkNotNull() {
        String reference = simple.nullIfPositive(-22);
        assertNotNull(reference);
    }

    /**
     * Assert that two primitive values (integers) are equal
     */
    @Test
    void checkEqual() {
        int input = 42;
        int actual = simple.negate(input);
        int expected = -42;

        assertEquals(expected, actual);
    }

    /**
     * Assert that two primitive values (integers) are different
     */
    @Test
    void checkDifferent() {
        int input = 42;
        int actual = simple.negate(input);

        assertNotEquals(input, actual);
    }

    /**
     * Assert that two doubles are close enough to be considered equal
     * <p>
     * With a lower delta the assertion should fail
     */
    @Test
    void checkEqualDouble() {
        double first = .29;
        double second = 3.0;
        double actual = simple.multiply(first, second);
        double expected = .87;
        assertEquals(expected, actual, .000_000_000_000_000_2);
    }

    /**
     * Assert that two doubles are distant enough to be considered different
     * <p>
     * With a higher delta the assertion should fail
     */
    @Test
    void checkDifferentDouble() {
        double first = .29;
        double second = 3.0;
        double actual = simple.multiply(first, second);
        double expected = .87;
        assertNotEquals(expected, actual, .000_000_000_000_000_1);
    }

}
