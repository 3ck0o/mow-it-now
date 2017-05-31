package com.mow.it.now.utils;

import com.mow.it.now.data.Coordinates;

/**
 * Created by 3ck0o on 5/29/2017.
 */
public class CoordinatesUtils {
    public static Coordinates sum(Coordinates... coordinatesList) {
        Coordinates sum = new Coordinates(0, 0);
        for (Coordinates coordinates : coordinatesList) {
            sum.setX(sum.getX() + coordinates.getX());
            sum.setY(sum.getY() + coordinates.getY());
        }
        return sum;
    }
}
