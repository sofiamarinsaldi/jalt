/*
 * Introduction to Java Logging and Testing
 * 
 * https://github.com/egalli64/jalt
 */
package com.example.jalt.m2.s13;

/**
 * Simple code to experiment with coverage
 */
public class CoverMe {
    /**
     * A method with a three-way branching in its code
     * 
     * @param left  a parameter
     * @param right another parameter
     * @return the return value
     */
    public int delta(int left, int right) {
        if (left > right) {
            return left - right;
        } else if (left < right) {
            return right - left;
        } else {
            return 0;
        }
    }

    /**
     * A method with a slightly more complex condtion
     * 
     * @param left  a parameter
     * @param right another parameter
     * @return the return value
     */
    public boolean arePositive(int left, int right) {
        if (left > 0 && right > 0) {
            return true;
        } else {
            return false;
        }
    }
}
