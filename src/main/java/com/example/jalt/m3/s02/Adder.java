package com.example.jalt.m3.s02;

public class Adder implements Operator {
    @Override
    public int operation(int left, int right) {
        return left + right;
    }
}
