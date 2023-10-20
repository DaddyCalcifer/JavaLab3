package com.example.task1;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Ellipse extends Shape
{

    public Ellipse(Color color, double width, double height) {
        super(color);
        w = width;
        h = height;
        x = y = 0;
    }
    public Ellipse(Color color, double x, double y, double width, double height) {
        super(color);
        w = width;
        h = height;
        this.x = x;
        this.y = y;
    }
    @Override
    public void setBorder(Color color, double size)
    {
        this.outline = color;
        outline_size = size;
    }

    @Override
    double area() {
        if (w < 0 || h < 0)
            return -1;
        float res = (float)(3.14 * w * h) / 4;
        return res;
    }

    @Override
    void draw(GraphicsContext gr) {
        gr.setFill(color);
        gr.fillOval(x,y,w,h);
        if(outline_size != 0)
        {
            gr.setStroke(outline);
            gr.setLineWidth(outline_size);
            gr.strokeOval(x,y,w,h);
        }
    }


    @Override
    public String toString() {
        return "Цвет эллипса: " + super.color +  ", а площадь: " + area();
    }
}
