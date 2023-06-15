package com.conway.gameoflife;


import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Board {

    private int gridSize;



    private Cell[][] boardGame;
    private double scale;
    private final int padding = 2;


    public Board(int gridSize, Canvas canvas) throws Exception {
        this.gridSize = gridSize;
        this.boardGame = new Cell[gridSize][gridSize];
        // it is a square so getWidth = getHeight, only one of these value is needed
        scale = (canvas.getWidth() - 2 * padding)/ gridSize;
        initializeBoard();

    }
    private void initializeBoard() throws Exception {

        for (int i=0; i< gridSize; i++)
            for (int j=0; j< gridSize; j++){
                if(i == 0 && j == 0){
                    boardGame[i][j] = new Cell(padding, padding, padding + scale);
                }else {
                    boardGame[i][j] = new Cell(padding + scale * i, padding + scale * j, scale);
                }


            }
    }

    public Cell whichCellWasClicked(int x, int y) {
        // TODO: Implement logic to determine the clicked cell based on the coordinates (x, y)
        // Iterate over the boardGame and compare the coordinates of each cell with the clicked position
        // Return the matching cell
        return null;
    }


    public void drawGrid(GraphicsContext gc, Canvas canvas) {
        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());

        for (int i = 0; i < gridSize; i++) {
            for (int j = 0; j < gridSize; j++) {
                Cell cell = boardGame[i][j];
                gc.setFill(Color.BLACK);
                gc.fillRect(cell.getRectangle().getX(), cell.getRectangle().getY(), scale, scale);
                if(boardGame[i][j].getState() == StateOfCell.ALIVE){
                    gc.setFill(Color.GREEN);
                    gc.fillRect(cell.getRectangle().getX(), cell.getRectangle().getY(), scale, scale);
                }
                gc.setStroke(Color.GREEN);
                gc.setLineWidth(1.0);
                gc.strokeRect(cell.getRectangle().getX(), cell.getRectangle().getY(), scale, scale);
            }
        }
    }

    public Cell[][] getBoardGame() {
        return boardGame;
    }

    public Cell getCell(int i, int j){
        return boardGame[i-1][j-1];
    }

}
