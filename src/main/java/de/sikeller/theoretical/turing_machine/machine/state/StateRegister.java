package de.sikeller.theoretical.turing_machine.machine.state;

import lombok.Getter;

import java.util.Set;

public class StateRegister implements IStateRegister {

    @Getter
    private IState actualState;
    private final Set<IState> finalStates;

    public StateRegister(IState actualState, Set<IState> finalStates) {
        if (actualState == null || finalStates == null || finalStates.isEmpty()) {
            throw new IllegalArgumentException("Input states must be non empty.");
        }
        this.actualState = actualState;
        this.finalStates = finalStates;
    }

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
