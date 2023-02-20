/*
 * Introduction to Java Logging and Testing
 * 
 * https://github.com/egalli64/jalt
 */
package com.example.jalt.m3.s02;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

/**
 * A usual unit test on Worker::generate()
 */
class WorkerTest {
    private Worker worker = new Worker();

    @ParameterizedTest
    @CsvSource(textBlock = """
                         9,   12,             42
                         0,    0,              0
                        -1,   -2,             -6
             1_073_741_000,  823,  2_147_483_646
            -1_073_741_000, -824, -2_147_483_648
            """)
    void generate(int left, int right, int expected) {
        int actual = worker.generate(left, right);
        assertThat(actual).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource({ "2_147_483_000, 647", "1_073_741_000, 824", "-2_147_483_000, -648", "-1_073_741_000, -825" })
    void generateOverflow(int left, int right) {
        assertThatExceptionOfType(ArithmeticException.class) //
                .isThrownBy(() -> worker.generate(left, right)) //
                .withMessage("integer overflow");
    }

    /**
     * Worker::generate() fails, but bug is in Adder::operation()
     * 
     * A ticket has to be raised to take care of this issue
     */
    @Test
    void generateInternalOverflow() {
        assertThatExceptionOfType(ArithmeticException.class) //
                .isThrownBy(() -> worker.generate(2_000_000_000, 2_000_000_000)) //
                .withMessage("integer overflow");
    }
}
