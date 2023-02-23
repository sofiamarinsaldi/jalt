/*
 * Introduction to Java Logging and Testing
 * 
 * https://github.com/egalli64/jalt
 */
package com.example.jalt.m3.s04;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;

import com.example.jalt.m3.s03.AnInterface;

/**
 * Create a Mockito mock from an interface and play with stubbing on it with
 * <li>when(o.f()).thenReturn(x)
 * <li>doReturn(x).when(o).f()
 * <li>when(o.f()).thenThrow(exception)
 * <li>doThrow(exception).when(o).f()
 */
class AnInterfaceStubbedMockTest {
    private AnInterface mockOp = mock();

    /**
     * Stubbing a primitive to primitive method
     */
    @Test
    void calculate() {
        when(mockOp.calculate(1)).thenReturn(10);
        doReturn(20).when(mockOp).calculate(2);

        when(mockOp.calculate(3)).thenThrow(new IllegalArgumentException("Bad value: 3"));
        doThrow(new IllegalArgumentException("Bad value: 4")).when(mockOp).calculate(4);

        assertThat(mockOp.calculate(1)).isEqualTo(10);
        assertThat(mockOp.calculate(2)).isEqualTo(20);
        assertThatIllegalArgumentException().isThrownBy(() -> mockOp.calculate(3)).withMessage("Bad value: 3");
        assertThatIllegalArgumentException().isThrownBy(() -> mockOp.calculate(4)).withMessage("Bad value: 4");
    }

    /**
     * Stubbing a reference to reference method
     */
    @Test
    void getMessage() {
        when(mockOp.getMessage("Bob")).thenReturn("Hello");
        doReturn("Ciao").when(mockOp).getMessage("Tom");

        when(mockOp.getMessage("Kim")).thenThrow(new IllegalArgumentException("KO 1"));
        doThrow(new IllegalArgumentException("KO 2")).when(mockOp).getMessage("Jim");

        assertThat(mockOp.getMessage("Bob")).isEqualTo("Hello");
        assertThat(mockOp.getMessage("Tom")).isEqualTo("Ciao");
        assertThatIllegalArgumentException().isThrownBy(() -> mockOp.getMessage("Kim")).withMessage("KO 1");
        assertThatIllegalArgumentException().isThrownBy(() -> mockOp.getMessage("Jim")).withMessage("KO 2");
    }

    /**
     * Stubbing a void method to throw
     */
    @Test
    void operateExceptional() {
        // won't compile
//        when(mockOp.operate()).thenThrow(new IllegalArgumentException("KO"));
        doThrow(new IllegalArgumentException("KO")).when(mockOp).operate();

        assertThatIllegalArgumentException().isThrownBy(() -> mockOp.operate()).withMessage("KO");
    }
}
