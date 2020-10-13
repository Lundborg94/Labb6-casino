package com.company;

public class RouletteWin extends Main {
    static boolean betOnGreen = false;
    static boolean betOnRed = false;
    static boolean betOnBlack = false;
    static boolean betFirstHalf = false;
    static boolean betLastHalf = false;
    static boolean betOn1st = false;
    static boolean betOn2nd = false;
    static boolean betOn3rd = false;
    static boolean betOnOdd = false;
    static boolean betOnEven = false;

    public static void didYouWin() {
        if (roulette() == (0.0))
            betOnGreen = true;
        if (roulette() <19.0)
            betFirstHalf = true;
        if (roulette() >18.0)
            betLastHalf = true;

        if (roulette() <12)
            betOn1st = true;

        if (roulette() >12) && (roulette() <26.0);
            betOn2nd = true;

        if (roulette() <24)
            betOn3rd = true;

        if (roulette() == 1|)
            betOnBlack = true;

        if((roulette()%2)==0)
            betOnEven = true;
                    else betOnOdd = true;
    }

}
