package com.conway.gameoflife;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;

public class MainView extends AnchorPane {

    private AnchorPane anchorPane;
    private Canvas canvas;
    private GraphicsContext gc;
    private Button reset;
    private Button stop;
    private Button step;
    private Button run;

    public MainView(int MAX_WIDTH, int MAX_HEIGHT, int CANVAS_HEIGHT) throws Exception {
        anchorPane = new AnchorPane();
        anchorPane.setPrefWidth(MAX_WIDTH);
        anchorPane.setPrefHeight(MAX_HEIGHT);

        canvas = new Canvas(MAX_WIDTH, CANVAS_HEIGHT);
        gc = canvas.getGraphicsContext2D();

        gc.setFill(Color.BLUE);
        gc.setStroke(Color.BLACK);
        gc.setLineWidth(2.0);
        Cell cell = new Cell(3,3,596);
        cell.draw(gc);

        reset = new Button("Reset");
        step = new Button("Step");
        run = new Button("Run");
        stop = new Button("Stop");

        HBox hbox = new HBox(15, reset, step, run, stop);
        anchorPane.getChildren().addAll(canvas, hbox);

        // Set the bottom anchor for the HBox to position it at the bottom
        AnchorPane.setBottomAnchor(hbox, 0.0);
    }

    public AnchorPane getAnchorPane() {
        return anchorPane;
    }

    public Canvas getCanvas() {
        return canvas;
    }

    public GraphicsContext getGc() {
        return gc;
    }

    public Button getReset() {
        return reset;
    }

    public Button getStop() {
        return stop;
    }

    public Button getStep() {
        return step;
    }

    public Button getRun() {
        return run;
    }


}
