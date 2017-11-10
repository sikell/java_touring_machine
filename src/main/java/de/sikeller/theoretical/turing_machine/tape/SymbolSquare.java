package de.sikeller.theoretical.turing_machine.tape;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@EqualsAndHashCode(of = "symbol")
@AllArgsConstructor
public class SymbolSquare implements ISquare {

    private final String symbol;

    @Override
    public boolean isBlank() {
        return this.symbol == null;
    }

}
