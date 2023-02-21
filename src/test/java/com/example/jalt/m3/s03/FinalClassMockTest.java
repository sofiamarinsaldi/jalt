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
 * Create a Mockito mock for a final class
 */
class FinalClassMockTest {
    private FinalClass mockAn = mock();

    /**
     * The mock is of the "right" type
     * 
     * Its methods are created by Mockito to return the usual Java default values
     * <li>0, 0.0, false for primitive
     * <li>null for reference
     */
    @Test
    void constructor() {
        assertThat(mockAn).isInstanceOf(FinalClass.class);
        assertThat(mockAn.f()).isZero();
    }
}
