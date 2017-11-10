package de.sikeller.theoretical.turing_machine.machine;

import de.sikeller.theoretical.turing_machine.machine.head.Head;
import de.sikeller.theoretical.turing_machine.tape.BlankSquare;
import de.sikeller.theoretical.turing_machine.tape.ITape;
import de.sikeller.theoretical.turing_machine.tape.SymbolSquare;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class HeadTest {

    @Test
    public void moveRight() throws Exception {
        ITape tape = mock(ITape.class);
        when(tape.read(-1)).thenReturn(new BlankSquare());
        when(tape.read(0)).thenReturn(new SymbolSquare("a"));
        when(tape.read(1)).thenReturn(new SymbolSquare("b"));
        when(tape.read(2)).thenReturn(new SymbolSquare("c"));
        when(tape.read(3)).thenReturn(new SymbolSquare("d"));
        when(tape.read(4)).thenReturn(new BlankSquare());
        when(tape.read(5)).thenReturn(new BlankSquare());

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
        ITape tape = mock(ITape.class);
        when(tape.read(-2)).thenReturn(new BlankSquare());
        when(tape.read(-1)).thenReturn(new BlankSquare());
        when(tape.read(0)).thenReturn(new SymbolSquare("a"));
        when(tape.read(1)).thenReturn(new SymbolSquare("b"));
        when(tape.read(2)).thenReturn(new SymbolSquare("c"));

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
        ITape tape = mock(ITape.class);
        when(tape.read(-1)).thenReturn(new BlankSquare());
        when(tape.read(0)).thenReturn(new SymbolSquare("a"));
        when(tape.read(1)).thenReturn(new SymbolSquare("b"));
        when(tape.read(2)).thenReturn(new SymbolSquare("c"));
        when(tape.read(3)).thenReturn(new BlankSquare());

        assertEquals("f", new Head(-1, "f", tape).read());
        assertEquals("a", new Head(0, "f", tape).read());
        assertEquals("b", new Head(1, "f", tape).read());
        assertEquals("c", new Head(2, "f", tape).read());
        assertEquals("f", new Head(3, "f", tape).read());
    }

    @Test
    public void write() throws Exception {
        ITape tape = mock(ITape.class);
        Head head = new Head(1, "f", tape);

        head.write("a");
        verify(tape).write(1, new SymbolSquare("a"));

        head.write("f");
        verify(tape).write(1, new BlankSquare());
    }

    @Test
    public void useTape() throws Exception {
        ITape oldTape = mock(ITape.class);
        when(oldTape.read(0)).thenReturn(new BlankSquare());
        ITape newTape = mock(ITape.class);
        when(newTape.read(0)).thenReturn(new BlankSquare());

        Head head = new Head("h", oldTape);
        head.read();
        head.write("a");

        verify(oldTape).read(0);
        verify(oldTape).write(0, new SymbolSquare("a"));

        head.useTape(newTape);
        head.read();
        head.write("a");

        verify(newTape).read(0);
        verify(newTape).write(0, new SymbolSquare("a"));
        verifyZeroInteractions(oldTape);
    }

}