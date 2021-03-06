package com.company;

import javax.swing.*;
import java.awt.*;
import java.util.Collections;


class PanelsAndFrames {
    private static JPasswordField passwordTextField;
    private static JLabel loginMessage;
    private static JFrame loginFrame;
    private static JTextField diceSixResult;
    private static JTextField diceTwelveResult;
    private static JTextField savedDiceTextField6;
    private static JTextField savedDiceTextField12;
    public static JTextField rouletteResultText;
    public static JTextField betOnRedText;
    public static JTextField betOnBlackText;
    public static JTextField betOnGreenText;
    public static JTextField betOnOddsText;
    public static JTextField betOnEvensText;
    public static JTextField betOnTopHalfText;
    public static JTextField betOnBottomHalfText;
    public static JTextField betOn1stText;
    public static JTextField betOn2ndText;
    public static JTextField betOn3rdText;
    public static JTextField gameLogText;
    public static JTextField currentWagerText;

    public static void getMediumPanelsAndFrames(JPanel panel, JFrame frame) {
        frame.setVisible(true);
        frame.setSize(525,550);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.add(panel);
        panel.setLayout(null);
        panel.setBackground(Color.getHSBColor(0,20,202));
    }

    public static void getSmallPanelsAndFrames(JPanel panel, JFrame frame) {
        frame.setVisible(true);
        frame.setSize(350,175);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.add(panel);
        panel.setLayout(null);
        panel.setBackground(Color.getHSBColor(0,20,202));
    }

    public static void StartLoginFrame() {

        JPanel loginPanel = new JPanel();
        loginFrame = new JFrame("Casino Royale Login");
        PanelsAndFrames.getSmallPanelsAndFrames(loginPanel, loginFrame);
        //=== Login Frame/Panel^ ===//

        JLabel usernameLabel = new JLabel("Username:");
        usernameLabel.setBounds (10,20,80,25);
        loginPanel.add(usernameLabel);
        JTextField usernameTextField = new JTextField(20);
        usernameTextField.setBounds(100,20,165,25);
        loginPanel.add(usernameTextField);
        //=== Username^ ===//

        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds (10,50,80,25);
        loginPanel.add(passwordLabel);
        passwordTextField = new JPasswordField(20);
        passwordTextField.setBounds(100,50,165,25);
        loginPanel.add(passwordTextField);
        //=== Password^ ===//

        loginMessage = new JLabel("");
        loginMessage.setBounds(100,80,300,25);
        loginPanel.add(loginMessage);
        //=== Login Message^ ===//

        JButton loginButton = new JButton("Login");
        loginButton.setBounds(10,90,80,25);
        loginPanel.add(loginButton);
        //=== LoginButton^ ===//

        loginButton.addActionListener(e1 -> {
            String userName = usernameTextField.getText();
            String passWord = passwordTextField.getText();
            if(userName.equals("") && passWord.equals("")) {
                loginFrame.setVisible(false);
                StartLobby();
            }
            else {
                loginMessage.setText("Wrong username or password, try again");
            }
        });
    }
    public static void StartLobby() {
        JPanel choicePanel = new JPanel();
        JFrame choiceFrame = new JFrame("Casino Royale");
        PanelsAndFrames.getSmallPanelsAndFrames(choicePanel, choiceFrame);
        //=== Choice Frame+Panel^ ===//

        JButton rouletteButton = new JButton("Roulette");
        JButton diceButton = new JButton("Dice 6 & 12");
        rouletteButton.setBounds(25,50,125,40);
        diceButton.setBounds(175,50,125,40);
        choicePanel.add(rouletteButton);
        choicePanel.add(diceButton);
        //=== Roulette/Dice Buttons^ ===//

        rouletteButton.addActionListener(e1 -> {
            choiceFrame.setVisible(false);
            StartRoulette();
        });

        diceButton.addActionListener(e2 -> {
            choiceFrame.setVisible(false);
            startDice();
        });
    }

    public static void startDice() {
        JPanel dicePanel = new JPanel();
        JFrame diceFrame = new JFrame("Dice");
        PanelsAndFrames.getMediumPanelsAndFrames(dicePanel, diceFrame);
        //=== Dicer Frame+Panel^ ===//

        JButton rollDiceSix = new JButton("Roll 1-6");
        rollDiceSix.setBounds(15,30,100,40);
        diceSixResult = new JTextField(20);
        diceSixResult.setBounds(155,30,100,40);
        dicePanel.add(diceSixResult);
        dicePanel.add(rollDiceSix);
        rollDiceSix.addActionListener(e1 -> {

            String x = Integer.toString((int) GameMath.D6());
            diceSixResult.setText(x);
            GameMath.DiceSixArrayList.add(x);
        });
        //=== Dice 1-6^ ===//

        JButton rollDiceTwelve = new JButton("Roll 1-12");
        rollDiceTwelve.setBounds(15,100,100,40);
        diceTwelveResult = new JTextField(20);
        diceTwelveResult.setBounds(155,100,100,40);
        dicePanel.add(diceTwelveResult);
        dicePanel.add(rollDiceTwelve);
        rollDiceTwelve.addActionListener(e2 -> {

            String x = Integer.toString((int) GameMath.D12());
            diceTwelveResult.setText(x);
            GameMath.DiceTwelveArrayList.add(x);
        });
        //=== Dice 1-12^ ===//

        JButton printSavedButton = new JButton("Print saved rolls");
        printSavedButton.setBounds(15,187,145,40);
        savedDiceTextField6 = new JTextField(100);
        savedDiceTextField6.setBounds(175,167,250,40);
        dicePanel.add(savedDiceTextField6);
        savedDiceTextField12 = new JTextField(100);
        savedDiceTextField12.setBounds(175,204,250,40);
        dicePanel.add(savedDiceTextField12);
        dicePanel.add(printSavedButton);
        savedDiceTextField6.setText("(D6) :");
        savedDiceTextField12.setText("(D12):");
        printSavedButton.addActionListener(e3 -> {

            Collections.sort(GameMath.DiceSixArrayList);
            Collections.sort(GameMath.DiceTwelveArrayList);
            String x = GameMath.DiceSixArrayList.toString();
            String y = GameMath.DiceTwelveArrayList.toString();
            savedDiceTextField6.setText("(D6) :  " + x);
            savedDiceTextField12.setText("(D12): " + y);
        });
        //=== Print Saved Rolls^ ===//

        JButton deleteRollsButton = new JButton("Delete rolls");
        deleteRollsButton.setBounds(15,285,100,35);
        dicePanel.add(deleteRollsButton);
        deleteRollsButton.addActionListener(e4 -> {

            GameMath.DiceSixArrayList.clear();
            GameMath.DiceTwelveArrayList.clear();
            savedDiceTextField6.setText("(D6) :");
            savedDiceTextField12.setText("(D12):");
        });
        //=== Delete rolls^ ===//

        JButton diceLogoutButton = new JButton("Logout");
        diceLogoutButton.setBounds(400,465,100,35);
        dicePanel.add(diceLogoutButton);
        diceLogoutButton.addActionListener(e5 -> {

            GameMath.DiceSixArrayList.clear();
            GameMath.DiceTwelveArrayList.clear();
            diceFrame.setVisible(false);
            loginFrame.setVisible(true);
            loginMessage.setText("");
            passwordTextField.setText("");
        });
        //=== Logout^ ===//
    }

    public static void StartRoulette() {
        JPanel roulettePanel = new JPanel();
        JFrame rouletteFrame = new JFrame("Roulette");
        PanelsAndFrames.getMediumPanelsAndFrames(roulettePanel, rouletteFrame);
        //=== Roulette Frame+Panel^ ===//

        JButton resetAllBetsButton = new JButton("Reset all bets");
        resetAllBetsButton.setBounds(190,0,125,25);
        roulettePanel.add(resetAllBetsButton);
        resetAllBetsButton.addActionListener(e0 -> RouletteBets.setAllBetsToFalse());
        //=== Reset All Bets Button^ ===//

        JButton betOnRedButton = new JButton("Red");
        betOnRedButton.setBounds(15,30,100,40);
        roulettePanel.add(betOnRedButton);
        betOnRedText = new JTextField(50);
        betOnRedText.setBounds(120,30,120,40);
        roulettePanel.add(betOnRedText);
        betOnRedButton.addActionListener(e1 -> {
            RouletteBets.BetOnRed = true;
            betOnRedText.setText("Your bet is on Red");
        });
        //=== Red Button&Text Field^ ===//

        JButton betOnBlackButton = new JButton("Black");
        betOnBlackButton.setBounds(15,90,100,40);
        roulettePanel.add(betOnBlackButton);
        betOnBlackText = new JTextField(50);
        betOnBlackText.setBounds(120,90,120,40);
        roulettePanel.add(betOnBlackText);
        betOnBlackButton.addActionListener(e2 -> {
            RouletteBets.BetOnBlack = true;
            betOnBlackText.setText("Your bet is on Black");
        });
        //=== Black Button&Text Field^ ===//

        JButton betOnGreenButton = new JButton("Green");
        betOnGreenButton.setBounds(15,150,100,40);
        roulettePanel.add(betOnGreenButton);
        betOnGreenText = new JTextField(50);
        betOnGreenText.setBounds(120,150,120,40);
        roulettePanel.add(betOnGreenText);
        betOnGreenButton.addActionListener(e3 -> {
            RouletteBets.BetOnGreen = true;
            betOnGreenText.setText("Your bet is on green");
        });

        //=== Green Button&Text Field^ ===//

        JButton betOnOddsButton = new JButton("Odds");
        betOnOddsButton.setBounds(15,210,100,40);
        roulettePanel.add(betOnOddsButton);
        betOnOddsText = new JTextField(50);
        betOnOddsText.setBounds(120,210,120,40);
        roulettePanel.add(betOnOddsText);
        betOnOddsButton.addActionListener(e4 -> {
            RouletteBets.BetOnOdds = true;
            betOnOddsText.setText("Your bet is on Odds");
        });

        //=== Odds Button&Text Field^ ===//

        JButton betOnEvensButton = new JButton("Evens");
        betOnEvensButton.setBounds(15,270,100,40);
        roulettePanel.add(betOnEvensButton);
        betOnEvensText = new JTextField(50);
        betOnEvensText.setBounds(120,270,120,40);
        roulettePanel.add(betOnEvensText);
        betOnEvensButton.addActionListener(e5 -> {
            RouletteBets.BetOnEvens = true;
            betOnEvensText.setText("Your bet is on Evens");
        });

        //=== Evens Button&Text Field^ ===//

        JButton betOnTopHalfButton = new JButton("Top half");
        betOnTopHalfButton.setBounds(375,30,100,40);
        roulettePanel.add(betOnTopHalfButton);
        betOnTopHalfText = new JTextField(50);
        betOnTopHalfText.setBounds(247,30,123,40);
        roulettePanel.add(betOnTopHalfText);
        betOnTopHalfButton.addActionListener(e6 -> {
            RouletteBets.BetOnTopHalf = true;
            betOnTopHalfText.setText("Your bet is on top half");
        });
        //=== Top½ Button&Text Field^ ===//

        JButton betOnBottomHalfButton = new JButton("Bottom half");
        betOnBottomHalfButton.setBounds(375,90,100,40);
        roulettePanel.add(betOnBottomHalfButton);
        betOnBottomHalfText = new JTextField(50);
        betOnBottomHalfText.setBounds(247,90,123,40);
        roulettePanel.add(betOnBottomHalfText);
        betOnBottomHalfButton.addActionListener(e7 -> {
            RouletteBets.BetOnBottomHalf = true;
            betOnBottomHalfText.setText("Your bet is on bot half");
        });
        //=== Bottom½ Button&Text Field^ ===//

        JButton betOn1stButton = new JButton("1st");
        betOn1stButton.setBounds(375,150,100,40);
        roulettePanel.add(betOn1stButton);
        betOn1stText = new JTextField(50);
        betOn1stText.setBounds(247,150,123,40);
        roulettePanel.add(betOn1stText);
        betOn1stButton.addActionListener(e8 -> {
            RouletteBets.BetOn1st = true;
            betOn1stText.setText("Your bet is on 1st 12");
        });
        //=== 1st Button&Text Field^ ===//

        JButton betOn2ndButton = new JButton("2nd");
        betOn2ndButton.setBounds(375,210,100,40);
        roulettePanel.add(betOn2ndButton);
        betOn2ndText = new JTextField(50);
        betOn2ndText.setBounds(247,210,123,40);
        roulettePanel.add(betOn2ndText);
        betOn2ndButton.addActionListener(e9 -> {
            RouletteBets.BetOn2nd = true;
            betOn2ndText.setText("Your bet is on 2nd 12");
        });
        //=== 2nd Button&Text Field^ ===//

        JButton betOn3rdButton = new JButton("3rd");
        betOn3rdButton.setBounds(375,270,100,40);
        roulettePanel.add(betOn3rdButton);
        betOn3rdText = new JTextField(50);
        betOn3rdText.setBounds(247,270,123,40);
        roulettePanel.add(betOn3rdText);
        betOn3rdButton.addActionListener(e10 -> {
            RouletteBets.BetOn3rd = true;
            betOn3rdText.setText("Your bet is on 3rd 12");
        });
        //=== 3rd Button&Text Field^ ===//

        JButton spinWheelButton = new JButton("Spin Wheel");
        spinWheelButton.setBounds(15,330,460,40);
        roulettePanel.add(spinWheelButton);
        spinWheelButton.addActionListener(e11 -> GameMath.calculateRouletteResults());
        //=== spinWheel Button^ ===//

        rouletteResultText = new JTextField(20);
        rouletteResultText.setBounds(425,380,50,50);
        roulettePanel.add(rouletteResultText);
        Font thickFont = new Font("SansSerif", Font.BOLD, 40);
        rouletteResultText.setFont(thickFont);
        rouletteResultText.setEditable(false);
        //=== Roulette Result Text Field^ ===//

        gameLogText = new JTextField(50);
        gameLogText.setBounds(15,380,400,50);
        roulettePanel.add(gameLogText);
        Font mediumThickFont = new Font("SansSerif", Font.BOLD, 18);
        gameLogText.setFont(mediumThickFont);
        gameLogText.setEditable(false);
        gameLogText.setText("You have " + RouletteBets.userCredits + " credits");
        //=== GameLog Text Field^ ===//

        currentWagerText = new JTextField(20);
        currentWagerText.setBounds(335,465,50,40);
        roulettePanel.add(currentWagerText);
        currentWagerText.setFont(mediumThickFont);
        currentWagerText.setEditable(false);
        //=== CurrentWager TextField^ ===///

        JButton reduceWageButton = new JButton("Reduce Wage by 10");
        JButton raiseWageButton = new JButton("Raise Wage by 10");
        reduceWageButton.setBounds(15,465,150,40);
        raiseWageButton.setBounds(175,465,150,40);
        roulettePanel.add(reduceWageButton);
        roulettePanel.add(raiseWageButton);
        currentWagerText.setText(String.valueOf(RouletteBets.userBet));
        reduceWageButton.addActionListener(e13 -> {
            if (RouletteBets.userBet > 9) {
                RouletteBets.userBet -= 10;
                currentWagerText.setText(String.valueOf(RouletteBets.userBet));
            }
        });
        raiseWageButton.addActionListener(e13 -> {
            RouletteBets.userBet += 10;
            currentWagerText.setText(String.valueOf(RouletteBets.userBet));
        });
        //=== Raise/LowerWager Button^ ===//

        JButton rouletteLogoutButton = new JButton("Logout");
        rouletteLogoutButton.setBounds(400,465,100,35);
        roulettePanel.add(rouletteLogoutButton);
        rouletteLogoutButton.addActionListener(e14 -> {
            rouletteFrame.setVisible(false);
            loginFrame.setVisible(true);
            loginMessage.setText("");
            passwordTextField.setText("");
        });
        //=== Logout^ ===//
    }
    public static void resetAllTextFields() {
        betOnRedText.setText("");
        betOnBlackText.setText("");
        betOnGreenText.setText("");
        betOnOddsText.setText("");
        betOnEvensText.setText("");
        betOnTopHalfText.setText("");
        betOnBottomHalfText.setText("");
        betOn1stText.setText("");
        betOn2ndText.setText("");
        betOn3rdText.setText("");
    }
}