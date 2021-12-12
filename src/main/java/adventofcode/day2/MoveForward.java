package adventofcode.day2;

public class MoveForward implements Command {

    private Position position;
    private int steps;
    private boolean part2;

    public MoveForward(Position position, int steps) {
        this.position = position;
        this.steps = steps;
        this.part2 = false;
    }

    public MoveForward(Position position, int steps, boolean part2) {
        this.position = position;
        this.steps = steps;
        this.part2 = part2;
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

        position.increaseX(steps);

        if (position.getAim() != 0) {
            position.setY(position.getY() + (position.getAim() * steps));
        }
    }
}
