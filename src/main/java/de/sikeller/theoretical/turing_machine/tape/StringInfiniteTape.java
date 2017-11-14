package de.sikeller.theoretical.turing_machine.tape;

import java.util.Arrays;
import java.util.stream.Collectors;

public class StringInfiniteTape extends InfiniteTape<String> {

    public StringInfiniteTape(String sequence) {
        super(sequence == null || sequence.isEmpty() ? null
                : Arrays.stream(sequence.split(""))
                .map(SymbolSquare::new)
                .collect(Collectors.toList()));
    }

}
