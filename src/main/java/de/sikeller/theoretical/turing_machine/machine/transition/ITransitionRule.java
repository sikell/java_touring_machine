package de.sikeller.theoretical.turing_machine.machine.transition;

import de.sikeller.theoretical.turing_machine.machine.state.State;

public interface ITransitionRule extends ITransition {

    State getInputState();

    String getInputSymbol();

}
