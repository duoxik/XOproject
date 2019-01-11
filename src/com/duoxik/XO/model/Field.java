package com.duoxik.XO.model;

import com.duoxik.XO.model.Exceptions.InvalidPointException;

import java.awt.*;

public class Field<T> {


    private static final int MIN_COORDINATE = 0;

    private final T[][] field;
    private final int fieldSize;

    public Field(int fieldSize) {
        this.fieldSize = fieldSize;
        field = (T[][])new Object[fieldSize][fieldSize];
    }

    public int getSize() {
        return fieldSize;
    }

    public T getFigure(final Point point) throws InvalidPointException {
        if (!checkPoint(point)) {
            throw new InvalidPointException();
        }
        return field[point.x][point.y];
    }

    public void setFigure(final Point point, final T figure) throws InvalidPointException {
        if (!checkPoint(point)) {
            throw new InvalidPointException();
        }

        field[point.x][point.y] = figure;
    }

    public boolean checkPoint(final Point point) {
        return checkCoordinate(point.x, field.length    ) && checkCoordinate(point.y, field[point.x].length);
    }


    public boolean checkCoordinate(final int coordinate, final int maxCoordinate) {
        return coordinate >= MIN_COORDINATE && coordinate < maxCoordinate;
    }

}
