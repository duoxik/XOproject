package com.duoxik.XO.model;

public class Game<F> {

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
}
