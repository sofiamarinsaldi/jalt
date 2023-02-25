/*
 * Introduction to Java Logging and Testing
 * 
 * https://github.com/egalli64/jalt
 */
package com.example.jalt.m3.s07;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

/**
 * Spying an interface with Mockito
 */
class SpiedTest {
    private Spied mySpy = Mockito.spy();

    /**
     * An abstract "pure" method is mocked, providing the default return value
     */
    @Test
    void testAClassicMethod() {
        assertThat(mySpy.aClassicMethod(21)).isEqualTo(0);
    }

    /**
     * A defaulted method keeps its default behavior
     */
    @Test
    void testADefaultedMethod() {
        assertThat(mySpy.aDefaultedMethod(21)).isEqualTo(42);
    }
}
