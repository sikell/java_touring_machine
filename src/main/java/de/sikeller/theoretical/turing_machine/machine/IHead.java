package de.sikeller.theoretical.turing_machine.machine;

import de.sikeller.theoretical.turing_machine.tape.ITape;

public interface IHead {

    void moveRight();

    void moveLeft();

    String read();

    void useTape(ITape tape);

}
