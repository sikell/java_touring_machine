package de.sikeller.theoretical.turing_machine.tape;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;

import static org.junit.Assert.*;

public class InfiniteTapeTest {


    @Test
    public void read() throws Exception {
        InfiniteTape tape = new InfiniteTape("abcd");
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
    public void write() throws Exception {
        ISquare[] tapeVal = {new SymbolSquare("a")};
        InfiniteTape tape = new InfiniteTape(Arrays.asList(tapeVal));
        tape.write(0, new BlankSquare());

        assertEquals(new BlankSquare(), tape.read(0));
    }


    @Test(expected = IllegalArgumentException.class)
    public void writeOnBlanksRight() throws Exception {
        ISquare[] tapeVal = {new SymbolSquare("a")};
        InfiniteTape tape = new InfiniteTape(Arrays.asList(tapeVal));
        tape.write(1, new BlankSquare());
    }

    @Test(expected = IllegalArgumentException.class)
    public void writeOnBlanksLeft() throws Exception {
        ISquare[] tapeVal = {new SymbolSquare("a")};
        InfiniteTape tape = new InfiniteTape(Arrays.asList(tapeVal));
        tape.write(-1, new BlankSquare());
    }

    @Test
    public void equals() throws Exception {
        InfiniteTape tape1 = new InfiniteTape("abc");
        InfiniteTape tape2 = new InfiniteTape("ab");
        InfiniteTape tape3 = new InfiniteTape("abc");
        InfiniteTape tape4 = new InfiniteTape("adc");

        assertFalse(tape1.equals(tape2));
        assertTrue(tape1.equals(tape3));
        assertFalse(tape1.equals(tape4));
    }


    @Test
    public void constructorFromString() throws Exception {
        ITape tape = new InfiniteTape("abc");
        ISquare[] tapeVal = {
                new SymbolSquare("a"),
                new SymbolSquare("b"),
                new SymbolSquare("c")
        };
        ITape expected = new InfiniteTape(Arrays.asList(tapeVal));
        assertEquals(expected, tape);
    }

    @Test(expected = IllegalArgumentException.class)
    public void constructorNullTest() throws Exception {
        new InfiniteTape((Collection<ISquare>) null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void constructorEmptyTest() throws Exception {
        new InfiniteTape(new LinkedList<>());
    }

    @Test(expected = NullPointerException.class)
    public void constructorNullStringTest() throws Exception {
        new InfiniteTape((String) null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void constructorEmptyStringTest() throws Exception {
        System.out.println(new InfiniteTape("").toSymbolString());
    }

    @Test
    public void toSymbolString() throws Exception {
        ISquare[] tapeVal = {
                new SymbolSquare("a"),
                new BlankSquare(),
                new SymbolSquare("c")
        };
        assertEquals("abc", new InfiniteTape("abc").toSymbolString());
        assertEquals("ac", new InfiniteTape("ac").toSymbolString());
        assertEquals("a~c", new InfiniteTape(Arrays.asList(tapeVal)).toSymbolString());
    }

}