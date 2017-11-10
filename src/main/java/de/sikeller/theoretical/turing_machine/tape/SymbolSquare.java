package de.sikeller.theoretical.turing_machine.tape;

import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@EqualsAndHashCode(of = "symbol")
public class SymbolSquare implements ISquare {

    private final String symbol;

    public SymbolSquare(String symbol) {
        if (symbol == null || symbol.isEmpty()) {
            throw new IllegalArgumentException("Symbol square must contain a non empty string symbol.");
        }
        this.symbol = symbol;
    }

    @Override
    public boolean isBlank() {
        return this.symbol == null;
    }

    @Override
    public String toSymbolString() {
        return symbol;
    }

}
