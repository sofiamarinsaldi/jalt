/*
 * Introduction to Java Logging and Testing
 * 
 * https://github.com/egalli64/jalt
 */
package com.example.jalt.m2.s12;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

import com.example.jalt.m2.s10.Simple;

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
    void negateMinIntThrownBy() {
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
    void negateMinIntException() {
        assertThatExceptionOfType(IllegalArgumentException.class) //
                .isThrownBy(() -> simple.negate(Integer.MIN_VALUE)) //
                .withMessage("Can't negate MIN_VALUE");
    }

    /**
     * Can't negate minimum integer value
     * 
     * AssertJ assertThatIllegalArgumentException() variation for assertThatExceptionOfType
     */
    @Test
    void negateMinIntIllegalArgumentException() {
        assertThatIllegalArgumentException() //
                .isThrownBy(() -> simple.negate(Integer.MIN_VALUE)) //
                .withMessage("Can't negate MIN_VALUE");
    }
}
