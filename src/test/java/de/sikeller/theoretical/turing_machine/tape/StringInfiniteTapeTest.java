package de.sikeller.theoretical.turing_machine.tape;

import de.sikeller.theoretical.turing_machine.utils.CollectionUtils;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class StringInfiniteTapeTest {


    @Test
    public void constructorFromString() throws Exception {
        ITape<String> tape = new StringInfiniteTape("abc");
        List<ISquare<String>> tapeVal = CollectionUtils.listOf(
                new SymbolSquare<>("a"),
                new SymbolSquare<>("b"),
                new SymbolSquare<>("c")
        );
        ITape<String> expected = new InfiniteTape<>(tapeVal);
        assertEquals(expected, tape);
    }

    @Test(expected = IllegalArgumentException.class)
    public void constructorNullStringTest() throws Exception {
        new StringInfiniteTape(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void constructorEmptyStringTest() throws Exception {
        new StringInfiniteTape("").toSymbolString();
    }


}