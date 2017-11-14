package de.sikeller.theoretical.turing_machine.tape;

public interface ITape<A> {

    ISquare<A> read(Integer index);

    void write(Integer index, ISquare<A> symbol);

    String toSymbolString();

}
