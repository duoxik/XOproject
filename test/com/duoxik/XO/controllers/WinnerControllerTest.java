package com.duoxik.XO.controllers;

import com.duoxik.XO.model.Exceptions.InvalidPointException;
import com.duoxik.XO.model.Field;
import com.duoxik.XO.model.Figure;
import com.duoxik.XO.view.View;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.*;

public class WinnerControllerTest {

    @Test
    public void getWinnerWhenFieldIsEmpty() throws InvalidPointException {

        Field inputField = new Field(4);
        WinnerController testWinnerController = new WinnerController();
        Figure actualFigure = testWinnerController.getWinner(inputField);
        System.out.print("Winner null: ");
        View view = new View(inputField);
        view.showField();
        assertNull(actualFigure);
    }

    @Test
    public void getWinnerWhenWinnerIsXLine() throws InvalidPointException {

        Figure expectedFigure = Figure.X;
        for (int i = 0; i < 4; i++) {
            WinnerController testWinnerController = new WinnerController();
            Field inputField = new Field(4);
            inputField.setFigure(new Point(i, 0), Figure.X);
            inputField.setFigure(new Point(i, 1), Figure.X);
            inputField.setFigure(new Point(i, 2), Figure.X);
            inputField.setFigure(new Point(i, 3), Figure.X);
            Figure actualFigure = testWinnerController.getWinner(inputField);
            assertEquals(expectedFigure, actualFigure);
        }
    }

    @Test
    public void getWinnerWhenWinnerIsNullLine() throws InvalidPointException {

        for (int i = 0; i < 4; i++) {
            WinnerController testWinnerController = new WinnerController();
            Field inputField = new Field(4);
            inputField.setFigure(new Point(i, 0), Figure.X);
            inputField.setFigure(new Point(i, 1), Figure.O);
            inputField.setFigure(new Point(i, 2), Figure.X);
            inputField.setFigure(new Point(i, 3), Figure.X);
            Figure actualFigure = testWinnerController.getWinner(inputField);
            assertNull(actualFigure);
        }
    }

    @Test
    public void getWinnerWhenWinnerIsXColumn() throws InvalidPointException {

        Figure expectedFigure = Figure.X;
        for (int i = 0; i < 4; i++) {
            WinnerController testWinnerController = new WinnerController();
            Field inputField = new Field(4);
            inputField.setFigure(new Point(0, i), Figure.X);
            inputField.setFigure(new Point(1, i), Figure.X);
            inputField.setFigure(new Point(2, i), Figure.X);
            inputField.setFigure(new Point(3, i), Figure.X);
            Figure actualFigure = testWinnerController.getWinner(inputField);
            assertEquals(expectedFigure, actualFigure);
        }
    }

    @Test
    public void getWinnerWhenWinnerIsNullColumn() throws InvalidPointException {

        for (int i = 0; i < 4; i++) {
            WinnerController testWinnerController = new WinnerController();
            Field inputField = new Field(4);
            inputField.setFigure(new Point(0, i), Figure.X);
            inputField.setFigure(new Point(1, i), Figure.X);
            inputField.setFigure(new Point(2, i), Figure.O);
            inputField.setFigure(new Point(3, i), Figure.X);
            Figure actualFigure = testWinnerController.getWinner(inputField);
            assertNull(actualFigure);
        }
    }

    @Test
    public void getWinnerWhenWinnerIsODiagonal() throws InvalidPointException {

        Figure expectedFigure = Figure.O;
        Field inputField = new Field(4);
        inputField.setFigure(new Point(0, 0), Figure.O);
        inputField.setFigure(new Point(1, 1), Figure.O);
        inputField.setFigure(new Point(2, 2), Figure.O);
        inputField.setFigure(new Point(3, 3), Figure.O);
        WinnerController testWinnerController = new WinnerController();
        Figure actualFigure = testWinnerController.getWinner(inputField);
        assertEquals(expectedFigure, actualFigure);
    }

    @Test
    public void getWinnerWhenWinnerIsNullDiagonal() throws InvalidPointException {

        Field inputField = new Field(4);
        inputField.setFigure(new Point(0, 0), Figure.O);
        inputField.setFigure(new Point(1, 1), Figure.O);
        inputField.setFigure(new Point(2, 2), Figure.X);
        inputField.setFigure(new Point(3, 3), Figure.O);
        WinnerController testWinnerController = new WinnerController();
        Figure actualFigure = testWinnerController.getWinner(inputField);
        assertNull(actualFigure);
    }

    @Test
    public void getWinnerWhenWinnerIsXDiagonal2() throws InvalidPointException {

        Figure expectedFigure = Figure.X;
        Field inputField = new Field(4);
        inputField.setFigure(new Point(3, 0), Figure.X);
        inputField.setFigure(new Point(2, 1), Figure.X);
        inputField.setFigure(new Point(1, 2), Figure.X);
        inputField.setFigure(new Point(0, 3), Figure.X);
        WinnerController testWinnerController = new WinnerController();
        Figure actualFigure = testWinnerController.getWinner(inputField);
        assertEquals(expectedFigure, actualFigure);
    }

    @Test
    public void getWinnerWhenWinnerIsNullDiagonal2() throws InvalidPointException {

        Field inputField = new Field(4);
        inputField.setFigure(new Point(3, 0), Figure.X);
        inputField.setFigure(new Point(2, 1), Figure.O);
        inputField.setFigure(new Point(1, 2), Figure.X);
        inputField.setFigure(new Point(0, 3), Figure.X);
        WinnerController testWinnerController = new WinnerController();
        Figure actualFigure = testWinnerController.getWinner(inputField);
        assertNull( actualFigure);
    }


}