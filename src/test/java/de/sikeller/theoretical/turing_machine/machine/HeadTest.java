package de.sikeller.theoretical.turing_machine.machine;

import de.sikeller.theoretical.turing_machine.tape.ISquare;
import de.sikeller.theoretical.turing_machine.tape.InfiniteTape;
import de.sikeller.theoretical.turing_machine.tape.SymbolSquare;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class HeadTest {

    @Test
    public void moveRight() throws Exception {
        ISquare[] tapeVal = {
                new SymbolSquare("a"),
                new SymbolSquare("b"),
                new SymbolSquare("c"),
                new SymbolSquare("d")
        };
        InfiniteTape tape = new InfiniteTape(Arrays.asList(tapeVal));
        Head head = new Head(0, "h", tape);
        assertEquals("a", head.read());
        head.moveRight();
        assertEquals("b", head.read());
        head.moveRight();
        assertEquals("c", head.read());
        head.moveRight();
        assertEquals("d", head.read());
        head.moveRight();
        assertEquals("h", head.read());
        head.moveRight();
        assertEquals("h", head.read());
    }

    @Test
    public void moveLeft() throws Exception {
        ISquare[] tapeVal = {
                new SymbolSquare("a"),
                new SymbolSquare("b"),
                new SymbolSquare("c")
        };
        InfiniteTape tape = new InfiniteTape(Arrays.asList(tapeVal));
        Head head = new Head(2, "h", tape);
        assertEquals("c", head.read());
        head.moveLeft();
        assertEquals("b", head.read());
        head.moveLeft();
        assertEquals("a", head.read());
        head.moveLeft();
        assertEquals("h", head.read());
        head.moveLeft();
        assertEquals("h", head.read());
    }

    @Test
    public void read() throws Exception {
        ISquare[] tapeVal = {
                new SymbolSquare("a"),
                new SymbolSquare("b"),
                new SymbolSquare("c")
        };
        InfiniteTape tape = new InfiniteTape(Arrays.asList(tapeVal));

        assertEquals("f", new Head(-1, "f", tape).read());
        assertEquals("a", new Head(0, "f", tape).read());
        assertEquals("b", new Head(1, "f", tape).read());
        assertEquals("c", new Head(2, "f", tape).read());
        assertEquals("f", new Head(3, "f", tape).read());
    }

    @Test
    public void useTape() throws Exception {
        ISquare[] tapeVal = {new SymbolSquare("a")};
        Head head = new Head("h", new InfiniteTape(Arrays.asList(tapeVal)));

        assertEquals("a", head.read());

        ISquare[] newTapeVal = {new SymbolSquare("d")};
        head.useTape(new InfiniteTape(Arrays.asList(newTapeVal)));

        assertEquals("d", head.read());
    }

}