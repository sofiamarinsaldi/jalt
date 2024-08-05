/*
 * Introduction to Java Logging and Testing
 * 
 * https://github.com/egalli64/jalt
 */
package com.example.jalt.m4.s07;

import com.example.jalt.m4.s02.Operator;
import com.example.jalt.m4.s04.Divider;

/**
 * A class with two Operator dependencies
 * 
 * Show difference between mock and spy in testing
 */
public class Worker {
    /** The first operator used by this worker */
    private final Operator op1;
    /** The second operator used by this worker */
    private final Operator op2;

    /**
     * No-arg constructor
     * 
     * By default, a worker uses Adder as Operator
     */
    public Worker() {
        this(new RobustAdder(), new Divider());
    }

    /**
     * Constructor for Dependency Injection
     * 
     * @param operator the Operator to be used
     */
    public Worker(Operator op1, Operator op2) {
        this.op1 = op1;
        this.op2 = op2;
    }

    /**
     * Apply op1 on left right, then op2 on left and the previous result
     * 
     * No overflow checking!
     * 
     * @param left  the first operand
     * @param right the second operand
     * @return left op2 ( left op1 right)
     */
    public int generateOneTwo(int left, int right) {
        return op2.operation(left, op1.operation(left, right));
    }

    /**
     * Apply op2 on left right, then op1 on left and the previous result
     * 
     * No overflow checking!
     * 
     * @param left  the first operand
     * @param right the second operand
     * @return left op1 ( left op2 right)
     */
    public int generateTwoOne(int left, int right) {
        return op1.operation(left, op2.operation(left, right));
    }
}
