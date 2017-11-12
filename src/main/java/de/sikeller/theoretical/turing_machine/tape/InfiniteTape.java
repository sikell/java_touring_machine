package de.sikeller.theoretical.turing_machine.tape;

import lombok.EqualsAndHashCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

@EqualsAndHashCode
public class InfiniteTape implements ITape {

    private final ArrayList<ISquare> array;

    public InfiniteTape(String sequence) {
        this(Arrays.stream(sequence.split(""))
                .map(SymbolSquare::new)
                .collect(Collectors.toList()));
    }

    InfiniteTape(Collection<ISquare> array) {
        this.array = new ArrayList<>();
        if (array == null || array.isEmpty()) {
            throw new IllegalArgumentException("InfiniteTape must not be empty!");
        }
        this.array.addAll(array);
    }

    @Override
    public ISquare read(Integer index) {
        if (index < 0 || index >= array.size()) {
            return new BlankSquare();
        }
        return array.get(index);
    }

    @Override
    public void write(Integer index, ISquare symbol) {
        if (index < 0 || index >= array.size()) {
            throw new IllegalArgumentException("Write on blanks, which are not initialized on startup is actually not possible.");
        }
        array.set(index, symbol);
    }

    @Override
    public String toSymbolString() {
        return array.stream()
                .map(ISquare::toSymbolString)
                .reduce(String::concat)
                .orElse(null);
    }

}
