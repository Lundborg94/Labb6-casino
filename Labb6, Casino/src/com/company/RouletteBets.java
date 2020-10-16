package com.company;

 class RouletteBets {
    static boolean BetOnGreen = false;
    static boolean BetOnBlack = false;
    static boolean BetOnRed = false;
    static boolean BetOnOdds = false;
    static boolean BetOnEvens = false;
    static boolean BetOnTopHalf = false;
    static boolean BetOnBottomHalf = false;
    static boolean BetOn1st = false;
    static boolean BetOn2nd = false;
    static boolean BetOn3rd = false;
     public static int userCredits = 500;
     public static int userBet = 0;

    static void setAllBetsToFalse() {
        BetOnGreen = false;
        BetOnBlack = false;
        BetOnRed = false;
        BetOnOdds = false;
        BetOnEvens = false;
        BetOnTopHalf = false;
        BetOnBottomHalf = false;
        BetOn1st = false;
        BetOn2nd = false;
        BetOn3rd = false;
        PanelsAndFrames.resetAllTextFields();
    }


}
