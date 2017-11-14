package de.sikeller.theoretical.turing_machine.machine.state;

import org.junit.Test;

import static org.junit.Assert.*;

public class StateTest {

    @Test
    public void toStringTest() throws Exception {
        assertEquals("a", new State("a").toString());
        assertEquals("asd", new State("asd").toString());
    }

    @Test
    public void getName() throws Exception {
        assertEquals("a", new State("a").getName());
        assertEquals("asd", new State("asd").getName());
    }

    @Test
    public void equals() throws Exception {
        assertTrue(new State("a").equals(new State("a")));
        assertTrue(new State("b").equals(new State("b")));
        assertFalse(new State("a").equals(new State("b")));
    }

    @Test(expected = IllegalArgumentException.class)
    public void constructorNull() throws Exception {
        new State(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void constructorEmpty() throws Exception {
        new State("");
    }

}