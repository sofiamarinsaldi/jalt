/*
 * Introduction to Java Logging and Testing
 * 
 * https://github.com/egalli64/jalt
 */
package com.example.jalt.m3.s04;

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
    Divider mockDiv = mock();

    @Test
    void operationPlain() {
        final int mockLeft = 42;
        final int mockRight = 6;
        final int mockResult = 7;

        // stubbing the mock for 42 / 6 = 7
        when(mockDiv.operation(mockLeft, mockRight)).thenReturn(mockResult);

        // usual test
        int actual = mockDiv.operation(mockLeft, mockRight);
        int expected = mockResult;
        assertThat(actual).isEqualTo(expected);

        // verify the mock has been used in the expected way
        verify(mockDiv).operation(mockLeft, mockRight);
        // never() is a synonym for times(0)
        verify(mockDiv, times(0)).operation(0, 0);
    }

    @Test
    void operationException() {
        final int mockLeft = 42;
        final int mockRight = 0;

        // stubbing the mock for Arithmetic Exception
        when(mockDiv.operation(mockLeft, mockRight)).thenThrow(ArithmeticException.class);

        // usual test
        assertThatExceptionOfType(ArithmeticException.class) //
                .isThrownBy(() -> mockDiv.operation(mockLeft, mockRight));

        // verify the mock has been used in the expected way
        verify(mockDiv).operation(mockLeft, mockRight);
    }

    @Test
    void operationExceptionMessage() {
        final int mockLeft = 42;
        final int mockRight = 0;

        // stubbing the mock for Arithmetic Exception with a message
        when(mockDiv.operation(mockLeft, mockRight)) //
                .thenThrow(new ArithmeticException("/ by zero"));

        // usual test
        assertThatExceptionOfType(ArithmeticException.class) //
                .isThrownBy(() -> mockDiv.operation(mockLeft, mockRight)) //
                .withMessage("/ by zero");

        // verify the mock has been used in the expected way
        verify(mockDiv).operation(mockLeft, mockRight);
    }
}
