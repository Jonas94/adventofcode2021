package adventofcode.day2;

public class Position {
    private int x;
    private int y;
    private int aim;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
        this.aim = 0;
    }

    public Position(int x, int y, int aim) {
        this.x = x;
        this.y = y;
        this.aim = aim;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getAim() {
        return aim;
    }

    public void setAim(int aim) {
        this.aim = aim;
    }

    public void increaseY(int y) {
        this.y = this.y + y;
    }

    public void increaseX(int x) {
        this.x = this.x + x;
    }

    public void increaseAim(int increasement) {
        this.aim = this.aim + increasement;
    }



}
