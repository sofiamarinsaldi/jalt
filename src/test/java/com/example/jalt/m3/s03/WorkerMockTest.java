/*
 * Introduction to Java Logging and Testing
 * 
 * https://github.com/egalli64/jalt
 */
package com.example.jalt.m3.s03;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.ArgumentMatchers.anyInt;

import com.example.jalt.m3.s02.Operator;
import com.example.jalt.m3.s02.Worker;

/**
 * Mockito tests on Worker::generate()
 */
class WorkerMockTest {
    private Operator mock = mock();
    static final int MOCK_INPUT = 42;

    @ParameterizedTest
    @CsvSource(textBlock = """
                        21,             42
                         0,              0
                        -3,             -6
             1_073_741_823,  2_147_483_646
            -1_073_741_824, -2_147_483_648
            """)
    void generate(int mockSum, int expected) {
        when(mock.operation(anyInt(), anyInt())).thenReturn(mockSum);

        Worker worker = new Worker(mock);
        int actual = worker.generate(MOCK_INPUT, MOCK_INPUT);
        
        verify(mock, times(1)).operation(anyInt(), anyInt());
        assertThat(actual).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource({ "2_147_483_647", "1_073_741_824", "-2_147_483_648", "-1_073_741_825" })
    void generateOverflow(int mockSum) {
        when(mock.operation(anyInt(), anyInt())).thenReturn(mockSum);

        Worker worker = new Worker(mock);
        assertThatExceptionOfType(ArithmeticException.class) //
                .isThrownBy(() -> worker.generate(MOCK_INPUT, MOCK_INPUT)) //
                .withMessage("integer overflow");
    }

    @Test
    void generateInternalOverflow() {
        when(mock.operation(anyInt(), anyInt())).thenThrow(new ArithmeticException("integer overflow"));

        Worker worker = new Worker(mock);
        assertThatExceptionOfType(ArithmeticException.class) //
                .isThrownBy(() -> worker.generate(2_000_000_000, 2_000_000_000)) //
                .withMessage("integer overflow");
    }

}
