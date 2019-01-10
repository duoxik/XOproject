package com.duoxik.XO.controllers;

import com.duoxik.XO.model.Exceptions.InvalidPointException;
import com.duoxik.XO.model.Field;
import com.duoxik.XO.model.Figure;

import java.awt.*;

public class CurrentMoveController {

    public Figure currentMove(final Field field) throws InvalidPointException {

        int countFigure = 0;

        for (int i = 0; i < field.getSize(); i++) {
            countFigure += countFiguresInRow(field, i);
        }

        if (countFigure == field.getSize() * field.getSize())
            return null;

        if (countFigure % 2 == 0)
            return Figure.X;

        return Figure.O;
    }

    private int countFiguresInRow(final Field field, final int row) throws InvalidPointException {
        int countFigure = 0;

        for(int i = 0; i < field.getSize(); i++) {
            if (field.getFigure(new Point(row, i)) != null)
                countFigure++;
        }

        return countFigure;
    }

}
