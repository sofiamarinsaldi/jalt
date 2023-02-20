/*
 * Introduction to Java Logging and Testing
 * 
 * https://github.com/egalli64/jalt
 */
package com.example.jalt.m3.s02;

/**
 * An operation that returns the sum of the operands.
 * 
 * Notice that this is a weak implementation, overflow is not checked
 */
public class Adder implements Operator {
    @Override
    public int operation(int left, int right) {
        return left + right;
    }
}
