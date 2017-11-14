package de.sikeller.theoretical.turing_machine.machine;

import de.sikeller.theoretical.turing_machine.machine.head.Head;
import de.sikeller.theoretical.turing_machine.machine.head.IHead;
import de.sikeller.theoretical.turing_machine.machine.state.IState;
import de.sikeller.theoretical.turing_machine.machine.state.IStateRegister;
import de.sikeller.theoretical.turing_machine.machine.state.StateRegister;
import de.sikeller.theoretical.turing_machine.machine.transition.ITransition;
import de.sikeller.theoretical.turing_machine.machine.transition.ITransitionFunction;
import de.sikeller.theoretical.turing_machine.tape.ITape;

import java.util.Set;

public class TuringMachine<A> implements ITuringMachine<A> {

    private final A blankSymbol;
    private final ITransitionFunction<A> transitionFunction;

    private final IStateRegister stateRegister;

    public TuringMachine(Set<IState> states,
                         Set<A> alphabetSymbols,
                         Set<A> inputSymbols,
                         A blankSymbol,
                         ITransitionFunction<A> transitionFunction,
                         IState initialState,
                         Set<IState> finalStates) {
        this.blankSymbol = blankSymbol;
        this.transitionFunction = transitionFunction;

        stateRegister = new StateRegister(initialState, finalStates);
    }

    @Override
    public boolean solve(ITape<A> tape) {
        IHead<A> head = new Head<>(blankSymbol, tape);
        int iteration = 0;
        while (!stateRegister.isFinal() && iteration < 10000) {
            System.out.println("Iteration i = " + iteration);
            System.out.println("Tape: " + tape.toSymbolString());
            IState actualState = stateRegister.getActualState();
            A actualSymbol = head.read();
            System.out.println("Actual: (" + actualState.toString() + "," + actualSymbol + ")");
            ITransition<A> transition = transitionFunction.getTransition(actualState, actualSymbol);
            if (transition == null) {
                System.out.println("No transition found!");
                return false;
            }
            System.out.println("" + transition.toString());
            head.write(transition.getWrite());
            transition.getHeadMotion().run(head);
            stateRegister.setActualState(transition.getNextState());
            iteration++;
        }
        System.out.println("Input string accepted!");
        return true;
    }

}
