package de.sikeller.theoretical.turing_machine.machine.state;

import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@EqualsAndHashCode
public class State implements IState {

    private final String name;

    public State(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("State name must be a non empty string.");
        }
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
