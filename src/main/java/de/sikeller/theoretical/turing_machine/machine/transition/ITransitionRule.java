package de.sikeller.theoretical.turing_machine.machine.transition;

import de.sikeller.theoretical.turing_machine.machine.state.IState;

public interface ITransitionRule<A> extends ITransition<A> {

    IState getInputState();

    A getInputSymbol();

}
