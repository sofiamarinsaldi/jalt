/*
 * Introduction to Java Logging and Testing
 * 
 * https://github.com/egalli64/jalt
 */
package com.example.jalt.m3.s03;

/**
 * An interface just for mocking
 */
public interface AnInterface {
    /**
     * A primitive method
     * 
     * @param x a primitive
     * @return a primitive
     */
    int calculate(int x);

    /**
     * A reference method
     * 
     * @param s a reference
     * @return a reference
     */
    String getMessage(String s);

    /**
     * A procedure with no parameter
     */
    void operate();
}
