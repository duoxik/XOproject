package com.duoxik.XO.controllers;

import com.duoxik.XO.model.Exceptions.AlreadyOccupiedException;
import com.duoxik.XO.model.Exceptions.InvalidPointException;
import com.duoxik.XO.model.Field;
import com.duoxik.XO.model.Figure;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.*;

public class MoveControllerTest {

    @Test
    public void applyFigure() throws AlreadyOccupiedException, InvalidPointException {

        final Field inputField = new Field(3);
        final Point inputPoint = new Point(1, 1);
        final Figure inputFigure = Figure.X;

        MoveController moveController = new MoveController();
        moveController.applyFigure(inputField, inputFigure, inputPoint);

        try {
            moveController.applyFigure(inputField, inputFigure, inputPoint);
            fail();
        } catch (final AlreadyOccupiedException e) {}
    }
}