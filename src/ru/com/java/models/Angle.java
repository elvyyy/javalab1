package ru.com.java.models;

public class Angle {
    final public static int RIGHT_ANGLE = 0;
    final public static int OBTUSE_CORNER = 1;
    final public static int SHARP_CORNER = 2;

    public static int getTypeOf(double degrees) {
        if (Math.abs(degrees) > 90) {
            return OBTUSE_CORNER;
        } else if (Math.abs(degrees) == 90) {
            return RIGHT_ANGLE;
        } else {
            return SHARP_CORNER;
        }
    }
}
