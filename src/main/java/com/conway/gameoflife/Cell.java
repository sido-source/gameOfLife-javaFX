package com.conway.gameoflife;

import com.conway.gameoflife.enums.StateOfCell;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;


//    x1,y1----------x2,y1
//    |-----------------|
//    |-----------------|
//    |-----------------|
//    x1,y1----------x2,y1
// a = distance between x2 - x1 or y2 - y1
public class Cell{


    private Rectangle rectangle;
    private int liveNeighbours = 0;
    private StateOfCell state;

    public Cell(double x, double y, double a) throws Exception {
        if(a<0){
            throw new Exception("a must be greter than 0");
        }else if (x < 0 && y < 0){
            throw new Exception("X and Y must be greater than 0");
        }
        state = StateOfCell.DEAD;
        rectangle = new Rectangle(x,y,a,a);
        new Rectangle(x,y,a,a);
    }

    public int getLiveNeighbours() {
        return liveNeighbours;
    }

    public void setLiveNeighbours(int liveNeighbours) {
        this.liveNeighbours = liveNeighbours;
    }

    public StateOfCell getState() {
        return state;
    }

    public void setState(StateOfCell state) {
        this.state = state;
    }

    public void draw(GraphicsContext gc) {
        // Draw rectangle border
        gc.setStroke(Color.BLACK);
        gc.setLineWidth(1.0);
        gc.strokeRect(rectangle.getX(), rectangle.getY(), rectangle.getWidth(), rectangle.getHeight());
    }

    public boolean areCoordinatesTheSame(Rectangle rectangle) {
        return this.rectangle.getX() == rectangle.getX() &&
                this.rectangle.getY() == rectangle.getY() &&
                this.rectangle.getWidth() == rectangle.getWidth() &&
                this.rectangle.getHeight() == rectangle.getHeight();
    }

    public Rectangle getRectangle() {
        return rectangle;
    }
}
