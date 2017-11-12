package de.sikeller.theoretical.turing_machine.machine.transition;

import de.sikeller.theoretical.turing_machine.machine.head.HeadMotion;
import de.sikeller.theoretical.turing_machine.machine.state.IState;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class TransitionRule implements ITransitionRule {

    private final IState inputState;
    private final String inputSymbol;

    private final IState nextState;
    private final String write;
    private final HeadMotion headMotion;

    @Override
    public String toString() {
        return String.format("(%s,%s,%s,%s,%s)",
                inputState.toString(), inputSymbol, nextState.toString(), write, headMotion.toString());
    }
}
