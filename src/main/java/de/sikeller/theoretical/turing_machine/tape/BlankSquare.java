package de.sikeller.theoretical.turing_machine.tape;

import lombok.EqualsAndHashCode;

@EqualsAndHashCode
public class BlankSquare implements ISquare {

    @Override
    public boolean isBlank() {
        return true;
    }

    @Override
    public String getSymbol() {
        return null;
    }

}
