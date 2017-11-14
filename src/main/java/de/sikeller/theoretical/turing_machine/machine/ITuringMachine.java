package de.sikeller.theoretical.turing_machine.machine;

import de.sikeller.theoretical.turing_machine.tape.ITape;

public interface ITuringMachine<A> {

    boolean solve(ITape<A> tape);

}
