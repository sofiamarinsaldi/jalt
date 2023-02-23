/*
 * Introduction to Java Logging and Testing
 * 
 * https://github.com/egalli64/jalt
 */
package com.example.jalt.m3.s06;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

/**
 * Both tests are expected to fail, since Divider::operation() is not implemented yet!
 */
class WorkerTest {
    Worker worker = new Worker();

    @Test
    void testGenerateOneTwo() {
        int left = 2;
        int right = 3;
        int actual = worker.generateOneTwo(left, right);
        int expected = 10;
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void testGenerateTwoOne() {
        int left = 2;
        int right = 3;
        int actual = worker.generateTwoOne(left, right);
        int expected = 8;
        assertThat(actual).isEqualTo(expected);
    }
}
