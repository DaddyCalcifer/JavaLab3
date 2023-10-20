package com.example.task1;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Triangle extends Shape{
    public Triangle(Color color, double width, double height) {
        super(color);
        w = width;
        h = height;
    }
    public Triangle(Color color, double x, double y, double width, double height) {
        super(color);
        w = width;
        h = height;
        this.x = x;
        this.y = y;
    }
    @Override
    public void draw(GraphicsContext gr) {
        gr.setLineWidth(outline_size);
        gr.setStroke(outline);
        gr.setFill(color);
        gr.fillPolygon(new double[]{x,x,x+w},new double[]{y,y+h,y},3);
        gr.strokePolygon(new double[]{x,x,x+w},new double[]{y,y+h,y},3);
    }
    @Override
    public double area()
    {
        return (w*h)/2;
    }
    void setBorder(Color color, double size) {
        outline_size = size;
        outline = color;
    }

    @Override
    public String toString() {
        return "Цвет треугольника: " + super.color +  ", а площадь: " + area();
    }
}
