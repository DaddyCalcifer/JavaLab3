package com.example.task1;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class LineShape extends Shape{
    public LineShape(Color color, double width) {
        super(color);
        w = width;
    }
    public LineShape(Color color, double x, double y, double width) {
        super(color);
        w = width;
        this.x = x;
        this.y = y;
    }
    @Override
    public void draw(GraphicsContext gr) {
        gr.setLineWidth(outline_size);
        gr.setStroke(color);
        gr.strokeLine(x,y,x+w,y);
    }
    @Override
    public double area()
    {
        return 0;
    }
    void setBorder(Color color, double size) {
        outline_size = size;
        outline = color;
    }

    @Override
    public String toString() {
        return "Цвет линии: " + super.color;
    }
}
