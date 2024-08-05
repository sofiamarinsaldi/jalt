/*
 * Introduction to Java Logging and Testing
 * 
 * https://github.com/egalli64/jalt
 */
package com.example.jalt.m3.s4;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

import com.example.jalt.m3.s2.Simple;

/**
 * Testing an exception-throwing method in the modern way - Jupiter + AssertJ
 */
class SimpleTest {
    Simple simple = new Simple();

    /**
     * Can't negate minimum integer value
     * 
     * AssertJ assertThatThrownBy() + isInstanceOf() + hasMessage()
     */
    @Test
    void negateWhenMinValueThenThrownBy() {
        assertThatThrownBy(() -> simple.negate(Integer.MIN_VALUE)) //
                .isInstanceOf(IllegalArgumentException.class) //
                .hasMessage("Can't negate MIN_VALUE");
    }

    /**
     * Can't negate minimum integer value
     * 
     * AssertJ assertThatExceptionOfType() + isThrownBy() + withMessage()
     */
    @Test
    void negateWhenMinValueThenException() {
        assertThatExceptionOfType(IllegalArgumentException.class) //
                .isThrownBy(() -> simple.negate(Integer.MIN_VALUE)) //
                .withMessage("Can't negate MIN_VALUE");
    }

    /**
     * Can't negate minimum integer value
     * 
     * AssertJ assertThatIllegalArgumentException() variation for
     * assertThatExceptionOfType
     */
    @Test
    void negateWhenMinValueThenIllegalArgumentException() {
        assertThatIllegalArgumentException() //
                .isThrownBy(() -> simple.negate(Integer.MIN_VALUE)) //
                .withMessage("Can't negate MIN_VALUE");
    }
}
