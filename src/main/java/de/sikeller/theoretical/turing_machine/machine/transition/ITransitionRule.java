package de.sikeller.theoretical.turing_machine.machine.transition;

import de.sikeller.theoretical.turing_machine.machine.state.IState;

public interface ITransitionRule extends ITransition {

    IState getInputState();

    String getInputSymbol();

}
