package de.sikeller.theoretical.turing_machine.machine.head;

public enum HeadMotion {

    LEFT, RIGHT, NONE;

    public void run(IHead head) {
        switch (this) {
            case LEFT:
                head.moveLeft();
                break;
            case RIGHT:
                head.moveRight();
                break;
            case NONE:
        }
    }

}
