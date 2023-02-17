/*
 * Introduction to Java Logging and Testing
 * 
 * https://github.com/egalli64/jalt
 */
package com.example.jalt.m1.s3;

import java.io.IOException;
import java.io.InputStream;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

import com.example.jalt.m1.s2.Hello;

/**
 * Logging with JUL, configured locally
 */
public class Main {
    /** The JUL logger, see static initializer for its setup */
    private static final Logger log;

    static {
        // Access the configuration as an input stream
        InputStream stream = Main.class.getClassLoader().getResourceAsStream("m1/s3/logging.properties");
        if (stream == null) {
            throw new IllegalStateException("Can't get logging properties");
        }

        try {
            // Ensure used language is _not_ chosen by the OS
            Locale.setDefault(Locale.ENGLISH);
            LogManager.getLogManager().readConfiguration(stream);
            log = Logger.getLogger(Main.class.getName());
        } catch (SecurityException | IOException e) {
            throw new IllegalStateException("Can't configure logger", e);
        }
    }

    /**
     * See some log in action
     * 
     * @param args not used
     */
    public static void main(String[] args) {
        System.out.println("This is a message to the user: hello!");
        log.finest("finest logging message");
        log.finer("finer logging message");
        log.fine("fine logging message");
        log.config("config logging message");
        log.info("info logging message");
        log.warning("warning logging message");
        log.severe("severe logging message");

        // Each package could have a different logging configuration
        Hello.greet("Tom");

        // Each class could have a different logging configuration
        Other other = new Other();
        other.f();

        System.out.println("Some risky code");
        try {
            int x = 7 / 0;
            System.out.println("x = " + x);
        } catch (Exception ex) {
            log.log(Level.SEVERE, "Cannot divide an integer by zero", ex);
            System.out.println("Sorry, something went wrong ...");
        }
    }
}
