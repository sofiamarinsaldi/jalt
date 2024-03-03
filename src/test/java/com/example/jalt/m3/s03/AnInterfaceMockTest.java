/*
 * Introduction to Java Logging and Testing
 * 
 * https://github.com/egalli64/jalt
 */
package com.example.jalt.m3.s03;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.Test;

/**
 * Create a Mockito mock from an interface and check how it is done
 * 
 * Since Java 21 the current Mockito approach leads to a warning:
 * 
 * <pre>
 * A Java agent has been loaded dynamically
 * </pre>
 */
class AnInterfaceMockTest {
    private AnInterface mock = mock();

    /**
     * The mock is of the "right" type
     * 
     * Its methods are created by Mockito to return the usual Java default values
     * <li>0, 0.0, false for primitive
     * <li>null for reference
     */
    @Test
    void constructor() {
        assertThat(mock).isInstanceOf(AnInterface.class);
        assertThat(mock.calculate(42)).isZero();
        assertThat(mock.getMessage("Bob")).isNull();
        mock.operate();
    }
}
