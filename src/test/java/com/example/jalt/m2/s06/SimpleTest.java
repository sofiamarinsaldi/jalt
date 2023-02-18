/*
 * Introduction to Java Logging and Testing
 * 
 * https://github.com/egalli64/jalt
 */
package com.example.jalt.m2.s06;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
     * 
     * Use assertTrue() negating the condition
     */
    @Test
    void checkFalse() {
        boolean condition = simple.isPositive(-42);
        assertTrue(!condition);
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
     * 
     * Use assertTrue() on the reference comparison against null
     */
    @Test
    void checkNotNull() {
        String reference = simple.nullIfPositive(-22);
        assertTrue(reference != null);
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
     * 
     * Use assertTrue() on the comparison between the two values
     */
    @Test
    void checkDifferent() {
        int input = 42;
        int actual = simple.negate(input);

        assertTrue(actual != input);
    }

    /**
     * Assert that two floating point primitive values (doubles) are close enough to be considered equal
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
}
