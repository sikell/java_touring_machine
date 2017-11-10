package de.sikeller.theoretical.turing_machine.tape;

import lombok.EqualsAndHashCode;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@EqualsAndHashCode
public class InfiniteTape implements ITape {

    private final List<ISquare> array;

    public InfiniteTape(Collection<ISquare> array) {
        this.array = new ArrayList<>();
        if (array == null) {
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
}
