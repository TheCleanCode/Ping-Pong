package me.cleancode.gameExampleLWJGL.utils;

public class Num {

    public static float min(float value, float min) {
        if(value < min) {
            return min;
        }
        return value;
    }

    public static double min(double value, double min) {
        if(value < min) {
            return min;
        }
        return value;
    }

    public static long min(long value, long min) {
        if(value < min) {
            return min;
        }
        return value;
    }

    public static int min(int value, int min) {
        if(value < min) {
            return min;
        }
        return value;
    }

    public static float max(float value, float max) {
        if(value > max) {
            return max;
        }
        return value;
    }

    public static double max(double value, double max) {
        if(value > max) {
            return max;
        }
        return value;
    }

    public static long max(long value, long max) {
        if(value > max) {
            return max;
        }
        return value;
    }

    public static int max(int value, int max) {
        if(value > max) {
            return max;
        }
        return value;
    }
}
