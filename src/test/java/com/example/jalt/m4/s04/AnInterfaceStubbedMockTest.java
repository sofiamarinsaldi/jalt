/*
 * Introduction to Java Logging and Testing
 * 
 * https://github.com/egalli64/jalt
 */
package com.example.jalt.m4.s04;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;

import com.example.jalt.m4.s03.AnInterface;

/**
 * Create a Mockito mock from an interface and play with stubbing on it with
 * <li>when(o.f()).thenReturn(x)
 * <li>doReturn(x).when(o).f()
 * <li>when(o.f()).thenThrow(exception)
 * <li>doThrow(exception).when(o).f()
 * 
 * @apiNote Java 21: "A Java agent has been loaded dynamically" warning
 */
class AnInterfaceStubbedMockTest {
    private final AnInterface mock = mock();

    /**
     * Stubbing a method accepting and returning a primitive
     */
    @Test
    void calculateMockResult() {
        // stubbing by when - then return
        when(mock.calculate(1)).thenReturn(10);
        // alternative stubbing by do return - when
        doReturn(20).when(mock).calculate(2);

        assertThat(mock.calculate(1)).isEqualTo(10);
        assertThat(mock.calculate(2)).isEqualTo(20);
    }

    /**
     * Stubbing a method accepting and returning a primitive for exception
     */
    @Test
    void calculateMockException() {
        // stubbing by when - then throw
        when(mock.calculate(3)).thenThrow(new IllegalArgumentException("Bad value: 3"));
        // alternative stubbing by do throw - when
        doThrow(new IllegalArgumentException("Bad value: 4")).when(mock).calculate(4);

        assertThatIllegalArgumentException().isThrownBy(() -> mock.calculate(3)).withMessage("Bad value: 3");
        assertThatIllegalArgumentException().isThrownBy(() -> mock.calculate(4)).withMessage("Bad value: 4");
    }

    /**
     * Stubbing a method accepting and returning a reference
     */
    @Test
    void getMessageMockResult() {
        when(mock.getMessage("Bob")).thenReturn("Hello");
        doReturn("Ciao").when(mock).getMessage("Tom");

        assertThat(mock.getMessage("Bob")).isEqualTo("Hello");
        assertThat(mock.getMessage("Tom")).isEqualTo("Ciao");
    }

    /**
     * Stubbing a method accepting and returning a reference for exception
     */
    @Test
    void getMessage() {
        when(mock.getMessage("Kim")).thenThrow(new IllegalArgumentException("KO 1"));
        doThrow(new IllegalArgumentException("KO 2")).when(mock).getMessage("Jim");

        assertThatIllegalArgumentException().isThrownBy(() -> mock.getMessage("Kim")).withMessage("KO 1");
        assertThatIllegalArgumentException().isThrownBy(() -> mock.getMessage("Jim")).withMessage("KO 2");
    }

    /**
     * Stubbing a void method to throw
     */
    @Test
    void operateExceptional() {
        // if the method returns void, the when - then throw approach won't compile
        // when(mock.operate()).thenThrow(new IllegalArgumentException("KO"));
        doThrow(new IllegalArgumentException("KO")).when(mock).operate();

        assertThatIllegalArgumentException().isThrownBy(() -> mock.operate()).withMessage("KO");
    }
}
