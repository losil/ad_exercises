package ch.hslu.ad.sw01.ex03;

import org.junit.Test;

import static ch.hslu.ad.sw01.ex03.Main.fiboRec1;
import static org.assertj.core.api.Assertions.assertThat;

public class MainTest {

    @Test
    public void testFiboRec1() {
        assertThat(fiboRec1(10)).isEqualTo(55);
        assertThat(fiboRec1(21)).isEqualTo(10946);
        assertThat(fiboRec1(3)).isEqualTo(2);
    }
}