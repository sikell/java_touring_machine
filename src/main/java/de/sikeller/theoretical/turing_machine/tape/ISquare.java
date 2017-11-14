package de.sikeller.theoretical.turing_machine.tape;

public interface ISquare<A> {

    boolean isBlank();

    A getSymbol();

    String toSymbolString();

}
