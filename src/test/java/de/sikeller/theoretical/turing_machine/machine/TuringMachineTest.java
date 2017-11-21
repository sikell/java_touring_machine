package de.sikeller.theoretical.turing_machine.machine;

import de.sikeller.theoretical.turing_machine.machine.head.HeadMotion;
import de.sikeller.theoretical.turing_machine.machine.state.IState;
import de.sikeller.theoretical.turing_machine.machine.state.State;
import de.sikeller.theoretical.turing_machine.machine.transition.single.ITransitionFunction;
import de.sikeller.theoretical.turing_machine.machine.transition.single.ITransitionRule;
import de.sikeller.theoretical.turing_machine.machine.transition.single.TransitionFunction;
import de.sikeller.theoretical.turing_machine.machine.transition.single.TransitionRule;
import de.sikeller.theoretical.turing_machine.tape.StringInfiniteTape;
import de.sikeller.theoretical.turing_machine.utils.CollectionUtils;
import org.junit.Test;

import java.util.Set;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TuringMachineTest {

    @Test
    public void solve() throws Exception {
        // L = {0^n,1^n,2^n | n >= 1}
        ITuringMachine<String> turingMachine = createExampleTuringMachine();
        assertTrue(turingMachine.solve(new StringInfiniteTape("000111222")));
    }

    @Test
    public void solveNotAccepted() throws Exception {
        // L = {0^n,1^n,2^n | n >= 1}
        ITuringMachine<String> turingMachine = createExampleTuringMachine();
        assertFalse(turingMachine.solve(new StringInfiniteTape("00111222")));
    }


    @Test
    public void solveInfinite() throws Exception {
        // M = (Z;w;S;f;t;q0;E)
        ITuringMachine<String> turingMachine;
        // states Z = {qA, qE}
        Set<IState> states = CollectionUtils.setOf(new State("qA"), new State("qE"));
        // alphabet w = {0}
        Set<String> alphabet = CollectionUtils.setOf("0");
        // working alphabet S = {0,f}
        Set<String> inputAlphabet = CollectionUtils.setOf("0", "f");
        // blank symbol f = f
        String blank = "f";
        // transition function t = {
        // qA, 0 -> qA, 0, N }
        Set<ITransitionRule<String>> rules = CollectionUtils.setOf(
                new TransitionRule<>(new State("qA"), "0", new State("qA"), "0", HeadMotion.NONE)
        );
        ITransitionFunction<String> transitionFunction = new TransitionFunction<>(rules);
        // intial state q0 = qA
        IState initialState = new State("qA");
        // final states E = {qE}
        Set<IState> finalStates = CollectionUtils.setOf(new State("qE"));

        turingMachine = new TuringMachine<>(states,
                alphabet,
                inputAlphabet,
                blank,
                transitionFunction,
                initialState,
                finalStates);

        assertFalse(turingMachine.solve(new StringInfiniteTape("0")));
    }


    private ITuringMachine<String> createExampleTuringMachine() {
        // M = (Z;w;S;f;t;q0;E)
        // L = {0^n,1^n,2^n | n >= 1}
        ITuringMachine<String> turingMachine;
        // states Z = {qA, q1, q2, q3, q4, q5, q6, q7, qE}
        Set<IState> states = CollectionUtils.setOf(
                new State("qA"),
                new State("q1"),
                new State("q2"),
                new State("q3"),
                new State("q4"),
                new State("q5"),
                new State("q6"),
                new State("q7"),
                new State("qE")
        );
        // alphabet w = {0,1,2}
        Set<String> alphabet = CollectionUtils.setOf("0", "1", "2");
        // working alphabet S = {0,1,2,f}
        Set<String> inputAlphabet = CollectionUtils.setOf("0", "1", "2", "f");
        // blank symbol f = f
        String blank = "f";
        // transition function t = {
        // qA, 0 -> q1, f, R,
        // q1, 0 -> q1, 0, R,
        // q1, 1 -> q1, 1, R,
        // q1, 2 -> q2, 2, L,
        // q2, 1 -> q3, 2, R,
        // q3, 2 -> q3, 2, R,
        // q3, f -> q4, f, L,
        // q4, 2 -> q5, f, L,
        // q5, 2 -> q6, f, L,
        // q6, f -> qE, f, N,
        // --> repeat:
        // q6, 2 -> q7, 2, L,
        // q7, 2 -> q7, 2, L,
        // q7, 1 -> q7, 1, L,
        // q7, 0 -> q7, 0, L,
        // q7, f -> qA, f, R }
        Set<ITransitionRule<String>> rules = CollectionUtils.setOf(
                new TransitionRule<>(new State("qA"), "0", new State("q1"), "f", HeadMotion.RIGHT),
                new TransitionRule<>(new State("q1"), "0", new State("q1"), "0", HeadMotion.RIGHT),
                new TransitionRule<>(new State("q1"), "1", new State("q1"), "1", HeadMotion.RIGHT),
                new TransitionRule<>(new State("q1"), "2", new State("q2"), "2", HeadMotion.LEFT),
                new TransitionRule<>(new State("q2"), "1", new State("q3"), "2", HeadMotion.RIGHT),
                new TransitionRule<>(new State("q3"), "2", new State("q3"), "2", HeadMotion.RIGHT),
                new TransitionRule<>(new State("q3"), "f", new State("q4"), "f", HeadMotion.LEFT),
                new TransitionRule<>(new State("q4"), "2", new State("q5"), "f", HeadMotion.LEFT),
                new TransitionRule<>(new State("q5"), "2", new State("q6"), "f", HeadMotion.LEFT),
                new TransitionRule<>(new State("q6"), "f", new State("qE"), "f", HeadMotion.NONE),
                new TransitionRule<>(new State("q6"), "2", new State("q7"), "2", HeadMotion.LEFT),
                new TransitionRule<>(new State("q7"), "2", new State("q7"), "2", HeadMotion.LEFT),
                new TransitionRule<>(new State("q7"), "1", new State("q7"), "1", HeadMotion.LEFT),
                new TransitionRule<>(new State("q7"), "0", new State("q7"), "0", HeadMotion.LEFT),
                new TransitionRule<>(new State("q7"), "f", new State("qA"), "f", HeadMotion.RIGHT)
        );
        ITransitionFunction<String> transitionFunction = new TransitionFunction<>(rules);
        // intial state q0 = qA
        IState initialState = new State("qA");
        // final states E = {qE}
        Set<IState> finalStates = CollectionUtils.setOf(new State("qE"));

        turingMachine = new TuringMachine<>(states,
                alphabet,
                inputAlphabet,
                blank,
                transitionFunction,
                initialState,
                finalStates);
        return turingMachine;
    }

}