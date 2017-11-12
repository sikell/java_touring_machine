package de.sikeller.theoretical.turing_machine.machine.state;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public class StateRegister implements IStateRegister {

    @Getter
    private IState actualState;
    private final IState finalState;

    @Override
    public boolean isFinal() {
        return finalState.equals(actualState);
    }

    @Override
    public void setActualState(IState actualState) {
        if (actualState == null) {
            throw new IllegalArgumentException("The actual state must not be null.");
        }
        this.actualState = actualState;
    }

}
