package adventofcode.day5;

public class Line {
    private int fromX;
    private int toX;
    private int fromY;
    private int toY;
    private boolean diagonal;


    public Line(int fromX, int toX, int fromY, int toY) {
        this.fromX = fromX;
        this.toX = toX;
        this.fromY = fromY;
        this.toY = toY;
    }


    public Line(String[] points) {
        int tempX = 0;
        int tempY = 0;
        String[] firstPoint = points[0].split(",");
        String[] secondPoint = points[1].split(",");
        this.fromX = Integer.parseInt(firstPoint[0]);
        this.toX = Integer.parseInt(secondPoint[0]);
        this.fromY = Integer.parseInt(firstPoint[1]);
        this.toY = Integer.parseInt(secondPoint[1]);

      /*  if (this.fromX > this.toX) {
            tempX = this.fromX;
            fromX = toX;
            toX = tempX;
        }

        if (this.fromY > this.toY) {
            tempY = this.fromY;
            fromY = toY;
            toY = tempY;
        }
*/
    }

    public int getFromX() {
        return fromX;
    }

    public void setFromX(int fromX) {
        this.fromX = fromX;
    }

    public int getToX() {
        return toX;
    }

    public void setToX(int toX) {
        this.toX = toX;
    }

    public int getFromY() {
        return fromY;
    }

    public void setFromY(int fromY) {
        this.fromY = fromY;
    }

    public int getToY() {
        return toY;
    }

    public void setToY(int toY) {
        this.toY = toY;
    }

    public boolean isDiagonal() {
        return diagonal;
    }

    public void setDiagonal(boolean diagonal) {
        this.diagonal = diagonal;
    }

    @Override
    public String toString() {
        return "Line{" +
                "from=" + fromX + ',' + fromY +
                ", to=" + toX + ',' + toY +
                '}';
    }
}
