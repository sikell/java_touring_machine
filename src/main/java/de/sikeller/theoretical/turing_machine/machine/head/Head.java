package de.sikeller.theoretical.turing_machine.machine.head;

import de.sikeller.theoretical.turing_machine.tape.BlankSquare;
import de.sikeller.theoretical.turing_machine.tape.ISquare;
import de.sikeller.theoretical.turing_machine.tape.ITape;
import de.sikeller.theoretical.turing_machine.tape.SymbolSquare;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Head<A> implements IHead<A> {

    private int pointer;
    private final A blankSymbol;
    private ITape<A> tape;

    public Head(A blankSymbol, ITape<A> tape) {
        this(0, blankSymbol, tape);
    }

    @Override
    public void moveRight() {
        pointer++;
    }

    @Override
    public void moveLeft() {
        --pointer;
    }

    @Override
    public A read() {
        ISquare<A> square = tape.read(pointer);
        if (square.isBlank()) {
            return blankSymbol;
        }
        return square.getSymbol();
    }

    @Override
    public void write(A symbol) {
        ISquare<A> square = blankSymbol.equals(symbol) ? new BlankSquare() : new SymbolSquare<>(symbol);
        tape.write(pointer, square);
    }

    @Override
    public void useTape(ITape<A> tape) {
        this.tape = tape;
    }

}
