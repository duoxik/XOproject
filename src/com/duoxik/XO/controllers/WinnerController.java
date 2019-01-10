package com.duoxik.XO.controllers;

import com.duoxik.XO.model.Exceptions.InvalidPointException;
import com.duoxik.XO.model.Field;
import com.duoxik.XO.model.Figure;

import java.awt.*;

public class WinnerController {

    public Figure getWinner(final Field field) {

        try {
            for (int i = 0; i < field.getSize(); i++) {
                if (check(field, new Point(i, 0), p -> new Point(p.x, p.y + 1))) {
                    return field.getFigure(new Point(i, 0));
                }
            }

            for (int i = 0; i < field.getSize(); i++) {
                if (check(field, new Point(0, i), p -> new Point(p.x + 1, p.y))) {
                    return field.getFigure(new Point(0, i));
                }
            }


            if (check(field, new Point(0, 0), p -> new Point(p.x + 1, p.y + 1))) {
                return field.getFigure(new Point(0, 0));
            }

            if (check(field, new Point(0, field.getSize() - 1), p -> new Point(p.x + 1, p.y - 1))) {

                return field.getFigure(new Point(0, field.getSize() - 1));
            }
        }
        catch (InvalidPointException e) {
            e.printStackTrace();
        }

        return null;
    }

    private boolean check(final Field field,
                          final Point currentPoint,
                          final IPointGenerator pointGenerator ) {
        final Figure currentFigure;
        final Figure nextFigure;
        final Point nextPoint = pointGenerator.next(currentPoint);

        try {
            currentFigure = field.getFigure(currentPoint);
            if (currentFigure == null) return false;
            nextFigure = field.getFigure(nextPoint);

        } catch (final InvalidPointException e) {
            return true;
        }



        if (currentFigure != nextFigure) return false;

        return check(field, nextPoint, pointGenerator);
    }

    private interface IPointGenerator {

        Point next(final Point point);
    }

}
