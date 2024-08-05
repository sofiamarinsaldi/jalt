/*
 * Introduction to Java Logging and Testing
 * 
 * https://github.com/egalli64/jalt
 */
package com.example.jalt.m5.s1;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

/**
 * Unit Test to be used for practicing with code coverage
 */
class CoverMeTest {
    private CoverMe cm = new CoverMe();

    @Test
    void deltaLeftBigger() {
        assertThat(cm.delta(1, 0)).isEqualTo(1);
    }

    @Test
    void deltaRightBigger() {
        assertThat(cm.delta(0, 1)).isEqualTo(1);
    }

    @Test
    void deltaSame() {
        assertThat(cm.delta(0, 0)).isZero();
    }

    @Test
    void arePositiveTF() {
        assertThat(cm.arePositive(1, -1)).isFalse();
    }

    @Test
    void arePositiveFT() {
        assertThat(cm.arePositive(-1, 1)).isFalse();
    }

    @Test
    void arePositiveTT() {
        assertThat(cm.arePositive(1, 1)).isTrue();
    }
}
