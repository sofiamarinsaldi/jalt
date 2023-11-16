/*
 * Introduction to Java Logging and Testing
 * 
 * https://github.com/egalli64/jalt
 */
package com.example.jalt.m3.s05;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import org.mockito.Mockito;

import org.junit.jupiter.api.Test;

import com.example.jalt.m3.s03.AnInterface;

/**
 * Using Mockito matchers
 * 
 * @apiNote Static import of Mockito.when won't compile in Eclipse 2023-09 with
 *          patch for Java 21 - workaround waiting for 2023-12 is _not_ using
 *          static import for this method
 */
class AnInterfaceStubbedMockTest {
    private static final int GOOD_INT = 12;
    private static final int BAD_INT = 21;
    private static final String GOOD_STRING = "OK";
    private static final String BAD_STRING = "KO";
    private static final int MOCK_INT_RESULT = 42;
    private static final String MOCK_STRING_RESULT = "OK";
    private static final Throwable MOCK_EXCEPTION = new IllegalArgumentException();

    private AnInterface mockOp = mock();

    /**
     * Any "good" int - Mockito::anyInt() - passed to calculate() should return a
     * "good" value
     * 
     * It is not on the mock deciding which value is good
     * 
     * Stubbing by when .. thenReturn
     */
    @Test
    void calculateWhenThenReturn() {
        // stubbing
        Mockito.when(mockOp.calculate(anyInt())).thenReturn(MOCK_INT_RESULT);

        // usual testing, expecting GOOD_INT being an acceptable value
        int input = GOOD_INT;
        int actual = mockOp.calculate(input);
        int expected = MOCK_INT_RESULT;

        assertThat(actual).isEqualTo(expected);
    }

    /**
     * Any "good" int - Mockito::anyInt() - passed to calculate() should return a
     * "good" value
     * 
     * Stubbing by doReturn ... when
     */
    @Test
    void calculateDoReturnWhen() {
        // stubbing
        doReturn(MOCK_INT_RESULT).when(mockOp).calculate(anyInt());

        // usual test (compressed), expecting GOOD_INT being an acceptable value
        assertThat(mockOp.calculate(GOOD_INT)).isEqualTo(MOCK_INT_RESULT);
    }

    /**
     * Any "bad" int passed to calculate() should cause an IllegalArgumentException
     */
    @Test
    void calculateExceptional() {
        Mockito.when(mockOp.calculate(anyInt())).thenThrow(MOCK_EXCEPTION);
        assertThatIllegalArgumentException().isThrownBy(() -> mockOp.calculate(BAD_INT));
    }

    /**
     * Any "good" reference - Mockito::any() - passed to getMessage() should return
     * a "good" value
     */
    @Test
    void getMessage() {
        Mockito.when(mockOp.getMessage(any())).thenReturn(MOCK_STRING_RESULT);
        assertThat(mockOp.getMessage(GOOD_STRING)).isEqualTo(MOCK_STRING_RESULT);
    }

    /**
     * Any "bad" reference passed to getMessage() should cause an
     * IllegalArgumentException
     */
    @Test
    void getMessageExceptional() {
        Mockito.when(mockOp.getMessage(any())).thenThrow(MOCK_EXCEPTION);
        assertThatIllegalArgumentException().isThrownBy(() -> mockOp.getMessage(BAD_STRING));
    }
}
