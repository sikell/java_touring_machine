package de.sikeller.theoretical.turing_machine.tape;

public interface ITape<A> {

    A read(Integer index);

    void write(Integer index, A symbol);

    String toSymbolString();

}
