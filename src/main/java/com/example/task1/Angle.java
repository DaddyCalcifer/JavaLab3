package com.example.task1;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Angle extends Shape {

    public Angle(Color color, double width, double height) {
        super(color);
        w = width;
        h = height;
    }
    public Angle(Color color, double x, double y, double width, double height) {
        super(color);
        w = width;
        h = height;
        this.x = x;
        this.y = y;
    }
    @Override
    public void draw(GraphicsContext gr) {
        gr.setLineWidth(outline_size);
        gr.setStroke(color);
        gr.strokeLine(x,y,x+w,y);
        gr.strokeLine(x,y,x,y+h);
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
        return "Цвет угла: " + super.color;
    }
}