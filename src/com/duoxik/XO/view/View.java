package com.duoxik.XO.view;

import com.duoxik.XO.model.Exceptions.InvalidPointException;
import com.duoxik.XO.model.Field;

import java.awt.*;

public class View {

    private final Field field;
    private final String separationLine;


    public View(Field field) {
        this.field = field;

        String tempString = "~";
        for (int i = 0; i < field.getSize(); i++) {
            tempString = tempString.concat("~~~~");
        }

        this.separationLine = tempString;
    }

    public void showField() throws InvalidPointException {
        System.out.print("\n");
        for (int i = 0; i < field.getSize(); i++) {
            System.out.println(separationLine);
            for (int i2 = 0; i2 < field.getSize(); i2++) {

                System.out.print("| ");
                if (field.getFigure(new Point(i, i2)) != null) {
                    System.out.print(field.getFigure(new Point(i, i2)).toString() + " ");
                } else {
                    System.out.print("  ");
                }

            }
            System.out.println("|");
        }
        System.out.println(separationLine);
    }
}
