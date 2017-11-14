package de.sikeller.theoretical.turing_machine.machine.transition;

import de.sikeller.theoretical.turing_machine.machine.state.IState;

public interface ITransitionFunction<A> {

    ITransition<A> getTransition(IState state, A symbol);

}
