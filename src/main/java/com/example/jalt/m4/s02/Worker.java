/*
 * Introduction to Java Logging and Testing
 * 
 * https://github.com/egalli64/jalt
 */
package com.example.jalt.m4.s02;

/**
 * A class that has a dependency, the Operator.
 * 
 * It is _not_ responsibility of this class ensuring that Operator works correctly
 */
public class Worker {
    /** The operator used by this worker */
    private final Operator operator;

    /**
     * No-arg constructor
     * 
     * By default, a worker uses Adder as Operator
     */
    public Worker() {
        this(new Adder());
    }

    /**
     * Constructor for Dependency Injection
     * 
     * @param operator the Operator to be used
     */
    public Worker(Operator operator) {
        this.operator = operator;
    }

    /**
     * The doubled result of applying the operator on the parameters
     * 
     * @param left  the first operand
     * @param right the second operand
     * @return two times left operator right
     * @throws ArithmeticException if the result overflows
     */
    public int generate(int left, int right) {
        return Math.multiplyExact(2, operator.operation(left, right));
    }
}
