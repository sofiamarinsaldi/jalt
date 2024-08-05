/*
 * Introduction to Java Logging and Testing
 * 
 * https://github.com/egalli64/jalt
 */
package com.example.jalt.m4.s05;

/**
 * Just for creating a mock that uses matchers
 */
public interface MatchersExample {
    /**
     * Usually return a "good" value, sometimes throw an exception
     * 
     * @param x primitive
     * @return a result
     * @throws IllegalArgumentException when the passed parameter is not accepted
     */
    int methodA(int x);

    /**
     * Usually return a "good" value, sometimes throw an exception
     * 
     * @param x a String
     * @return a result
     * @throws IllegalArgumentException when the passed parameter is not accepted
     */
    int methodB(String x);
}
