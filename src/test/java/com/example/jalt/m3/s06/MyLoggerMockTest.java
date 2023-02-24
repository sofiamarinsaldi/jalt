/*
 * Introduction to Java Logging and Testing
 * 
 * https://github.com/egalli64/jalt
 */
package com.example.jalt.m3.s06;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;

/**
 * Differences among mock, stub and dummy
 */
class MyLoggerMockTest {
    /** mock - it has a stubbed method */
    private MyFormatter mockFormatter = mock();
    /** stub - it can't be replaced by a null, we need to invoke a method on it */
    private MyAppender stubAppender = mock();
    /** dummy - it could be a null, at least in the first development steps */
    private MySeverity dummySeverity = mock();

    @Test
    void testLog() {
        final String input = "hello";
        final String expected = "The formatted message";

        // create a real logger, injecting a mock and a stub in it
        MyLogger logger = new MyLogger(mockFormatter, stubAppender);
        when(mockFormatter.format(dummySeverity, input)).thenReturn(expected);

        // nothing to test in the "normal" way
        logger.log(dummySeverity, input);

        // the formatter is called once with the expected arguments
        verify(mockFormatter).format(dummySeverity, input);
        // if the stub works as expected, the appender is called with the right argument
        verify(stubAppender).append(expected);
    }
}
