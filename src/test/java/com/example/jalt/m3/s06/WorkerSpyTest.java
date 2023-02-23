/*
 * Introduction to Java Logging and Testing
 * 
 * https://github.com/egalli64/jalt
 */
package com.example.jalt.m3.s06;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;

import com.example.jalt.m3.s02.Operator;

/**
 * Mockito tests on Worker::generate???()
 * 
 * Using mock and spy
 */
class WorkerSpyTest {
    private Operator mockMult = mock();
    private RobustAdder spyAdd = spy();
    private Worker worker = new Worker(spyAdd, mockMult);

    @Test
    void generateOneTwo() {
        int left = 2;
        int right = 3;
        int partial = 5;
        int expected = 10;

        when(mockMult.operation(left, partial)).thenReturn(expected);

        int actual = worker.generateOneTwo(left, right);
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void generateOneTwoOverflow() {
        int left = 2_000_000_000;
        int right = 2_000_000_000;

        assertThatExceptionOfType(ArithmeticException.class) //
                .isThrownBy(() -> worker.generateOneTwo(left, right)) //
                .withMessage("integer overflow");

        verify(spyAdd).operation(left, right);
        verify(mockMult, never()).operation(anyInt(), anyInt());
    }

    @Test
    void generateTwoOne() {
        int left = 2;
        int right = 3;
        int partial = 6;
        int expected = 8;

        when(mockMult.operation(left, right)).thenReturn(partial);

        int actual = worker.generateTwoOne(left, right);
        assertThat(actual).isEqualTo(expected);

        verify(spyAdd).operation(left, partial);
        verify(mockMult).operation(left, right);
    }
}
