package adventofcode.day4;

import adventofcode.utils.FileHandler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Day4 {

    List<Board> boards;
    List<String> numbersToBeDrawn;

    public long part1(String inputFile) {
        boards = new ArrayList<>();
        numbersToBeDrawn = new ArrayList<>();

        parseFileIntoNumbersAndBoards(inputFile);

        for (String numberToDraw : numbersToBeDrawn) {

            for (Board board : boards) {
                board.markNumberOnBoard(numberToDraw);
            }

            Optional<Board> optionalWinner = checkForWinner(boards);
            if (optionalWinner.isPresent()) {
                Board board = optionalWinner.get();
                return (long) findSumOfUnmarkedNumbersOnBoard(board) * Integer.parseInt(numberToDraw);
            }
        }
        return 0;
    }

    private int findSumOfUnmarkedNumbersOnBoard(Board board) {
        var wrapper = new Object() {
            int score = 0;
        };

        List<Cell> unmarkedCells = board.getCells().stream().filter(cell -> !cell.isMarked()).collect(Collectors.toList());
        unmarkedCells.forEach(unmarkedCell -> wrapper.score += Integer.parseInt(unmarkedCell.getValue()));
        return wrapper.score;
    }

    public List<Board> checkForWinners(List<Board> boardsWithoutWin) {
        List<Board> winnerBoards = new ArrayList<>();
        for (Board board : boardsWithoutWin) {
            for (int i = 0; i < 5; i++) {
                boolean wonRow = board.getAllCellsOnGivenRow(i).stream().allMatch(cell -> cell.isMarked());
                boolean wonColumn = board.getAllCellsOnGivenColumn(i).stream().allMatch(cell -> cell.isMarked());
                if (wonRow || wonColumn) {
                    winnerBoards.add(board);
                }
            }
        }

        return winnerBoards;
    }

    public Optional<Board> checkForWinner(List<Board> boards) {
        for (Board board : boards) {
            for (int i = 0; i < 5; i++) {
                boolean wonRow = board.getAllCellsOnGivenRow(i).stream().allMatch(cell -> cell.isMarked());
                boolean wonColumn = board.getAllCellsOnGivenColumn(i).stream().allMatch(cell -> cell.isMarked());
                if (wonRow || wonColumn) {
                    return Optional.of(board);
                }
            }
        }
        return Optional.empty();
    }

    public void parseFileIntoNumbersAndBoards(String inputFile) {
        FileHandler fileHandler = new FileHandler();
        List<String> inputStrings = fileHandler.readFile(getClass().getClassLoader().getResource(inputFile).getFile());
        numbersToBeDrawn.addAll(Arrays.stream(inputStrings.get(0).split(",")).toList());

        for (int i = 2; i < inputStrings.size(); i = i + 6) {
            if (i > inputStrings.size() + 5) break;

            List<Cell> boardCells = new ArrayList<>();

            for (int j = 0; j < 5; j++) {
                String currentRow = inputStrings.get(i + j);
                String trimmedRow = currentRow.trim().replaceAll(" +", " ");

                String[] cellStrings = trimmedRow.split(" ");

                for (int k = 0; k < 5; k++) {
                    Cell cell = new Cell(cellStrings[k], k, j);
                    boardCells.add(cell);
                }
            }
            Board board = new Board(boardCells);
            boards.add(board);
        }
    }

    public long part2(String inputFile) {
        boards = new ArrayList<>();
        numbersToBeDrawn = new ArrayList<>();
        Board lastBoard = new Board();
        parseFileIntoNumbersAndBoards(inputFile);

        List<Board> boardsWithoutWin = new ArrayList<>(boards);

        for (String numberToDraw : numbersToBeDrawn) {

            for (Board board : boards) {
                board.markNumberOnBoard(numberToDraw);
            }

            boardsWithoutWin.removeAll(checkForWinners(boardsWithoutWin));

            if (boardsWithoutWin.size() == 1) {
                lastBoard = boardsWithoutWin.get(0);
            }

            if (boardsWithoutWin.isEmpty()) {
                return (long) findSumOfUnmarkedNumbersOnBoard(lastBoard) * Integer.parseInt(numberToDraw);

            }
        }
        return 0;
    }


}
