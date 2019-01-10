package com.duoxik.XO.controllers;

import com.duoxik.XO.model.Exceptions.InvalidPointException;
import com.duoxik.XO.model.Field;
import com.duoxik.XO.model.Figure;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.*;

public class CurrentMoveControllerTest {

    @Test
    public void currentMoveWhenNextMoveIsO() throws InvalidPointException {

        Figure expectedFigure = Figure.O;
        CurrentMoveController currentMoveController = new CurrentMoveController();
        Field inputField = new Field(3);
        inputField.setFigure(new Point(0, 0), Figure.X);
        inputField.setFigure(new Point(0, 1), Figure.O);
        inputField.setFigure(new Point(0, 2), Figure.X);
        Figure actualFigure = currentMoveController.currentMove(inputField);
        assertEquals(expectedFigure, actualFigure);
    }

    @Test
    public void currentMoveWhenNextMoveIsX() throws InvalidPointException {

        Figure expectedFigure = Figure.X;
        CurrentMoveController currentMoveController = new CurrentMoveController();
        Field inputField = new Field(3);
        inputField.setFigure(new Point(0, 0), Figure.X);
        inputField.setFigure(new Point(0, 1), Figure.O);
        inputField.setFigure(new Point(0, 2), Figure.X);
        inputField.setFigure(new Point(1, 0), Figure.X);
        inputField.setFigure(new Point(1, 1), Figure.O);
        inputField.setFigure(new Point(1, 2), Figure.O);
        Figure actualFigure = currentMoveController.currentMove(inputField);
        assertEquals(expectedFigure, actualFigure);
    }

    @Test
    public void currentMoveWhenNextMoveIsNull() throws InvalidPointException {

        CurrentMoveController currentMoveController = new CurrentMoveController();
        Field inputField = new Field(3);
        inputField.setFigure(new Point(0, 0), Figure.X);
        inputField.setFigure(new Point(0, 1), Figure.O);
        inputField.setFigure(new Point(0, 2), Figure.X);
        inputField.setFigure(new Point(1, 0), Figure.X);
        inputField.setFigure(new Point(1, 1), Figure.O);
        inputField.setFigure(new Point(1, 2), Figure.O);
        inputField.setFigure(new Point(2, 0), Figure.X);
        inputField.setFigure(new Point(2, 1), Figure.O);
        inputField.setFigure(new Point(2, 2), Figure.X);
        Figure actualFigure = currentMoveController.currentMove(inputField);
        assertNull(actualFigure);
    }


}