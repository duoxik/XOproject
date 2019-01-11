package com.duoxik.XO.view;

import com.duoxik.XO.model.Exceptions.InvalidPointException;
import com.duoxik.XO.model.Field;
import com.duoxik.XO.model.Figure;
import com.duoxik.XO.model.Game;
import org.junit.Test;

import java.awt.*;

public class ConsoleViewTest {

    @Test
    public void show() throws InvalidPointException {


        final Field<Figure> field = new Field<>(4);
        field.setFigure(new Point(1, 1), Figure.X);
        field.setFigure(new Point(2, 1), Figure.O);

        final Game<Figure> game = new Game<>(null, field, null);

        ConsoleView consoleView = new ConsoleView();

        consoleView.show(game);

    }
}