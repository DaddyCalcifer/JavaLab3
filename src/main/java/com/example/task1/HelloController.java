package com.example.task1;

import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

import java.util.*;

public class HelloController {
    @FXML
    private Label welcomeText;
    @FXML
    Canvas canvas;
    @FXML
    ColorPicker colorPicker, outlineColor;
    @FXML
    TextField widthInput, heightInput, sides_input;

    Shape shape;
    int current_shape = 0;
    Deque<Shape> figures = new ArrayDeque<Shape>();

    @FXML
    protected void onHelloButtonClick() {
        current_shape = 1;
    }
    @FXML
    protected void DrawEx2() {
        current_shape = 0;
    }
    @FXML
    protected void onMouseClicked(MouseEvent event)
    {
        GraphicsContext gc = canvas.getGraphicsContext2D();

        int numberOfSides = Integer.parseInt(sides_input.getText());
        ShapeFactory shapeFactory = new ShapeFactory();
        shapeFactory.setValues(colorPicker.getValue(),event.getX(),event.getY(),
                Double.parseDouble(widthInput.getText()),
                Double.parseDouble(heightInput.getText()));
        Shape shape1 = shapeFactory.createShape(numberOfSides);
        //gc.clearRect(0, 0, 250, 485);
        //shape1.draw(gc);

        shape1.setBorder(outlineColor.getValue(), 5);
        shape1.draw(gc);

        figures.add(shape1);

        System.out.println(figures.toString());
    }
    @FXML
    protected void CancelDraw()
    {
        figures.pollLast();
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
        for (Shape sh:
             figures) {
            sh.draw(gc);
        }
    }


}