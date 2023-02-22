/*
 * Introduction to Java Logging and Testing
 * 
 * https://github.com/egalli64/jalt
 */
package com.example.jalt.m3.s05;

/**
 * A class that is going to be mock tested with dummy, stub, and mock
 */
public class MyLogger {
    private MyFormatter formatter;
    private MyAppender appender;

    /**
     * Canonical constructor
     * 
     * @param formatter the formatter used by this logger
     * @param appender  the appender used by this logger
     */
    public MyLogger(MyFormatter formatter, MyAppender appender) {
        this.formatter = formatter;
        this.appender = appender;
    }

    /**
     * A message is formatted accordingly to its severity and then logged.
     * 
     * Severity from the caller is passed as-is to the formatter. A dummy is enough to test it.
     * 
     * The appender is used by the code, could be a stub (no method stubbing required).
     * 
     * The formatter has to generate a result, so a mock is required.
     * 
     * @param severity the message importance
     * @param message  the actual message
     */
    public void log(MySeverity severity, String message) {
        String line = formatter.format(severity, message);

        appender.append(line);
    }
}
