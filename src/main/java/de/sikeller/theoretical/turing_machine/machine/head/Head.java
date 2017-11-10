package de.sikeller.theoretical.turing_machine.machine.head;

import de.sikeller.theoretical.turing_machine.tape.BlankSquare;
import de.sikeller.theoretical.turing_machine.tape.ISquare;
import de.sikeller.theoretical.turing_machine.tape.ITape;
import de.sikeller.theoretical.turing_machine.tape.SymbolSquare;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Head implements IHead {

    private int pointer;
    private final String blankSymbol;
    private ITape tape;

    public Head(String blankSymbol, ITape tape) {
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
    public String read() {
        ISquare square = tape.read(pointer);
        if (square.isBlank()) {
            return blankSymbol;
        }
        return square.getSymbol();
    }

    @Override
    public void write(String symbol) {
        ISquare square = blankSymbol.equals(symbol) ? new BlankSquare() : new SymbolSquare(symbol);
        tape.write(pointer, square);
    }

    @Override
    public void useTape(ITape tape) {
        this.tape = tape;
    }

}
