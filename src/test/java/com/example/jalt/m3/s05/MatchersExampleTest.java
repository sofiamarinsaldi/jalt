/*
 * Introduction to Java Logging and Testing
 * 
 * https://github.com/egalli64/jalt
 */
package com.example.jalt.m3.s05;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;

/**
 * Usage of Mockito ArgumentMatchers
 */
class MatchersExampleTest {
    private static final int GOOD_INT = 12;
    private static final int BAD_INT = 21;
    private static final String GOOD_STRING = "OK";
    private static final String BAD_STRING = "KO";

    private static final int MOCK_RESULT = 42;
    private static final Throwable MOCK_EXCEPTION = new IllegalArgumentException();

    private MatchersExample me = mock();

    /**
     * Any "good" int passed to methodA() should return a good result
     */
    @Test
    void methodAAnyIntGood() {
        // stubbing for any (good) argument
        when(me.methodA(anyInt())).thenReturn(MOCK_RESULT);

        // testing for a good argument
        assertThat(me.methodA(GOOD_INT)).isEqualTo(MOCK_RESULT);
    }

    /**
     * Any "bad" int passed to methodA() should cause a MOCK_EXCEPTION
     */
    @Test
    void methodAAnyIntBad() {
        // stubbing for any (bad) argument
        when(me.methodA(anyInt())).thenThrow(MOCK_EXCEPTION);

        // testing for a bad argument
        assertThatIllegalArgumentException().isThrownBy(() -> me.methodA(BAD_INT));
    }

    /**
     * Any good reference passed to methodB() should return a good result
     */
    @Test
    void methodBAnyGood() {
        // stubbing for any (good) argument
        when(me.methodB(any())).thenReturn(MOCK_RESULT);

        // testing for a good argument
        assertThat(me.methodB(GOOD_STRING)).isEqualTo(MOCK_RESULT);
    }

    /**
     * Any bad reference passed to methodB() should cause a BAD_INPUT_EXCEPTION
     */
    @Test
    void methodBAnyBad() {
        // stubbing for any (bad) argument
        when(me.methodB(any())).thenThrow(MOCK_EXCEPTION);

        // testing for a bad argument
        assertThatIllegalArgumentException().isThrownBy(() -> me.methodB(BAD_STRING));
    }

    /**
     * A null reference passed as argument should be rejected
     */
    @Test
    void methodBNullBad() {
        // stubbing for null as bad argument
        when(me.methodB(isNull())).thenThrow(MOCK_EXCEPTION);

        // testing
        assertThatIllegalArgumentException().isThrownBy(() -> me.methodB(null));
    }

    /**
     * Any non-null reference passed to methodB() should return a good result
     */
    @Test
    void methodBNonNullGood() {
        // stubbing for generic non-null reference as good argument
        when(me.methodB(notNull())).thenReturn(MOCK_RESULT);

        // testing
        assertThat(me.methodB(GOOD_STRING)).isEqualTo(MOCK_RESULT);
        assertThat(me.methodB(null)).isNotEqualTo(MOCK_RESULT);
    }

    /**
     * Only if "Bob" is contained in the argument methodB() should return a good result
     */
    @Test
    void methodBBobGood() {
        String contained = "Bob";

        // stubbing for string containing Bob as good argument
        when(me.methodB(contains(contained))).thenReturn(MOCK_RESULT);

        // testing
        assertThat(me.methodB(contained)).isEqualTo(MOCK_RESULT);
        assertThat(me.methodB("xBob")).isEqualTo(MOCK_RESULT);
        assertThat(me.methodB("Bobby")).isEqualTo(MOCK_RESULT);
        assertThat(me.methodB("Tom")).isNotEqualTo(MOCK_RESULT);
    }

    /**
     * Only if the argument starts with "Bob" methodB() should return a good result
     */
    @Test
    void methodBBobStartGood() {
        String start = "Bob";

        // stubbing for string starting with Bob as good argument
        when(me.methodB(startsWith(start))).thenReturn(MOCK_RESULT);

        // testing
        assertThat(me.methodB(start)).isEqualTo(MOCK_RESULT);
        assertThat(me.methodB("Bobby")).isEqualTo(MOCK_RESULT);
        assertThat(me.methodB("Tom")).isNotEqualTo(MOCK_RESULT);
        assertThat(me.methodB("xBob")).isNotEqualTo(MOCK_RESULT);
    }
}
