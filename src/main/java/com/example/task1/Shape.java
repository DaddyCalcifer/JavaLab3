package com.example.task1;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

abstract class Shape {
    protected Color color, outline;
    protected double x,y, w, h, outline_size;

    abstract double area();

    abstract void draw(GraphicsContext gr);
    abstract void setBorder(Color color, double size);
    public Shape(Color color) {
        System.out.println("Shape constructor called");
        this.color = color;
    }
    public void setColor(Color color) {
        this.color=color;
    }
    @Override
    public String toString() {
        return "";
    }
}
