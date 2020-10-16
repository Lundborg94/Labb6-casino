package com.company;

import java.awt.*;
import java.util.ArrayList;

public class GameMath {
    public static int userTempValue = 0;

    public static ArrayList<String> DiceSixArrayList = new ArrayList<>();
    public static ArrayList<String> DiceTwelveArrayList = new ArrayList<>();
    static double D6() {
        return (int)(Math.random()*((6))+ (double) 1);
    }
    static double D12() {
        return (int)(Math.random()*((12))+ (double) 1);
    }
    static double roulette() {
        return (int)(Math.random()*((36)));
    }

    public static void calculateRouletteResults() {
        if (RouletteBets.userCredits >= RouletteBets.userBet) {
            int rouletteRollResult = (int) roulette();
            String x = Integer.toString(rouletteRollResult);
            PanelsAndFrames.rouletteResultText.setText(x);
            if (rouletteRollResult == 0) {
                PanelsAndFrames.rouletteResultText.setBackground(Color.green);
            } else if (DidRouletteWin.blackNumbers.contains(rouletteRollResult)) {
                PanelsAndFrames.rouletteResultText.setBackground(Color.gray);
            } else {
                PanelsAndFrames.rouletteResultText.setBackground(Color.red);
            }
            RouletteBets.userCredits -= RouletteBets.userBet;
            userTempValue = DidRouletteWin.checkWin(RouletteBets.userBet,rouletteRollResult);
            RouletteBets.userCredits += userTempValue;
            if (userTempValue > RouletteBets.userBet) {
                PanelsAndFrames.gameLogText.setText("You won " + userTempValue + " credits, your new total is: " + RouletteBets.userCredits);
            } else {
                PanelsAndFrames.gameLogText.setText("You lost " + RouletteBets.userBet + " credits, your total is now : " + RouletteBets.userCredits);
            }
            userTempValue = 0;
        } else if (RouletteBets.userCredits > 0) {
            PanelsAndFrames.gameLogText.setText("Insufficent funds, please lower wager");
        } else {
            PanelsAndFrames.gameLogText.setText("Insufficent funds, please refill balance");
        }
        RouletteBets.setAllBetsToFalse();
    }
}
