package adventofcode.day4;

public class Cell {

    private String value;
    private int column;
    private int row;
    private boolean marked;

    public Cell(String value, int column, int row, boolean marked) {
        this.value = value;
        this.column = column;
        this.row = row;
        this.marked = marked;
    }

    public Cell(String value, int column, int row) {
        this.value = value;
        this.column = column;
        this.row = row;
        this.marked = false;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public boolean isMarked() {
        return marked;
    }

    public void setMarked(boolean marked) {
        this.marked = marked;
    }
}
