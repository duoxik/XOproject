package com.duoxik.XO.view;

import com.duoxik.XO.model.Exceptions.InvalidPointException;
import com.duoxik.XO.model.Field;
import com.duoxik.XO.model.Figure;
import org.junit.Test;

import java.awt.*;

public class ConsoleViewTest {

    @Test
    public void show() throws InvalidPointException {

        final Field field = new Field(4);
        field.setFigure(new Point(1, 1), Figure.X);
        field.setFigure(new Point(2, 1), Figure.O);
        ConsoleView consoleView = new ConsoleView(field);

        consoleView.show();

    }
}