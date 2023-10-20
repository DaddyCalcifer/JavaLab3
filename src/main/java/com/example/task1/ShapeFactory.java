package com.example.task1;

import javafx.scene.paint.Color;

public class ShapeFactory {
    protected Color color, outline;
    protected double x,y, w, h, outline_size;
    public void setValues(Color col, double x, double y, double w, double h)
    {
        color=col;
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
    }
    public Shape createShape(int numberOfSides){
        if(numberOfSides==4){
            return new Rectangle(color,x,y,w,h);
        }
        else if(numberOfSides==3){
            return new Triangle(color,x,y,w,h);
        }
        else if(numberOfSides==2){
            return new Angle(color,x,y,w,h);
        }
        else if (numberOfSides==1){
            return new LineShape(color,x,y,w);
        }
        else if(numberOfSides==0){
            return new Ellipse(color,x,y,w,h);
        }else{
            return null;
        }
    }
}