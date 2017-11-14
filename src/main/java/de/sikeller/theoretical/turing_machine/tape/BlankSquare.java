package de.sikeller.theoretical.turing_machine.tape;

import lombok.EqualsAndHashCode;

@EqualsAndHashCode
public class BlankSquare<A> implements ISquare<A> {

    @Override
    public boolean isBlank() {
        return true;
    }

    @Override
    public A getSymbol() {
        return null;
    }

    @Override
    public String toSymbolString() {
        return "~";
    }

}
