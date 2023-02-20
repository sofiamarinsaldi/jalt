/*
 * Introduction to Java Logging and Testing
 * 
 * https://github.com/egalli64/jalt
 */
package com.example.jalt.m3.s02;

/**
 * The operation used by the worker
 * 
 * @see Worker, the class that has-an operator as component
 */
@FunctionalInterface
public interface Operator {
    /**
     * The operation applied for this function
     * 
     * @param left  first operand
     * @param right second operand
     * @return the result
     */
    int operation(int left, int right);
}
