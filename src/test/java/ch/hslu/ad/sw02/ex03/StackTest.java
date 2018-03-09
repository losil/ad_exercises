package ch.hslu.ad.sw02.ex03;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;
import static org.assertj.core.api.Assertions.*;
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
        Stack stack = new Stack(10);
        stack.push("string");
        assertThat(stack.peek()).isEqualTo("string");
        assertThat(stack.peek()).isEqualTo("string");
    }

    @Test
    public void testPop() {
        Stack stack = new Stack(10);
        stack.push("string");
        assertThat(stack.pop()).isEqualTo("string");
    }

    @Rule
    public ExpectedException thrown_pop = ExpectedException.none();
    @Test
    public void testEmptyPop() {
        Stack stack = new Stack(10);
        thrown.expect(ArrayStoreException.class);
        thrown.expectMessage("Stack is empty!");
        stack.pop();
    }

    @Test
    public void testPush() {
        Stack stack = new Stack(10);
        assertThat(stack.push("bla")).isEqualTo("bla");
    }

    @Test
    public void testSearch() {
        Stack stack = new Stack(10);
        stack.push("search string");
        assertThat(stack.search("search string")).isEqualTo(1);
        stack.push("search string 2");
        assertThat(stack.search("search string")).isEqualTo(2);
        assertThat(stack.search("search string 2")).isEqualTo(1);

    }
}