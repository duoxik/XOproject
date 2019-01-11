package com.duoxik.XO.view;

import com.duoxik.XO.controllers.CurrentMoveController;
import com.duoxik.XO.controllers.MoveController;
import com.duoxik.XO.controllers.WinnerController;
import com.duoxik.XO.model.Exceptions.AlreadyOccupiedException;
import com.duoxik.XO.model.Exceptions.InvalidPointException;
import com.duoxik.XO.model.Field;
import com.duoxik.XO.model.Figure;
import com.duoxik.XO.model.Game;

import java.awt.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ConsoleView {

    private final CurrentMoveController currentMoveController = new CurrentMoveController();

    private final WinnerController winnerController = new WinnerController();

    private final MoveController moveController = new MoveController();

    public void show(final Game<Figure> game) {

        final Field<Figure> field = game.getField();

        System.out.format("Game name: %s\n", game.getGameName());

        for (int i = 0; i < field.getSize(); i++) {
            printSeparator(field.getSize());
            printLine(field, i);
        }

        printSeparator(field.getSize());
    }

    public boolean move(final Game<Figure> game) {

        final Field<Figure> field = game.getField();

        final Figure winner = winnerController.getWinner(field);
        if (winner != null) {
            System.out.format("Winner is: %s", winner);
            return false;
        }

        final Figure currentFigure = currentMoveController.currentMove(field);
        if (currentFigure == null) {
            System.out.print("No winner and no moves left");
            return false;
        }

        System.out.format("Please enter move point for %s\n", currentFigure);
        final Point point = askPoint();

        try {
            moveController.applyFigure(field, currentFigure, point);
        } catch (AlreadyOccupiedException | InvalidPointException e) {
            System.out.println("Point is invalid!!!");
        }

        return true;
    }

    private Point askPoint() {
        return new Point(askCoordinate("x") - 1, askCoordinate("y") - 1);
    }

    private int askCoordinate (final String coordinateName) {
        System.out.format("Please input %s:", coordinateName);
        final Scanner in = new Scanner(System.in);
        try {
            return in.nextInt();
        } catch (final InputMismatchException e) {
            System.out.println("Mismatch coordinate!!!");
            return askCoordinate(coordinateName);
        }
    }

    private void printLine(final Field<Figure> field, final int row) {
        for (int i = 0; i < field.getSize(); i++) {
            System.out.print("| ");

            try {
                final Figure figure = field.getFigure(new Point(row, i));
                System.out.print(figure != null ? figure + " " : "  ");
            } catch (InvalidPointException e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }
        }
        System.out.println("|");
    }

    private void printSeparator(int fieldSize) {

        String separationString = "~";
        for (int i = 0; i < fieldSize; i++) {
            separationString = separationString.concat("~~~~");
        }

        System.out.println(separationString);
    }

}
