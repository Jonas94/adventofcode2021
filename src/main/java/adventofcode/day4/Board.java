package adventofcode.day4;

import java.util.List;
import java.util.stream.Collectors;

public class Board {

    List<Cell> cells;


    public Board() {
    }

    public Board(List<Cell> cells) {
        this.cells = cells;
    }

    public List<Cell> getCells() {
        return cells;
    }

    public void setCells(List<Cell> cells) {
        this.cells = cells;
    }

    public void markNumberOnBoard(String number) {
        for (Cell cell : cells) {
            if (cell.getValue().equalsIgnoreCase(number)) {
                cell.setMarked(true);
                break;
            }
        }

    }

    public List<Cell> getAllCellsOnGivenRow(int row) {
        return cells.stream().filter(cell -> cell.getRow() == row).collect(Collectors.toList());
    }

    public List<Cell> getAllCellsOnGivenColumn(int column) {
        return cells.stream().filter(cell -> cell.getColumn() == column).collect(Collectors.toList());
    }

}
