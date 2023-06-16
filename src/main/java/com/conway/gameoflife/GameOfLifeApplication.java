package com.conway.gameoflife;

import com.conway.gameoflife.enums.StateOfCell;
import com.conway.gameoflife.enums.StateOfGame;
import com.conway.gameoflife.views.MainView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class GameOfLifeApplication extends Application {

    private static final int MAX_WIDTH = 600;
    private static final int MAX_HEIGHT = 625;
    private static final int CANVAS_HEIGHT = 600;

    private StateOfGame stateOfGame = StateOfGame.PAUSE;

    private GameBoard gameBoard;
    private Thread animationThread;


    @Override
    public void start(Stage primaryStage) throws Exception {


        primaryStage.setTitle("Game of Life");
        MainView mainView = new MainView(MAX_WIDTH, MAX_HEIGHT, CANVAS_HEIGHT);
        Scene scene = new Scene(mainView.getAnchorPane());
        primaryStage.setScene(scene);
        primaryStage.show();

        Board board = new Board(50, mainView.getCanvas());
        board.drawGrid(mainView.getGc(), mainView.getCanvas());
        gameBoard = new GameBoard(board);




        mainView.getCanvas().setOnMouseClicked(mouseEvent -> {
            if(stateOfGame == StateOfGame.RUN){
                animationThread.stop();
            }
            board.whichCellWasClicked(mouseEvent.getX(), mouseEvent.getY()).setState(StateOfCell.ALIVE);
            board.drawGrid(mainView.getGc(), mainView.getCanvas());
        });

        mainView.getReset().setOnMouseClicked(mouseEvent -> {
            stateOfGame = StateOfGame.RESET;

            if(stateOfGame == StateOfGame.RUN){
                animationThread.stop();
            }

            try {
                gameBoard.resetBoard();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            board.drawGrid(mainView.getGc(), mainView.getCanvas());
        });

        mainView.getStep().setOnMouseClicked(mouseEvent -> {
            stateOfGame = StateOfGame.STEP;

            if(stateOfGame == StateOfGame.RUN){
                animationThread.stop();
            }

            try {
                gameBoard.update();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            board.drawGrid(mainView.getGc(), mainView.getCanvas());
        });

        mainView.getRun().setOnMouseClicked(mouseEvent -> {
            stateOfGame = StateOfGame.RUN;

            // it is not allow to call start() method once the stop() method was called
            animationThread = new Thread(() -> {
                try {
                    while (stateOfGame == StateOfGame.RUN) {
                        gameBoard.update();
                        board.drawGrid(mainView.getGc(), mainView.getCanvas());
                        Thread.sleep(500);
                    }
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            });
            animationThread.start();
        });

        mainView.getStop().setOnMouseClicked(mouseEvent -> {
            animationThread.stop();
        });

    }

    public static void main(String[] args) {
        launch(args);
    }
}
