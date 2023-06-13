package com.conway.gameoflife;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.canvas.GraphicsContext;

public class GameOfLifeApplication extends Application {

    private static final int MAX_WIDTH = 600;
    private static final int MAX_HEIGHT = 625;
    private static final int CANVAS_HEIGHT = 600;


    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Game of Life");
        MainView mainView = new MainView(MAX_WIDTH, MAX_HEIGHT, CANVAS_HEIGHT);
        Scene scene = new Scene(mainView.getAnchorPane());
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
