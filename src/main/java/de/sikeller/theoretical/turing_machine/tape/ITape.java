package de.sikeller.theoretical.turing_machine.tape;

public interface ITape {

    ISquare read(Integer index);

    void write(Integer index, ISquare symbol);

}
