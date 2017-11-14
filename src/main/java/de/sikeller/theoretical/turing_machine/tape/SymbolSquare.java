package de.sikeller.theoretical.turing_machine.tape;

import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@EqualsAndHashCode(of = "symbol")
public class SymbolSquare<A> implements ISquare<A> {

    private final A symbol;

    public SymbolSquare(A symbol) {
        if (symbol == null) {
            throw new IllegalArgumentException("Symbol square must have a non null symbol object.");
        }
        this.symbol = symbol;
    }

    @Override
    public boolean isBlank() {
        return false;
    }

    @Override
    public String toSymbolString() {
        return symbol.toString();
    }

}
