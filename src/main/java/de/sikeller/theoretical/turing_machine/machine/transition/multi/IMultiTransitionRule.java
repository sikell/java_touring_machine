package de.sikeller.theoretical.turing_machine.machine.transition.multi;

import de.sikeller.theoretical.turing_machine.machine.state.IState;

import java.util.List;

public interface IMultiTransitionRule<A> extends IMultiTransition<A> {

    IState getInputState();

    List<A> getInputSymbols();

}
