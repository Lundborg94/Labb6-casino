package com.company;
import java.util.Arrays;
import java.util.List;

public class RouletteWin extends Main {
    static boolean winOnGreen = false;
    static boolean winOnRed = false;
    static boolean winOnBlack = false;
    static boolean winTopHalf = false;
    static boolean winBottomHalf = false;
    static boolean winOn1st = false;
    static boolean winOn2nd = false;
    static boolean winOn3rd = false;
    static boolean winOnOdd = false;
    static boolean winOnEven = false;

    static Integer[] red = {1,3,5,7,9,12,14,16,18,19,21,23,25,27,30,32,34,36};
    static List<Integer> redNumbers = Arrays.asList(red);
    static Integer[] black = {2,4,6,8,10,11,13,15,17,20,22,24,26,28,29,31,33,35};
    static List<Integer> blackNumbers = Arrays.asList(black);

    public static void didYouWin() {
        if (roulette() == (0.0)) {
            winOnGreen = true;
        }
        if (roulette() <19.0) {
            winTopHalf = true;
        }
        if (roulette() >18.0) {
            winBottomHalf = true;
        }
        if (roulette() <12) {
            winOn1st = true;
        }
        if (roulette() >12 && roulette() <26.0) {
            winOn2nd = true;
        }
        if (roulette() <24) {
            winOn3rd = true;
        }
        if (redNumbers.contains(roulette())) {
            winOnRed = true;
        }
        if (blackNumbers.contains(roulette())) {
            winOnBlack = true;
        }
        if((roulette()%2)==0) {
            winOnEven = true;
        } else {
            winOnOdd = true;
        }
    }

}
