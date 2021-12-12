package adventofcode.day2;

public class MoveDown implements Command {

    private Position position;
    private int steps;

    public MoveDown(Position position, int steps) {
        this.position = position;
        this.steps = steps;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public int getSteps() {
        return steps;
    }

    public void setSteps(int steps) {
        this.steps = steps;
    }

    @Override
    public void execute() {
        position.increaseY(steps);
    }
}
