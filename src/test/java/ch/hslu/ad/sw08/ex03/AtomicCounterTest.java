package ch.hslu.ad.sw08.ex03;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.assertj.core.api.Assertions.*;

public class AtomicCounterTest {

    @Test
    public void testIncrement() {
        AtomicCounter counter = new AtomicCounter();
        counter.increment();
        assertThat(counter.get()).isEqualTo(1);
    }

    @Test
    public void testDecrement() {
        AtomicCounter counter = new AtomicCounter();
        counter.decrement();
        assertThat(counter.get()).isEqualTo(-1);
    }

    @Test
    public void testGet() {
        AtomicCounter counter = new AtomicCounter();
        assertNotNull(counter.get());
    }
}