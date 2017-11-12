package de.sikeller.theoretical.turing_machine.machine.transition;

import de.sikeller.theoretical.turing_machine.machine.head.HeadMotion;
import de.sikeller.theoretical.turing_machine.machine.state.State;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
class TransitionRule implements ITransitionRule {

    private final State inputState;
    private final String inputSymbol;

    private final HeadMotion headMotion;
    private final String write;
    private final State nextState;

}
