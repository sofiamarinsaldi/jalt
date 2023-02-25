/*
 * Introduction to Java Logging and Testing
 * 
 * https://github.com/egalli64/jalt
 */
package com.example.jalt.m3.s08;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

import com.example.jalt.m3.s06.MyAppender;
import com.example.jalt.m3.s06.MyFormatter;
import com.example.jalt.m3.s06.MyLogger;
import com.example.jalt.m3.s06.MySeverity;

/**
 * Using ArgumentCaptor for deeper testing
 */
class MyLoggerCaptorMockTest {
    private MyFormatter mockFormatter = mock();
    private MyAppender stubAppender = mock();
    private MySeverity dummySeverity = mock();

    @Test
    void logCapture() {
        final String input = "hello";
        final String expected = "The formatted message";

        MyLogger logger = new MyLogger(mockFormatter, stubAppender);
        when(mockFormatter.format(dummySeverity, input)).thenReturn(expected);

        // nothing to test in the "normal" way
        logger.log(dummySeverity, input);

        // We are going to capture a string
        ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);

        // If MyAppender::append() is called once, capture its parameter value
        verify(stubAppender).append(captor.capture());

        // The argument passed to MyAppender::append() should be the expected value
        assertThat(captor.getValue()).isEqualTo(expected);
    }
}
