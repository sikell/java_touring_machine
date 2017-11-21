package de.sikeller.theoretical.turing_machine.machine.transition.multi;

import de.sikeller.theoretical.turing_machine.machine.state.IState;

import java.util.List;

public interface IMultTransitionFunction<A> {

    List<IMultiTransition<A>> getTransition(IState state, List<A> symbol);

}
