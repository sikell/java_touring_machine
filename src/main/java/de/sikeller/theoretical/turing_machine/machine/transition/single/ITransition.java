package de.sikeller.theoretical.turing_machine.machine.transition.single;

import de.sikeller.theoretical.turing_machine.machine.head.HeadMotion;
import de.sikeller.theoretical.turing_machine.machine.state.IState;

public interface ITransition<A> {

    HeadMotion getHeadMotion();

    A getWrite();

    IState getNextState();

}
