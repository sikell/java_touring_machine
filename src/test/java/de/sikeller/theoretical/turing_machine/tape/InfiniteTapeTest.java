package de.sikeller.theoretical.turing_machine.tape;

import de.sikeller.theoretical.turing_machine.utils.CollectionUtils;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.*;

public class InfiniteTapeTest {


    @Test
    public void read() throws Exception {
        List<ISquare<String>> tapeVal = CollectionUtils.listOf(
                new SymbolSquare<>("a"),
                new SymbolSquare<>("b"),
                new SymbolSquare<>("c"),
                new SymbolSquare<>("d")
        );
        InfiniteTape<String> tape = new InfiniteTape<>(tapeVal);
        assertEquals(new BlankSquare(), tape.read(-2));
        assertEquals(new BlankSquare(), tape.read(-1));
        assertEquals(new SymbolSquare<>("a"), tape.read(0));
        assertEquals(new SymbolSquare<>("b"), tape.read(1));
        assertEquals(new SymbolSquare<>("c"), tape.read(2));
        assertEquals(new SymbolSquare<>("d"), tape.read(3));
        assertEquals(new BlankSquare(), tape.read(4));
        assertEquals(new BlankSquare(), tape.read(5));
    }

    @Test
    public void write() throws Exception {
        List<ISquare<String>> tapeVal = CollectionUtils.listOf(new SymbolSquare<>("a"));
        InfiniteTape<String> tape = new InfiniteTape<>(tapeVal);
        tape.write(0, new SymbolSquare<>("h"));

        assertEquals(new SymbolSquare<>("h"), tape.read(0));
    }


    @Test
    public void writeOnBlanksRight() throws Exception {
        InfiniteTape<String> tape = new InfiniteTape<>(CollectionUtils.listOf(new SymbolSquare<>("a")));
        tape.write(1, new SymbolSquare<>("h"));

        assertEquals(new BlankSquare(), tape.read(-2));
        assertEquals(new BlankSquare(), tape.read(-1));
        assertEquals(new SymbolSquare<>("a"), tape.read(0));
        assertEquals(new SymbolSquare<>("h"), tape.read(1));
        assertEquals(new BlankSquare(), tape.read(2));
        assertEquals(new BlankSquare(), tape.read(3));
    }

    @Test(expected = IllegalArgumentException.class)
    public void writeOnBlanksLeft() throws Exception {
        InfiniteTape<String> tape = new InfiniteTape<>(CollectionUtils.listOf(new SymbolSquare<>("a")));
        tape.write(-1, new BlankSquare<>());
    }

    @Test
    public void equals() throws Exception {
        InfiniteTape<String> tape1 = new InfiniteTape<>(CollectionUtils.listOf(
                new SymbolSquare<>("a"),
                new SymbolSquare<>("b"),
                new SymbolSquare<>("c")
        ));
        InfiniteTape<String> tape2 = new InfiniteTape<>(CollectionUtils.listOf(
                new SymbolSquare<>("a"),
                new SymbolSquare<>("b")
        ));
        InfiniteTape<String> tape3 = new InfiniteTape<>(CollectionUtils.listOf(
                new SymbolSquare<>("a"),
                new SymbolSquare<>("b"),
                new SymbolSquare<>("c")
        ));
        InfiniteTape<String> tape4 = new InfiniteTape<>(CollectionUtils.listOf(
                new SymbolSquare<>("a"),
                new SymbolSquare<>("b"),
                new SymbolSquare<>("d")
        ));

        assertFalse(tape1.equals(tape2));
        assertTrue(tape1.equals(tape3));
        assertFalse(tape1.equals(tape4));
    }

    @Test(expected = IllegalArgumentException.class)
    public void constructorNullTest() throws Exception {
        new InfiniteTape<>(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void constructorEmptyTest() throws Exception {
        new InfiniteTape<>(new LinkedList<>());
    }

    @Test
    public void toSymbolString() throws Exception {
        assertEquals("abc", new InfiniteTape<>(CollectionUtils.listOf(
                new SymbolSquare<>("a"),
                new SymbolSquare<>("b"),
                new SymbolSquare<>("c")
        )).toSymbolString());
        assertEquals("ac", new InfiniteTape<>(CollectionUtils.listOf(
                new SymbolSquare<>("a"),
                new SymbolSquare<>("c")
        )).toSymbolString());
        assertEquals("a~c", new InfiniteTape<>(CollectionUtils.listOf(
                new SymbolSquare<>("a"),
                new BlankSquare<>(),
                new SymbolSquare<>("c")
        )).toSymbolString());
    }

}