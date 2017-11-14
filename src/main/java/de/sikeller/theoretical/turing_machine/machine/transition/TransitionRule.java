package de.sikeller.theoretical.turing_machine.machine.transition;

import de.sikeller.theoretical.turing_machine.machine.head.HeadMotion;
import de.sikeller.theoretical.turing_machine.machine.state.IState;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class TransitionRule<A> implements ITransitionRule<A> {

    private final IState inputState;
    private final A inputSymbol;

    private final IState nextState;
    private final A write;
    private final HeadMotion headMotion;

    @Override
    public String toString() {
        return String.format("(%s,%s,%s,%s,%s)",
                inputState.toString(),
                inputSymbol.toString(),
                nextState.toString(),
                write.toString(),
                headMotion.toString());
    }
}
