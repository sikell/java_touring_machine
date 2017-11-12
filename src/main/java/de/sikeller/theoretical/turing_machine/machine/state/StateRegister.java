package de.sikeller.theoretical.turing_machine.machine.state;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Set;

@AllArgsConstructor
public class StateRegister implements IStateRegister {

    @Getter
    private IState actualState;
    private final Set<IState> finalStates;

    @Override
    public boolean isFinal() {
        return finalStates.contains(actualState);
    }

    @Override
    public void setActualState(IState actualState) {
        if (actualState == null) {
            throw new IllegalArgumentException("The actual state must not be null.");
        }
        this.actualState = actualState;
    }

}
