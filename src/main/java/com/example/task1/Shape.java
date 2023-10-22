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
    abstract String toSaveFormat();
    static Color fromHex(String shex)
    {
        //int hex = (int) Long.parseLong(shex.replace("0x",""),16);
        //System.out.print(hex);
        shex = shex.replace("0x","");
        double r = Integer.valueOf(shex.substring(0, 2), 16);
        double g = Integer.valueOf(shex.substring(2, 4), 16);
        double b = Integer.valueOf(shex.substring(4, 6), 16);
        System.out.println(r + " " + g + " " + b);
        return new Color(r/255,g/255,b/255,1);
    }
    public static Shape fromSaveFormat(String str)
    {
        String[] args = str.split(" ");
        Shape res;
        switch (args[0])
        {
            case "line":
                res = new LineShape(fromHex(args[1]),
                        Double.parseDouble(args[2]),
                        Double.parseDouble(args[3]),
                        Double.parseDouble(args[4]));
                break;
            case "angle":
                res = new Angle(fromHex(args[1]),
                        Double.parseDouble(args[2]),
                        Double.parseDouble(args[3]),
                        Double.parseDouble(args[4]),
                        Double.parseDouble(args[5]));
                break;
            case "triangle":
                res = new Triangle(fromHex(args[1]),
                        Double.parseDouble(args[3]),
                        Double.parseDouble(args[4]),
                        Double.parseDouble(args[5]),
                        Double.parseDouble(args[6]));
                res.outline = fromHex(args[2]);
                break;
            case "rectangle":
                res = new Rectangle(fromHex(args[1]),
                        Double.parseDouble(args[3]),
                        Double.parseDouble(args[4]),
                        Double.parseDouble(args[5]),
                        Double.parseDouble(args[6]));
                res.outline = fromHex(args[2]);
                break;
            case "ellipse":
                res = new Ellipse(fromHex(args[1]),
                        Double.parseDouble(args[3]),
                        Double.parseDouble(args[4]),
                        Double.parseDouble(args[5]),
                        Double.parseDouble(args[6]));
                res.outline = fromHex(args[2]);
                break;
            default:
                res = null;
                break;
        }
        return res;
    }
}
