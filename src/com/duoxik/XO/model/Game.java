package com.duoxik.XO.model;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class Game<F> implements Iterable<Player>{

    private final String gameName;

    private final Player[] players;

    private final Field<F> field;

    public Game(final Player[] players, final Field<F> field, final String gameName) {
        this.gameName = gameName;
        this.players = players;
        this.field = field;
    }

    public String getGameName() {
        return gameName;
    }

    public Player[] getPlayers() {
        return players;
    }

    public Field<F> getField() {
        return field;
    }

    @Override
    public Iterator<Player> iterator() {
        return new PlayerIterator();
    }

    private class PlayerIterator implements Iterator<Player>{

        private int index = 0;

        @Override
        public boolean hasNext() {
            return Game.this.players.length > index;
        }

        @Override
        public Player next() {
            if (!hasNext()) throw new NoSuchElementException();
            return Game.this.players[index++];
        }
    }

}
