package com.example.jalt.m3.s02;

public class Worker {
    private Operator operator;

    public Worker() {
        this(new Adder());
    }

    public Worker(Operator operator) {
        this.operator = operator;
    }

    /**
     * The doubled result of applying the operator on the parameters
     * 
     * @param left  the first operand
     * @param right the second operand
     * @return two times left operator right
     * @throws ArithmeticException if the result overflows an int
     */
    public int generate(int left, int right) {
        return Math.multiplyExact(2, operator.operation(left, right));
    }
}
