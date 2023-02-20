package com.example.jalt.m3.s02;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class WorkerTest {
    private Worker worker = new Worker();

    @Test
    void generatePlain() {
        assertThat(worker.generate(15, 6)).isEqualTo(42);
    }
}
