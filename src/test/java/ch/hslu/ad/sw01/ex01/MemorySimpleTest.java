package ch.hslu.ad.sw01.ex01;

import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.Ignore;
import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

public class MemorySimpleTest {

    @Test
    public void testHashCode() {
        MemorySimple mem1 = new MemorySimple(1024);
        MemorySimple mem2 = mem1;
        assertThat(mem1.hashCode()).isEqualTo(mem2.hashCode());

        MemorySimple mem3 = new MemorySimple(1024);
        mem3.malloc(16);

        assertThat(mem1.hashCode()).isNotEqualTo(mem3.hashCode());
    }

    @Test
    public void testEquals() {
        EqualsVerifier.forClass(MemorySimple.class);
    }

}