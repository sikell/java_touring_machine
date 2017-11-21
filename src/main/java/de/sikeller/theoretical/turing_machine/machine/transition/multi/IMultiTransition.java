package de.sikeller.theoretical.turing_machine.machine.transition.multi;

import de.sikeller.theoretical.turing_machine.machine.head.HeadMotion;
import de.sikeller.theoretical.turing_machine.machine.state.IState;

import java.util.List;

public interface IMultiTransition<A> {

    List<HeadMotion> getHeadMotions();

    List<A> getWrites();

    IState getNextState();

    int size();

}
