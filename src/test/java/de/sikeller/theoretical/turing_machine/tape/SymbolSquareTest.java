package de.sikeller.theoretical.turing_machine.tape;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class SymbolSquareTest {

    @Test(expected = IllegalArgumentException.class)
    public void constructorEmpty() throws Exception {
        new SymbolSquare<>(null);
    }

    @Test
    public void isBlank() throws Exception {
        assertFalse(new SymbolSquare<Object>("").isBlank());
    }

    @Test
    public void getSymbol() throws Exception {
        Object o = new Object();
        assertEquals(o, new SymbolSquare<>(o).getSymbol());
        assertEquals("Test", new SymbolSquare<>("Test").getSymbol());
    }

    @Test
    public void toSymbolString() throws Exception {
        Object o = mock(Object.class);
        when(o.toString()).thenReturn("xObject");
        assertEquals("xObject", new SymbolSquare<>(o).toSymbolString());
        assertEquals("T", new SymbolSquare<>("T").toSymbolString());
    }

    @Test
    public void equals() {
        Object o = new Object();
        assertTrue(new SymbolSquare<>(o).equals(new SymbolSquare<>(o)));
        assertTrue(new SymbolSquare<>("T").equals(new SymbolSquare<>("T")));
        assertFalse(new SymbolSquare<>("T").equals(new SymbolSquare<>(o)));
    }

}