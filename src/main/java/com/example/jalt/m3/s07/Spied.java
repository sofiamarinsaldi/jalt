/*
 * Introduction to Java Logging and Testing
 * 
 * https://github.com/egalli64/jalt
 */
package com.example.jalt.m3.s07;

/**
 * An interface spied by Mockito
 */
public interface Spied {
    /**
     * A classic abstract method
     * 
     * @param x an integer
     * @return an integer
     */
    int aClassicMethod(int x);

    /**
     * A defaulted method
     * 
     * @param x an integer
     * @return the doubled input
     */
    default int aDefaultedMethod(int x) {
        return x * 2;
    }
}
