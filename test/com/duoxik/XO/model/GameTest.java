package com.duoxik.XO.model;

import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.*;

public class GameTest {

    @Test
    public void getName() {

        final String inputGameName = "XO";
        final String expectedGameName = inputGameName;

        final Game game = new Game(null, null, inputGameName);
        final String actualGameName = game.getGameName();

        assertEquals(expectedGameName, actualGameName);
    }

    @Test
    public void getPlayers() {

        final Player[] inputPlayers = new Player[]{new Player("Volodya", Figure.X), new Player("Vlad", Figure.O)};
        final Player[] expectedPlayers = new Player[]{new Player("Volodya", Figure.X), new Player("Vlad", Figure.O)};

        final Game game = new Game(inputPlayers, null, null);
        final Player[] actualPlayers = game.getPlayers();

        assertEquals(expectedPlayers[0].getName(), actualPlayers[0].getName());
        assertEquals(expectedPlayers[0].getFigure(), actualPlayers[0].getFigure());

        assertEquals(expectedPlayers[1].getName(), actualPlayers[1].getName());
        assertEquals(expectedPlayers[1].getFigure(), actualPlayers[1].getFigure());
    }

    @Test
    public void getField() throws Exception {

        final Field inputField = new Field(3);
        inputField.setFigure(new Point(1, 1), Figure.X);
        final Field expectedField = new Field(3);
        expectedField.setFigure(new Point(1, 1), Figure.X);

        final Game game = new Game(null, inputField, null);

        //game.getField().setFigure(new Point(1, 1), Figure.O);

        for (int i = 0; i < inputField.getSize(); i++) {
            for (int i2 = 0; i2 < inputField.getSize(); i2++) {
                assertEquals(expectedField.getFigure(new Point(i, i2)), game.getField().getFigure(new Point(i, i2)));
            }
        }
    }
}