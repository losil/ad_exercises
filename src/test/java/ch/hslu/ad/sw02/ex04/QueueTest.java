package ch.hslu.ad.sw02.ex04;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import javax.annotation.concurrent.ThreadSafe;

import java.util.NoSuchElementException;

import static org.junit.Assert.*;
import static org.assertj.core.api.Assertions.*;

public class QueueTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void testAddException() {
        Queue queue = new Queue();
        queue.add('A');
        queue.add('A');
        queue.add('A');
        queue.add('A');
        queue.add('A');
        queue.add('A');
        queue.add('A');
        queue.add('A');
        thrown.expect(IllegalStateException.class);
        thrown.expectMessage("Queue is full.");
        queue.add('A');

    }

    @Test
    public void testAdd() {
        Queue queue = new Queue();
        assertTrue(queue.add('A'));
    }

    @Test
    public void testElement() {
        Queue queue = new Queue();
        queue.offer('A');
        assertThat(queue.element()).isEqualTo('A');
    }

    @Test
    public void offer() {
        Queue queue = new Queue();
        assertTrue(queue.offer('C'));

    }

    @Test
    public void testPeekNull() {
        Queue queue = new Queue();
        assertThat(queue.peek()).isEqualTo(null);

    }

    @Test
    public void testPeek() {
        Queue queue = new Queue();
        queue.add('C');
        assertThat(queue.peek()).isEqualTo('C');
    }

    @Test
    public void testPollNull() {
        Queue queue = new Queue();
        assertThat(queue.poll()).isEqualTo(null);
    }

    @Test
    public void testPoll() {
        Queue queue = new Queue();
        queue.add('A');
        queue.add('B');
        queue.add('C');
        assertThat(queue.poll()).isEqualTo('A');
        assertThat(queue.poll()).isEqualTo('B');
        assertThat(queue.poll()).isEqualTo('C');

    }

    @Test
    public void remove() {
        Queue queue = new Queue();
        queue.add('A');
        queue.add('B');
        queue.add('C');
        assertThat(queue.remove()).isEqualTo('A');
        assertThat(queue.remove()).isEqualTo('B');
        assertThat(queue.remove()).isEqualTo('C');
    }

    @Test
    public void testEmpty() {
        Queue queue = new Queue();
        thrown.expect(NoSuchElementException.class);
        thrown.expectMessage("Queue is empty!");
        queue.remove();
    }
}