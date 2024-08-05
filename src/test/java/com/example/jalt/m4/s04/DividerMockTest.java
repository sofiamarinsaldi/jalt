/*
 * Introduction to Java Logging and Testing
 * 
 * https://github.com/egalli64/jalt
 */
package com.example.jalt.m4.s04;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;

/**
 * Stubbing a mock
 */
class DividerMockTest {
    /** Mocking a class */
    Divider mock = mock();

    @Test
    void operationPlain() {
        final int left = 42;
        final int right = 6;
        final int result = 7;

        // stubbing the mock for 42 / 6 = 7
        when(mock.operation(left, right)).thenReturn(result);

        // usual test
        int actual = mock.operation(left, right);
        int expected = result;
        assertThat(actual).isEqualTo(expected);

        // verify the mock has been used once with left and right in the test
        verify(mock).operation(left, right);
        // never() is a synonym for times(0)
        verify(mock, times(0)).operation(0, 0);
    }

    @Test
    void operationException() {
        final int left = 42;
        final int right = 0;

        // stubbing the mock for Arithmetic Exception
        when(mock.operation(left, right)).thenThrow(ArithmeticException.class);

        // usual test
        assertThatExceptionOfType(ArithmeticException.class) //
                .isThrownBy(() -> mock.operation(left, right));

        // verify the mock has been used once with left and right in the test
        verify(mock).operation(left, right);
    }

    @Test
    void operationExceptionMessage() {
        final int left = 42;
        final int right = 0;

        // stubbing the mock for Arithmetic Exception with a message
        when(mock.operation(left, right)).thenThrow(new ArithmeticException("/ by zero"));

        // usual test
        assertThatExceptionOfType(ArithmeticException.class) //
                .isThrownBy(() -> mock.operation(left, right)) //
                .withMessage("/ by zero");

        // verify the mock has been used once with left and right in the test
        verify(mock).operation(left, right);
    }
}
