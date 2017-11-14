package de.sikeller.theoretical.turing_machine.tape;

import lombok.EqualsAndHashCode;

import java.util.ArrayList;
import java.util.Collection;

@EqualsAndHashCode
public class InfiniteTape<A> implements ITape<A> {

    private final ArrayList<ISquare<A>> array;

    InfiniteTape(Collection<ISquare<A>> array) {
        this.array = new ArrayList<>();
        if (array == null || array.isEmpty()) {
            throw new IllegalArgumentException("InfiniteTape must not be empty!");
        }
        this.array.addAll(array);
    }

    @Override
    public A read(Integer index) {
        if (index < 0 || index >= array.size()) {
            return new BlankSquare<A>().getSymbol();
        }
        return array.get(index).getSymbol();
    }

    @Override
    public void write(Integer index, A symbol) {
        if (index < 0) {
            throw new IllegalArgumentException("Write on blanks, which has an index smaller 0 and are not initialized " +
                    "on startup is actually not possible.");
        }
        if (index >= array.size()) {
            System.out.print("Index to write greater than tape size: Fill up with blanks!");
            int diff = array.size() - index;
            for (int i = 0; i < diff; i++) {
                array.add(new BlankSquare<>());
            }
            array.add(new SymbolSquare<>(symbol));
        } else {
            array.set(index, new SymbolSquare<>(symbol));
        }
    }

    @Override
    public String toSymbolString() {
        return array.stream()
                .map(ISquare::toSymbolString)
                .reduce(String::concat)
                .orElse(null);
    }

}
