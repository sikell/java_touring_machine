package de.sikeller.theoretical.turing_machine.machine.state;

public interface IStateRegister {
    boolean isFinal();

    void setActualState(IState actualState);

    IState getActualState();
}
