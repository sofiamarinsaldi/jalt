/*
 * Introduction to Java Logging and Testing
 * 
 * https://github.com/egalli64/jalt
 */
package com.example.jalt.m2.s07;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.jalt.m2.s05.Simple;

/**
 * A test case with a couple of tests in it
 * 
 * @see Simple, the class to be tested
 */
class SimpleTest {
    /**
     * Each test in this case work on an object created in the same way. There is no
     * need of a specific definition for each one, just put it at class level.
     */
    private Simple simple = new Simple();

    @BeforeAll
    static void initAll() {
        System.out.println("Initializing for the test case");
    }

    @BeforeEach
    void initEach() {
        System.out.println("Initializing for a test");
    }

    @AfterEach
    void postEach() {
        System.out.println("Finalizing a test");
    }

    @AfterAll
    static void postAll() {
        System.out.println("Finalizing the test case execution");
    }

    @Test
    public void negateWhenPositiveThenNegative() {
        int input = 42;

        int expected = -input;
        int actual = simple.negate(input);

        assertEquals(expected, actual);
    }

    @Test
    public void negateWhenNegativeThenPositive() {
        int input = -42;

        int expected = -input;
        int actual = simple.negate(input);

        assertEquals(expected, actual);
    }
}
