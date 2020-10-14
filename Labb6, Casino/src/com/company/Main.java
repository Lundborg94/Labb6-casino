package com.company;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;

public class Main {

    public static ArrayList<String> DiceSixArrayList = new ArrayList<>();
    public static ArrayList<String> DiceTwelveArrayList = new ArrayList<>();
    private static JTextField usernameTextField;
    private static JTextField diceSixResult;
    private static JTextField diceTwelveResult;
    private static JTextField savedDiceTextField6;
    private static JTextField savedDiceTextField12;
    private static JTextField rouletteResult;
    private static JPasswordField passwordTextField;
    private static JLabel loginMessage;
    private static JFrame loginFrame;

    static double D6() {
        return (int)(Math.random()*((7-1))+ (double) 1);
    }
    static double D12() {
        return (int)(Math.random()*((13-1))+ (double) 1);
    }
    static double roulette() {
        return (int)(Math.random()*((38-1))+ (double) 1);

    }
    public static void main(String[] args) {
        StartLoginFrame();
    }

    public static void StartLoginFrame() {

        JPanel loginPanel = new JPanel();
        loginFrame = new JFrame("Dice Generator Login");
        loginFrame.setSize(400,200);
        loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        loginFrame.setLocationRelativeTo(null);
        loginFrame.add(loginPanel);
        loginPanel.setLayout(null);
        loginPanel.setBackground(Color.getHSBColor(0,20,202));
        //=== Login Frame/Panel^ ===//

        JLabel usernameLabel = new JLabel("Username:");
        usernameLabel.setBounds (10,20,80,25);
        loginPanel.add(usernameLabel);
        usernameTextField = new JTextField(20);
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

        JButton loginButton = new JButton("Login");
        loginButton.setBounds(10,80,80,25);
        loginPanel.add(loginButton);
        //=== Button^ ===//

        loginMessage = new JLabel("");
        loginMessage.setBounds(100,80,300,25);
        loginPanel.add(loginMessage);
        loginFrame.setVisible(true);
        //=== Login Message^ ===//

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
        choiceFrame.setVisible(true);
        choiceFrame.setSize(350,175);
        choiceFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        choiceFrame.setLocationRelativeTo(null);
        choiceFrame.add(choicePanel);
        choicePanel.setLayout(null);
        choicePanel.setBackground(Color.getHSBColor(0,20,202));
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
        PanelsAndFrames.getPanelsAndFrames(dicePanel, diceFrame);
        //=== Dicer Frame+Panel^ ===//

        JButton rollDiceSix = new JButton("Roll 1-6");
        rollDiceSix.setBounds(15,30,100,40);
        diceSixResult = new JTextField(20);
        diceSixResult.setBounds(155,30,100,40);
        dicePanel.add(diceSixResult);
        dicePanel.add(rollDiceSix);
        rollDiceSix.addActionListener(e1 -> {

            String x = Integer.toString((int) D6());
            diceSixResult.setText(x);
            DiceSixArrayList.add(x);
        });
        //=== Dice 1-6^ ===//

        JButton rollDiceTwelve = new JButton("Roll 1-12");
        rollDiceTwelve.setBounds(15,100,100,40);
        diceTwelveResult = new JTextField(20);
        diceTwelveResult.setBounds(155,100,100,40);
        dicePanel.add(diceTwelveResult);
        dicePanel.add(rollDiceTwelve);
        rollDiceTwelve.addActionListener(e2 -> {

            String x = Integer.toString((int) D12());
            diceTwelveResult.setText(x);
            DiceTwelveArrayList.add(x);
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

            Collections.sort(DiceSixArrayList);
            Collections.sort(DiceTwelveArrayList);
            String x = DiceSixArrayList.toString();
            String y = DiceTwelveArrayList.toString();
            savedDiceTextField6.setText("(D6) :  " + x);
            savedDiceTextField12.setText("(D12): " + y);
        });
        //=== Print Saved Rolls^ ===//

        JButton deleteRollsButton = new JButton("Delete rolls");
        deleteRollsButton.setBounds(15,285,100,35);
        dicePanel.add(deleteRollsButton);
        deleteRollsButton.addActionListener(e4 -> {

            DiceSixArrayList.clear();
            DiceTwelveArrayList.clear();
            savedDiceTextField6.setText("(D6) :");
            savedDiceTextField12.setText("(D12):");
        });
        //=== Delete rolls^ ===//

        JButton diceLogoutButton = new JButton("Logout");
        diceLogoutButton.setBounds(340,25,100,35);
        dicePanel.add(diceLogoutButton);
        diceLogoutButton.addActionListener(e5 -> {

            DiceSixArrayList.clear();
            DiceTwelveArrayList.clear();
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
        PanelsAndFrames.getPanelsAndFrames(roulettePanel, rouletteFrame);
        //=== Dicer Frame+Panel^ ===//

        JButton betOnRedButton = new JButton("Red");
        betOnRedButton.setBounds(15,30,100,40);
        roulettePanel.add(betOnRedButton);
        JTextField betOnRedText = new JTextField(50);
        betOnRedText.setBounds(120,30,120,40);
        roulettePanel.add(betOnRedText);
        betOnRedButton.addActionListener(e1 -> betOnRedText.setText("Your bet is on Red"));
        betOnRedButton.addActionListener(e2 -> RouletteBets.BetOnRed = true);
        //=== Red Button&Text Field^ ===//

        JButton betOnBlackButton = new JButton("Black");
        betOnBlackButton.setBounds(15,90,100,40);
        roulettePanel.add(betOnBlackButton);
        JTextField betOnBlackText = new JTextField(50);
        betOnBlackText.setBounds(120,90,120,40);
        roulettePanel.add(betOnBlackText);
        betOnBlackButton.addActionListener(e3 -> betOnBlackText.setText("Your bet is on Black"));
        betOnBlackButton.addActionListener(e4 -> RouletteBets.BetOnBlack = true);
        //=== Black Button&Text Field^ ===//

        JButton betOnGreenButton = new JButton("Green");
        betOnGreenButton.setBounds(15,150,100,40);
        roulettePanel.add(betOnGreenButton);
        JTextField betOnGreenText = new JTextField(50);
        betOnGreenText.setBounds(120,150,120,40);
        roulettePanel.add(betOnGreenText);
        betOnGreenButton.addActionListener(e5 -> betOnGreenText.setText("Your bet is on green"));
        betOnGreenButton.addActionListener(e6 -> RouletteBets.BetOnGreen = true);
        //=== Green Button&Text Field^ ===//

        JButton betOnOddsButton = new JButton("Odds");
        betOnOddsButton.setBounds(15,210,100,40);
        roulettePanel.add(betOnOddsButton);
        JTextField betOnOddsText = new JTextField(50);
        betOnOddsText.setBounds(120,210,120,40);
        roulettePanel.add(betOnOddsText);
        betOnOddsButton.addActionListener(e7 -> betOnOddsText.setText("Your bet is on Odds"));
        betOnOddsButton.addActionListener(e8 -> RouletteBets.BetOnOdds = true);
        //=== Odds Button&Text Field^ ===//

        JButton betOnEvensButton = new JButton("Evens");
        betOnEvensButton.setBounds(15,270,100,40);
        roulettePanel.add(betOnEvensButton);
        JTextField betOnEvensText = new JTextField(50);
        betOnEvensText.setBounds(120,270,120,40);
        roulettePanel.add(betOnEvensText);
        betOnEvensButton.addActionListener(e9 -> betOnEvensText.setText("Your bet is on Evens"));
        betOnEvensButton.addActionListener(e10 -> RouletteBets.BetOnEvens = true);
        //=== Evens Button&Text Field^ ===//

        JButton betOnTopHalfButton = new JButton("Top half");
        betOnTopHalfButton.setBounds(375,30,100,40);
        roulettePanel.add(betOnTopHalfButton);
        JTextField betOnTopHalfText = new JTextField(50);
        betOnTopHalfText.setBounds(250,30,120,40);
        roulettePanel.add(betOnTopHalfText);
        betOnTopHalfButton.addActionListener(e11 -> betOnTopHalfText.setText("Your bet is on the top half"));
        betOnTopHalfButton.addActionListener(e12 -> RouletteBets.BetOnTopHalf = true);
        //=== Top½ Button&Text Field^ ===//

        JButton betOnBottomHalfButton = new JButton("Bottom half");
        betOnBottomHalfButton.setBounds(375,90,100,40);
        roulettePanel.add(betOnBottomHalfButton);
        JTextField betOnBottomHalfText = new JTextField(50);
        betOnBottomHalfText.setBounds(250,90,120,40);
        roulettePanel.add(betOnBottomHalfText);
        betOnBottomHalfButton.addActionListener(e11 -> betOnBottomHalfText.setText("Your bet is on the bottom half"));
        betOnBottomHalfButton.addActionListener(e12 -> RouletteBets.BetOnBottomHalf = true);
        //=== Bottom½ Button&Text Field^ ===//

        JButton betOn1stButton = new JButton("1st");
        betOn1stButton.setBounds(375,150,100,40);
        roulettePanel.add(betOn1stButton);
        JTextField betOn1stText = new JTextField(50);
        betOn1stText.setBounds(250,150,120,40);
        roulettePanel.add(betOn1stText);
        betOn1stButton.addActionListener(e3 -> betOn1stText.setText("Your bet is on 1st 12"));
        betOn1stButton.addActionListener(e4 -> RouletteBets.BetOn1st = true);
        //=== 1st Button&Text Field^ ===//

        JButton betOn2ndButton = new JButton("2nd");
        betOn2ndButton.setBounds(375,210,100,40);
        roulettePanel.add(betOn2ndButton);
        JTextField betOn2ndText = new JTextField(50);
        betOn2ndText.setBounds(250,210,120,40);
        roulettePanel.add(betOn2ndText);
        betOn2ndButton.addActionListener(e3 -> betOn2ndText.setText("Your bet is on 2nd 12"));
        betOn2ndButton.addActionListener(e4 -> RouletteBets.BetOn2nd = true);
        //=== 2nd Button&Text Field^ ===//

        JButton betOn3rdButton = new JButton("3rd");
        betOn3rdButton.setBounds(375,270,100,40);
        roulettePanel.add(betOn3rdButton);
        JTextField betOn3rdText = new JTextField(50);
        betOn3rdText.setBounds(250,270,120,40);
        roulettePanel.add(betOn3rdText);
        betOn3rdButton.addActionListener(e3 -> betOn3rdText.setText("Your bet is on 3rd 12"));
        betOn3rdButton.addActionListener(e4 -> RouletteBets.BetOn3rd = true);
        //=== 3rd Button&Text Field^ ===//

        //-------------------------------------------------------------------------------
        JButton spinWheelButton = new JButton("Spin Wheel");
        spinWheelButton.setBounds(15,330,460,40);
        roulettePanel.add(spinWheelButton);
        spinWheelButton.addActionListener(e4 -> {
            String x = Integer.toString((int) roulette());
            rouletteResult.setText(x);
        });
        //=== spinWheel Button^ ===//

        rouletteResult = new JTextField(20);
        rouletteResult.setBounds(230,390,50,50);
        roulettePanel.add(rouletteResult);
        Font thickFont = new Font("SansSerif", Font.BOLD, 40);
        rouletteResult.setFont(thickFont);
        //=== Roulette Result Text Field^ ===//

        JButton rouletteLogoutButton = new JButton("Logout");
        rouletteLogoutButton.setBounds(375,390,100,35);
        roulettePanel.add(rouletteLogoutButton);
        rouletteLogoutButton.addActionListener(e5 -> {

            rouletteFrame.setVisible(false);
            loginFrame.setVisible(true);
            loginMessage.setText("");
            passwordTextField.setText("");
        });
        //=== Logout^ ===//
    }
}