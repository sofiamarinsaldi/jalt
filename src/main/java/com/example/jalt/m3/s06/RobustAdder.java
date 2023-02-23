/*
 * Introduction to Java Logging and Testing
 * 
 * https://github.com/egalli64/jalt
 */
package com.example.jalt.m3.s06;

import com.example.jalt.m3.s02.Operator;

/**
 * An operation that returns the sum of the operands.
 * 
 * An improved adder that checks for overflow
 */
public class RobustAdder implements Operator {
    /**
     * @throws ArithmeticException if the result overflows
     */
    @Override
    public int operation(int left, int right) {
        return Math.addExact(left, right);
    }
}
