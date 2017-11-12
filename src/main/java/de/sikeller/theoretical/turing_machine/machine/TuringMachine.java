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

public class TuringMachine implements ITuringMachine {

    private final String blankSymbol;
    private final ITransitionFunction transitionFunction;

    private final IStateRegister stateRegister;

    public TuringMachine(Set<IState> states,
                         Set<String> alphabetSymbols,
                         Set<String> inputSymbols,
                         String blankSymbol,
                         ITransitionFunction transitionFunction,
                         IState initialState,
                         Set<IState> finalStates) {
        this.blankSymbol = blankSymbol;
        this.transitionFunction = transitionFunction;

        stateRegister = new StateRegister(initialState, finalStates);
    }

    @Override
    public boolean solve(ITape tape) {
        IHead head = new Head(blankSymbol, tape);
        int iteration = 0;
        while (!stateRegister.isFinal() && iteration < 10000) {
            System.out.println("Iteration i = " + iteration);
            System.out.println("Tape: " + tape.toSymbolString());
            IState actualState = stateRegister.getActualState();
            String actualSymbol = head.read();
            System.out.println("Actual: (" + actualState.toString() + "," + actualSymbol + ")");
            ITransition transition = transitionFunction.getTransition(actualState, actualSymbol);
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
