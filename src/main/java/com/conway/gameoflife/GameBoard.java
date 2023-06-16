package com.conway.gameoflife;

import com.conway.gameoflife.enums.StateOfCell;

public class GameBoard {
    Board board;

    public GameBoard(Board board){
        this.board = board;
    }

    public int countNeighbors(int row, int column) {
        int count = 0;

        // Check the eight neighboring cells
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                // Skip the current cell
                if (i == 0 && j == 0) {
                    continue;
                }

                // Calculate the indices of the neighboring cell
                int neighborRow = row + i;
                int neighborColumn = column + j;

                // Check if the neighboring cell is within the valid range
                if (isValidCell(neighborRow, neighborColumn)) {
                    // Check if the neighboring cell is alive
                    if (board.getCell(neighborRow, neighborColumn).getState() == StateOfCell.ALIVE) {
                        count++;
                    }
                }
            }
        }

        return count;
    }

    private boolean isValidCell(int neighborRow, int neighborColumn) {
        if (neighborRow >= 0 && neighborColumn >=0 && neighborRow < board.getGridSize() &&
                neighborColumn < board.getGridSize() ){
            return true;
        }
        return false;
    }

    public void update() throws Exception {
        Cell[][] newBoard = new Cell[board.getGridSize()][board.getGridSize()];

        for (int i = 0; i < board.getGridSize(); i++) {
            for (int j = 0; j < board.getGridSize(); j++) {
                Cell cell = board.getCell(i,j);
                int liveNeighbors = countNeighbors(i, j);

                if (cell.getState() == StateOfCell.ALIVE) {
                    if (liveNeighbors < 2 || liveNeighbors > 3) {
                        newBoard[i][j] = new Cell(cell.getRectangle().getX(), cell.getRectangle().getY(), board.getScale());
                    } else {
                        newBoard[i][j] = cell;
                        newBoard[i][j].setState(StateOfCell.ALIVE);
                    }
                } else {
                    // Apply Game of Life rules for a dead cell
                    if (liveNeighbors == 3) {
                        newBoard[i][j] = new Cell(cell.getRectangle().getX(), cell.getRectangle().getY(), board.getScale());
                        newBoard[i][j].setState(StateOfCell.ALIVE);
                    } else {
                        newBoard[i][j] = cell;
                    }
                }
            }
        }

        board.setBoardGame(newBoard);
    }

    public void resetBoard() throws Exception {
        board.initializeBoard();
    }

}
