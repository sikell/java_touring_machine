package de.sikeller.theoretical.turing_machine.machine.transition;

import de.sikeller.theoretical.turing_machine.machine.state.IState;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class TransitionFunction<A> implements ITransitionFunction<A> {

    private final Map<IState, Map<A, ITransitionRule<A>>> rules = new HashMap<>();

    public TransitionFunction(Set<ITransitionRule<A>> rules) {
        rules.forEach(this::addRule);
    }

    @Override
    public ITransition<A> getTransition(IState state, A symbol) {
        return rules.get(state) == null ? null : rules.get(state).get(symbol);
    }


    private void addRule(ITransitionRule<A> newRule) {
        IState newRuleState = newRule.getInputState();
        if (!rules.containsKey(newRuleState)) {
            rules.put(newRuleState, new HashMap<>());
        }
        rules.get(newRuleState).put(newRule.getInputSymbol(), newRule);
    }

}
