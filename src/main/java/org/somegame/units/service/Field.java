package org.somegame.units.service;

public class Field {

    private static int xSize = 9;
    private static int ySize = 9;
    private static int aCount = 0; // команда а
    private static int bCount = 0; // команда b

//    public Field (int size) {
//        xSize = ySize = size;
//        aCount = bCount = 0;
//    }

    /** может потом будут НЕ квадратные поля */
    public static void setSize (int x, int y) {
        xSize = x;
        ySize = y;
    }
    public static void setSize (int size) {
        setSize(size,size);
    }

    /** может потом будут НЕ квадратные поля */
    public static int getSize () {
        return xSize;
    }

    public static Position nextPosition(boolean side) {
        if (side) {
            return new Position(aCount++, 0);
        }
        return new Position(bCount++, ySize);
    }


}
