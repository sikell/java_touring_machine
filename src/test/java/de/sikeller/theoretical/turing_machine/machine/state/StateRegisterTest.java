package de.sikeller.theoretical.turing_machine.machine.state;

import de.sikeller.theoretical.turing_machine.utils.CollectionUtils;
import org.junit.Test;

import java.util.Collections;
import java.util.Set;

import static org.junit.Assert.*;

public class StateRegisterTest {

    @Test(expected = IllegalArgumentException.class)
    public void constructorNull() throws Exception {
        new StateRegister(null, CollectionUtils.setOf(new State("a")));
    }

    @Test(expected = IllegalArgumentException.class)
    public void constructorNullFinal() throws Exception {
        new StateRegister(new State("a"), null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void constructorEmpty() throws Exception {
        new StateRegister(new State("a"), Collections.emptySet());
    }

    @Test
    public void isFinal() throws Exception {
        Set<IState> endStates = CollectionUtils.setOf(
                new State("c"),
                new State("b")
        );
        assertFalse(new StateRegister(new State("a"), endStates).isFinal());
        assertTrue(new StateRegister(new State("b"), endStates).isFinal());
    }

    @Test
    public void setActualState() throws Exception {
        Set<IState> endStates = CollectionUtils.setOf(new State("c"));
        IStateRegister stateRegister = new StateRegister(new State("a"), endStates);
        assertEquals(new State("a"), stateRegister.getActualState());
        stateRegister.setActualState(new State("b"));
        assertEquals(new State("b"), stateRegister.getActualState());
    }


    @Test(expected = IllegalArgumentException.class)
    public void setActualStateNull() throws Exception {
        Set<IState> endStates = CollectionUtils.setOf(new State("c"));
        IStateRegister stateRegister = new StateRegister(new State("a"), endStates);
        stateRegister.setActualState(null);
    }

}