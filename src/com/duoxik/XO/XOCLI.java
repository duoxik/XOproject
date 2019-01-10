package com.duoxik.XO;

import com.duoxik.XO.model.Field;
import com.duoxik.XO.model.Figure;
import com.duoxik.XO.model.Game;
import com.duoxik.XO.model.Player;
import com.duoxik.XO.view.ConsoleView;

public class XOCLI {

    public static void main  (final String[] args) {

        final Player[] players = new Player[2];
        players[0] = new Player("Vlad", Figure.X);
        players[1] = new Player("Oleg", Figure.O);

        final Game gameXO = new Game(players, new Field(3), "XO");

        final ConsoleView consoleView = new ConsoleView();
        consoleView.show(gameXO);

        while (consoleView.move(gameXO)) {
            consoleView.show(gameXO);

        }
    }

}
