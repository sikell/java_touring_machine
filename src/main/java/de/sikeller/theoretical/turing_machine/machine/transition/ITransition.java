package de.sikeller.theoretical.turing_machine.machine.transition;

import de.sikeller.theoretical.turing_machine.machine.head.HeadMotion;
import de.sikeller.theoretical.turing_machine.machine.state.IState;

public interface ITransition {

    HeadMotion getHeadMotion();

    String getWrite();

    IState getNextState();

}
