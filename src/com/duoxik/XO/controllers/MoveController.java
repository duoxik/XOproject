package com.duoxik.XO.controllers;

import com.duoxik.XO.model.Exceptions.AlreadyOccupiedException;
import com.duoxik.XO.model.Exceptions.InvalidPointException;
import com.duoxik.XO.model.Field;
import com.duoxik.XO.model.Figure;

import java.awt.*;

public class MoveController {


    public void applyFigure(final Field field,
                            final Figure figure,
                            final Point point) throws AlreadyOccupiedException, InvalidPointException {

        if (field.getFigure(point) != null) {
            throw new AlreadyOccupiedException();
        }
        field.setFigure(point, figure);
    }
}
