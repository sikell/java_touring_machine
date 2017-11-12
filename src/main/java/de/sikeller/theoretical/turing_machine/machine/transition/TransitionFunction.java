package de.sikeller.theoretical.turing_machine.machine.transition;

import de.sikeller.theoretical.turing_machine.machine.state.IState;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class TransitionFunction implements ITransitionFunction {

    private Map<IState, Map<String, ITransitionRule>> rules = new HashMap<>();

    public TransitionFunction(Set<ITransitionRule> rules) {
        rules.forEach(this::addRule);
    }

    @Override
    public ITransition getTransition(IState state, String symbol) {
        return rules.get(state).get(symbol);
    }


    private void addRule(ITransitionRule newRule) {
        IState newRuleState = newRule.getInputState();
        if (!rules.containsKey(newRuleState)) {
            rules.put(newRuleState, new HashMap<>());
        }
        rules.get(newRuleState).put(newRule.getInputSymbol(), newRule);
    }

}
