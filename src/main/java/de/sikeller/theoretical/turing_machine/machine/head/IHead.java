package de.sikeller.theoretical.turing_machine.machine.head;

import de.sikeller.theoretical.turing_machine.tape.ITape;

public interface IHead {

    void moveRight();

    void moveLeft();

    String read();

    void write(String symbol);

    void useTape(ITape tape);

}
