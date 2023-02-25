/*
 * Introduction to Java Logging and Testing
 * 
 * https://github.com/egalli64/jalt
 */
package com.example.jalt.m3.s04;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Stubbing a mock by thenAnswer()
 */
class DividerMockWithAnswerTest {
    /** Mocking a class */
    Divider mockDiv;

    @BeforeEach
    void init() {
        mockDiv = mock();
        when(mockDiv.operation(anyInt(), anyInt())).thenAnswer(invocation -> {
            int left = invocation.getArgument(0);
            int right = invocation.getArgument(1);
            return switch (right) {
            case 0 -> throw new ArithmeticException();
            default -> left / right;
            };
        });
    }

    @Test
    void operationPlain() {
        final int mockLeft = 42;
        final int mockRight = 6;
        final int mockResult = 7;

        int actual = mockDiv.operation(mockLeft, mockRight);
        int expected = mockResult;
        assertThat(actual).isEqualTo(expected);

        verify(mockDiv).operation(mockLeft, mockRight);
        verify(mockDiv, never()).operation(0, 0);
    }

    @Test
    void operationException() {
        final int mockLeft = 42;
        final int mockRight = 0;

        assertThatExceptionOfType(ArithmeticException.class) //
                .isThrownBy(() -> mockDiv.operation(mockLeft, mockRight));

        verify(mockDiv).operation(mockLeft, mockRight);
    }
}
