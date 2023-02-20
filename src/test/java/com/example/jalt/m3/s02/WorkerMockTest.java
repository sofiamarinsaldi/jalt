package com.example.jalt.m3.s02;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class WorkerMockTest {
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
        Worker worker = new Worker((a, b) -> mockSum);
        int actual = worker.generate(MOCK_INPUT, MOCK_INPUT);
        assertThat(actual).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource({ "2_147_483_647", "1_073_741_824", "-2_147_483_648", "-1_073_741_825" })
    void generateOverflow(int mockSum) {
        Worker worker = new Worker((a, b) -> mockSum);
        assertThatExceptionOfType(ArithmeticException.class) //
                .isThrownBy(() -> worker.generate(MOCK_INPUT, MOCK_INPUT)) //
                .withMessage("integer overflow");
    }
}
