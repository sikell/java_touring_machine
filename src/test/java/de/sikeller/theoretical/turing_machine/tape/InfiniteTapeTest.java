package de.sikeller.theoretical.turing_machine.tape;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class InfiniteTapeTest {

    @Test(expected = IllegalArgumentException.class)
    public void constructorEmptyTest() throws Exception {
        new InfiniteTape(null);
    }

    @Test
    public void moveRight() throws Exception {
        ISquare[] tapeVal = {
                new SymbolSquare("a"),
                new SymbolSquare("b"),
                new SymbolSquare("c"),
                new SymbolSquare("d")
        };
        InfiniteTape tape = new InfiniteTape(Arrays.asList(tapeVal));
        assertEquals(new BlankSquare(), tape.read(-2));
        assertEquals(new BlankSquare(), tape.read(-1));
        assertEquals(new SymbolSquare("a"), tape.read(0));
        assertEquals(new SymbolSquare("b"), tape.read(1));
        assertEquals(new SymbolSquare("c"), tape.read(2));
        assertEquals(new SymbolSquare("d"), tape.read(3));
        assertEquals(new BlankSquare(), tape.read(4));
        assertEquals(new BlankSquare(), tape.read(5));
    }

    @Test
    public void equals() throws Exception {
        ISquare[] tapeVal1 = {
                new SymbolSquare("a"),
                new SymbolSquare("b"),
                new SymbolSquare("c")
        };
        InfiniteTape tape1 = new InfiniteTape(Arrays.asList(tapeVal1));

        ISquare[] tapeVal2 = {
                new SymbolSquare("a"),
                new SymbolSquare("b")
        };
        InfiniteTape tape2 = new InfiniteTape(Arrays.asList(tapeVal2));

        ISquare[] tapeVal3 = {
                new SymbolSquare("a"),
                new SymbolSquare("b"),
                new SymbolSquare("c")
        };
        InfiniteTape tape3 = new InfiniteTape(Arrays.asList(tapeVal3));

        ISquare[] tapeVal4 = {
                new SymbolSquare("a"),
                new SymbolSquare("d"),
                new SymbolSquare("c")
        };
        InfiniteTape tape4 = new InfiniteTape(Arrays.asList(tapeVal4));

        assertFalse(tape1.equals(tape2));
        assertTrue(tape1.equals(tape3));
        assertFalse(tape1.equals(tape4));

    }

}