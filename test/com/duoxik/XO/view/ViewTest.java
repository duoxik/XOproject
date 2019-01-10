package com.duoxik.XO.view;

import com.duoxik.XO.model.Exceptions.InvalidPointException;
import com.duoxik.XO.model.Field;
import com.duoxik.XO.model.Figure;
import org.junit.Test;

import java.awt.*;

public class ViewTest {

    @Test
    public void showField() throws InvalidPointException {

        Field field = new Field(4);
        field.setFigure(new Point(1, 1), Figure.X);
        field.setFigure(new Point(2, 1), Figure.O);
        View view = new View(field);

        view.showField();

    }
}