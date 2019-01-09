package com.duoxik.XO.model;

import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.*;

public class FieldTest {

    @Test
    public void getSize() {

        final Field field = new Field ();
        final int expectedSize = 3;
        final int actualSize = field.getSize();

        assertEquals(expectedSize, actualSize);
    }

    @Test
    public void setFigure() {

        final Field field = new Field ();
        final Point inputPoint = new Point(0, 0);

        final Figure inputFigure = Figure.O;
        final Figure expectedFigure = inputFigure;

        field.setFigure(inputPoint, inputFigure);
        final Figure actualFigure = field.getFigure(inputPoint);

        assertEquals(expectedFigure, actualFigure);
    }
}