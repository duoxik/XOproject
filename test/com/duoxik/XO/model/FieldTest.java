package com.duoxik.XO.model;

import com.duoxik.XO.model.Exceptions.AlreadyOccupiedException;
import com.duoxik.XO.model.Exceptions.InvalidPointException;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.*;

public class FieldTest {

    @Test
    public void getSize() throws Exception{

        final Field field = new Field (3);
        final int expectedSize = 3;
        final int actualSize = field.getSize();

        assertEquals(expectedSize, actualSize);
    }

    @Test
    public void setFigure() throws Exception {

        final Field field = new Field (3);
        final Point inputPoint = new Point(0, 0);

        final Figure inputFigure = Figure.O;
        final Figure expectedFigure = inputFigure;

        field.setFigure(inputPoint, inputFigure);
        final Figure actualFigure = field.getFigure(inputPoint);

        assertEquals(expectedFigure, actualFigure);
    }


    @Test
    public void getFigureWhenFigureIsNotSet() throws Exception {

        final Field field = new Field (3);
        final Point inputPoint = new Point(0, 0);
        final Figure actualFigure = field.getFigure(inputPoint);

        assertNull(actualFigure);
    }

    @Test
    public void getFigureWhenCoordinateXIsLessThenZero() throws Exception {

        final Field field = new Field (3);
        final Point inputPoint = new Point(-1, 0);

        try {
            field.getFigure(inputPoint);
            fail();
        } catch (final InvalidPointException e){}
    }

    @Test
    public void getFigureWhenCoordinateYIsLessThenZero() throws Exception {

        final Field field = new Field (3);
        final Point inputPoint = new Point(0, -1);

        try {
            field.getFigure(inputPoint);
            fail();
        } catch (final InvalidPointException e){}
    }

    @Test
    public void getFigureWhenCoordinateXIsMoreThenSizeField() throws Exception {

        final Field field = new Field (3);
        final Point inputPoint = new Point(field.getSize(), 0);

        try {
            field.getFigure(inputPoint);
            fail();
        } catch (final InvalidPointException e){}
    }

    @Test
    public void getFigureWhenCoordinateYIsMoreThenSizeField() throws Exception {

        final Field field = new Field (3);
        final Point inputPoint = new Point(0, field.getSize());

        try {
            field.getFigure(inputPoint);
            fail();
        } catch (final InvalidPointException e){}
    }

    @Test
    public void getFigureWhenCoordinateXAndYIsLessThenZero() throws Exception {

        final Field field = new Field (3);
        final Point inputPoint = new Point(-2, -1);

        try {
            field.getFigure(inputPoint);
            fail();
        } catch (final InvalidPointException e){}
    }

    @Test
    public void getFigureWhenCoordinateXAndYIsMoreThenSizeField() throws Exception {

        final Field field = new Field (3);
        final Point inputPoint = new Point(field.getSize(), field.getSize());

        try {
            field.getFigure(inputPoint);
            fail();
        } catch (final InvalidPointException e){}
    }






}