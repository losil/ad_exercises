package ch.hslu.ad.sw02.ex03;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

public class StackTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void testEmpty() {
        Stack stack = new Stack(10);
        assertTrue(stack.empty());
    }

    @Test
    public void testNotEmpty() {
        Stack stack = new Stack(10);
        stack.push("str");
        assertFalse(stack.empty());
    }

    @Test
    public void testIsFull() {
        Stack stack = new Stack(1);
        stack.push("str");
        thrown.expect(ArrayIndexOutOfBoundsException.class);
        thrown.expectMessage("There is no more place on the stack!");
        stack.push("full");

    }

    @Test
    public void testPeek() {
    }

    @Test
    public void testPop() {
    }

    @Test
    public void testPush() {
    }

    @Test
    public void testSearch() {
    }
}