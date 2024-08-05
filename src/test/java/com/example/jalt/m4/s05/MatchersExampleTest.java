/*
 * Introduction to Java Logging and Testing
 * 
 * https://github.com/egalli64/jalt
 */
package com.example.jalt.m4.s05;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.contains;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.ArgumentMatchers.notNull;
import static org.mockito.ArgumentMatchers.startsWith;
import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

/**
 * Usage of Mockito ArgumentMatchers
 * 
 * @apiNote Static import of Mockito.when won't compile in Eclipse 2023-09 with
 *          patch for Java 21 - workaround waiting for 2023-12 is _not_ using
 *          static import for this method
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
        Mockito.when(me.methodA(anyInt())).thenReturn(MOCK_RESULT);

        // testing for a good argument
        assertThat(me.methodA(GOOD_INT)).isEqualTo(MOCK_RESULT);
    }

    /**
     * Any "bad" int passed to methodA() should cause a MOCK_EXCEPTION
     */
    @Test
    void methodAAnyIntBad() {
        // stubbing for any (bad) argument
        Mockito.when(me.methodA(anyInt())).thenThrow(MOCK_EXCEPTION);

        // testing for a bad argument
        assertThatIllegalArgumentException().isThrownBy(() -> me.methodA(BAD_INT));
    }

    /**
     * Any good reference passed to methodB() should return a good result
     */
    @Test
    void methodBAnyGood() {
        // stubbing for any (good) argument
        Mockito.when(me.methodB(any())).thenReturn(MOCK_RESULT);

        // testing for a good argument
        assertThat(me.methodB(GOOD_STRING)).isEqualTo(MOCK_RESULT);
    }

    /**
     * Any bad reference passed to methodB() should cause a BAD_INPUT_EXCEPTION
     */
    @Test
    void methodBAnyBad() {
        // stubbing for any (bad) argument
        Mockito.when(me.methodB(any())).thenThrow(MOCK_EXCEPTION);

        // testing for a bad argument
        assertThatIllegalArgumentException().isThrownBy(() -> me.methodB(BAD_STRING));
    }

    /**
     * A null reference passed as argument should be rejected
     */
    @Test
    void methodBNullBad() {
        // stubbing for null as bad argument
        Mockito.when(me.methodB(isNull())).thenThrow(MOCK_EXCEPTION);

        // testing
        assertThatIllegalArgumentException().isThrownBy(() -> me.methodB(null));
    }

    /**
     * Any non-null reference passed to methodB() should return a good result
     */
    @Test
    void methodBNonNullGood() {
        // stubbing for generic non-null reference as good argument
        Mockito.when(me.methodB(notNull())).thenReturn(MOCK_RESULT);

        // testing
        assertThat(me.methodB(GOOD_STRING)).isEqualTo(MOCK_RESULT);
        assertThat(me.methodB(null)).isNotEqualTo(MOCK_RESULT);
    }

    /**
     * Only if "Bob" is contained in the argument methodB() should return a good
     * result
     */
    @Test
    void methodBBobGood() {
        String contained = "Bob";

        // stubbing for string containing Bob as good argument
        Mockito.when(me.methodB(contains(contained))).thenReturn(MOCK_RESULT);

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
        Mockito.when(me.methodB(startsWith(start))).thenReturn(MOCK_RESULT);

        // testing
        assertThat(me.methodB(start)).isEqualTo(MOCK_RESULT);
        assertThat(me.methodB("Bobby")).isEqualTo(MOCK_RESULT);
        assertThat(me.methodB("Tom")).isNotEqualTo(MOCK_RESULT);
        assertThat(me.methodB("xBob")).isNotEqualTo(MOCK_RESULT);
    }
}
