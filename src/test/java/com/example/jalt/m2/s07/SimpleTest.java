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
    /** Both tests in the case work on an object created in the same way, no need of duplication */
    Simple simple = new Simple();

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

    /**
     * Test for positive input
     */
    @Test
    public void negatePositive() {
        int input = 42;

        int expected = -42;
        int actual = simple.negate(input);

        assertEquals(expected, actual);
    }

    /**
     * Test for negative input
     */
    @Test
    public void negateNegative() {
        int input = -42;

        int expected = 42;
        int actual = simple.negate(input);

        assertEquals(expected, actual);
    }

}
