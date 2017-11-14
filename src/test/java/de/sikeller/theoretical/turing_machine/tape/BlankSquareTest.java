package de.sikeller.theoretical.turing_machine.tape;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class BlankSquareTest {

    @Test
    public void isBlank() throws Exception {
        assertTrue(new BlankSquare().isBlank());
    }

    @Test
    public void getSymbol() throws Exception {
        assertEquals(null, new BlankSquare().getSymbol());
    }

    @Test
    public void toSymbolString() throws Exception {
        assertEquals("~", new BlankSquare().toSymbolString());
    }

    @Test
    public void equals() {
        assertTrue(new BlankSquare().equals(new BlankSquare()));
    }

}