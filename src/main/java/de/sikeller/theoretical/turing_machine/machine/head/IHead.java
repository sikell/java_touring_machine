package de.sikeller.theoretical.turing_machine.machine.head;

import de.sikeller.theoretical.turing_machine.tape.ITape;

public interface IHead<A> {

    void moveRight();

    void moveLeft();

    A read();

    void write(A symbol);

    void useTape(ITape<A> tape);

}
