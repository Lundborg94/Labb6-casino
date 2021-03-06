package com.company;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

public class Main {

    private JTextField rouletteResultText;
    private int userCredits = 500;
    private int userBet = 0;




    private double spinRoulette() {
        return (int)(Math.random()*((36)));
    }

    public static void main(String[] args) {
        Main program = new Main();
        program.StartLoginFrame();
    }

    private void StartLoginFrame() {
        PanelsAndFrames getFrame = new PanelsAndFrames();

        JPanel loginPanel = new JPanel();
        JFrame loginFrame = new JFrame("Dice Generator Login");
        getFrame.getSmallPanelsAndFrames(loginPanel, loginFrame);
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
        JPasswordField passwordTextField = new JPasswordField(20);
        passwordTextField.setBounds(100,50,165,25);
        loginPanel.add(passwordTextField);
        //=== Password^ ===//

        JLabel loginMessage = new JLabel("");
        loginMessage.setBounds(100,80,300,25);
        loginPanel.add(loginMessage);
        //=== Login Message^ ===//

        JButton loginButton = new JButton("Login");
        loginButton.setBounds(10,90,80,25);
        loginPanel.add(loginButton);
        loginPanel.repaint();
        //=== LoginButton^ ===//

        loginButton.addActionListener(e1 -> {
            String userName = usernameTextField.getText();
            String passWord = passwordTextField.getText();
            if(userName.equals("") && passWord.equals("")) {
                loginFrame.setVisible(false);
                StartLobby(loginMessage,loginFrame,passwordTextField);
            }
            else {
                loginMessage.setText("Wrong username or password, try again");
            }
        });
    }

    private void StartLobby(JLabel loginMessage, JFrame loginFrame, JPasswordField passwordTextField) {
        PanelsAndFrames getFrames = new PanelsAndFrames();

        JPanel choicePanel = new JPanel();
        JFrame choiceFrame = new JFrame("Lobby");
        getFrames.getSmallPanelsAndFrames(choicePanel, choiceFrame);
        //=== Choice Frame+Panel^ ===//

        JButton rouletteButton = new JButton("Roulette");
        JButton diceButton = new JButton("Craps");
        rouletteButton.setBounds(25,30,125,40);
        diceButton.setBounds(175,30,125,40);
        choicePanel.add(rouletteButton);
        choicePanel.add(diceButton);
        //=== Roulette/Dice Buttons^ ===//

        JButton logoutButton = new JButton("Logout");
        getFrames.getLogOutButton(logoutButton,choicePanel);
        logoutButton.addActionListener(e1 -> {

            choiceFrame.setVisible(false);
            loginFrame.setVisible(true);
            loginMessage.setText("");
            passwordTextField.setText("");
        });
        //=== Logout^ ===//

        rouletteButton.addActionListener(e2 -> {
            choiceFrame.setVisible(false);
            StartRoulette(choiceFrame);
        });

        diceButton.addActionListener(e3 -> {
            choiceFrame.setVisible(false);
            startCraps(choiceFrame);
        });
    }

    private void startCraps(JFrame choiceFrame) {
        PanelsAndFrames getFrames = new PanelsAndFrames();
        JPanel dicePanel = new JPanel();
        JFrame diceFrame = new JFrame("Dice");
        getFrames.getMediumPanelsAndFrames(dicePanel, diceFrame);
        //=== Dice Frame+Panel^ ===//

        JTextField diceGameLogText = new JTextField(50);
        getFrames.getGameLogTextField(diceGameLogText,dicePanel,userCredits);
        //=== Dice GameLog Text Field^ ===//

        JTextField diceCurrentWagerText = new JTextField(20);
        getFrames.getCurrentWagerTextField(diceCurrentWagerText,dicePanel);
        //=== Dice CurrentWager TextField^ ===///

        JTextField crapsBetText = new JTextField(50);
        crapsBetText.setBounds(15,90,475,40);
        dicePanel.add(crapsBetText);

        JButton betOnPassButton = new JButton("PassLine");
        betOnPassButton.setBounds(15,30,230,40);
        dicePanel.add(betOnPassButton);
        betOnPassButton.addActionListener(e1 -> {
            RouletteBets.passLineBet = true;
            RouletteBets.dontPassBet = false;
            crapsBetText.setText("Your bet is on the pass line");
        });
        //=== PassLine Button&Text Field^ ===//

        JButton DontPassBetButton = new JButton("Dont pass");
        DontPassBetButton.setBounds(260,30,230,40);
        dicePanel.add(DontPassBetButton);
        DontPassBetButton.addActionListener(e1 -> {
            RouletteBets.dontPassBet = true;
            RouletteBets.passLineBet = false;

            crapsBetText.setText("Your bet is on Dont pass");
        });
        //=== PassLine Button&Text Field^ ===//

        JButton playCrapsButton = new JButton("Throw");
        playCrapsButton.setBounds(15,330,460,40);
        dicePanel.add(playCrapsButton);
        playCrapsButton.addActionListener(e11 -> CrapsGame.playComeOutRoll());
        //=== PlayCraps Button^ ===//

        JButton diceReduceWageButton = new JButton("Reduce Wage by 10");
        JButton diceRaiseWageButton = new JButton("Raise Wage by 10");
        getFrames.getRaiseAndLowerWagerButtons(diceReduceWageButton, diceRaiseWageButton, dicePanel);
        diceCurrentWagerText.setText(String.valueOf(userBet));
        diceReduceWageButton.addActionListener(e13 -> {
            if (userBet > 9) {
                userBet -= 10;
                diceCurrentWagerText.setText(String.valueOf(userBet));
            }
        });
        diceRaiseWageButton.addActionListener(e13 -> {
            userBet += 10;
            diceCurrentWagerText.setText(String.valueOf(userBet));
        });
        //=== Dice Raise/LowerWager Button^ ===//

        JButton diceExitToLobbyButton = new JButton("Lobby");
        getFrames.getExitToLobbyButton(diceExitToLobbyButton,dicePanel);
        diceExitToLobbyButton.addActionListener(e14 -> {
            diceFrame.setVisible(false);
            choiceFrame.setVisible(true);
        });
        //=== Exit to lobby^ ===//
    }

    private void StartRoulette(JFrame choiceFrame) {
        RouletteBets allBets = new RouletteBets();
        PanelsAndFrames getFrames = new PanelsAndFrames();

        JPanel roulettePanel = new JPanel();
        JFrame rouletteFrame = new JFrame("Roulette");
        getFrames.getMediumPanelsAndFrames(roulettePanel, rouletteFrame);
        //=== Roulette Frame+Panel^ ===//

        JButton betOnRedButton = new JButton("Red");
        betOnRedButton.setBounds(15,30,100,40);
        roulettePanel.add(betOnRedButton);
        JTextField betOnRedText = new JTextField(50);
        betOnRedText.setBounds(120,30,120,40);
        roulettePanel.add(betOnRedText);
        betOnRedButton.addActionListener(e1 -> {
            RouletteBets.bets[0] = true;
            betOnRedText.setText("Your bet is on Red");
        });
        //=== Red Button&Text Field^ ===//

        JButton betOnBlackButton = new JButton("Black");
        betOnBlackButton.setBounds(15,90,100,40);
        roulettePanel.add(betOnBlackButton);
        JTextField betOnBlackText = new JTextField(50);
        betOnBlackText.setBounds(120,90,120,40);
        roulettePanel.add(betOnBlackText);
        betOnBlackButton.addActionListener(e2 -> {
            RouletteBets.bets[1] = true;
            betOnBlackText.setText("Your bet is on Black");
        });
        //=== Black Button&Text Field^ ===//

        JButton betOnGreenButton = new JButton("Green");
        betOnGreenButton.setBounds(15,150,100,40);
        roulettePanel.add(betOnGreenButton);
        JTextField betOnGreenText = new JTextField(50);
        betOnGreenText.setBounds(120,150,120,40);
        roulettePanel.add(betOnGreenText);
        betOnGreenButton.addActionListener(e3 -> {
            RouletteBets.bets[2] = true;
            betOnGreenText.setText("Your bet is on green");
        });
        //=== Green Button&Text Field^ ===//

        JButton betOnOddsButton = new JButton("Odds");
        betOnOddsButton.setBounds(15,210,100,40);
        roulettePanel.add(betOnOddsButton);
        JTextField betOnOddsText = new JTextField(50);
        betOnOddsText.setBounds(120,210,120,40);
        roulettePanel.add(betOnOddsText);
        betOnOddsButton.addActionListener(e4 -> {
            RouletteBets.bets[3] = true;
            betOnOddsText.setText("Your bet is on Odds");
        });
        //=== Odds Button&Text Field^ ===//

        JButton betOnEvensButton = new JButton("Evens");
        betOnEvensButton.setBounds(15,270,100,40);
        roulettePanel.add(betOnEvensButton);
        JTextField betOnEvensText = new JTextField(50);
        betOnEvensText.setBounds(120,270,120,40);
        roulettePanel.add(betOnEvensText);
        betOnEvensButton.addActionListener(e5 -> {
            RouletteBets.bets[4] = true;
            betOnEvensText.setText("Your bet is on Evens");
        });
        //=== Evens Button&Text Field^ ===//

        JButton betOnTopHalfButton = new JButton("Top half");
        betOnTopHalfButton.setBounds(375,30,100,40);
        roulettePanel.add(betOnTopHalfButton);
        JTextField betOnTopHalfText = new JTextField(50);
        betOnTopHalfText.setBounds(247,30,123,40);
        roulettePanel.add(betOnTopHalfText);
        betOnTopHalfButton.addActionListener(e6 -> {
            RouletteBets.bets[5] = true;
            betOnTopHalfText.setText("Your bet is on top half");
        });
        //=== Top½ Button&Text Field^ ===//

        JButton betOnBottomHalfButton = new JButton("Bottom half");
        betOnBottomHalfButton.setBounds(375,90,100,40);
        roulettePanel.add(betOnBottomHalfButton);
        JTextField betOnBottomHalfText = new JTextField(50);
        betOnBottomHalfText.setBounds(247,90,123,40);
        roulettePanel.add(betOnBottomHalfText);
        betOnBottomHalfButton.addActionListener(e7 -> {
            RouletteBets.bets[6] = true;
            betOnBottomHalfText.setText("Your bet is on bot half");
        });
        //=== Bottom½ Button&Text Field^ ===//

        JButton betOn1stButton = new JButton("1st");
        betOn1stButton.setBounds(375,150,100,40);
        roulettePanel.add(betOn1stButton);
        JTextField betOn1stText = new JTextField(50);
        betOn1stText.setBounds(247,150,123,40);
        roulettePanel.add(betOn1stText);
        betOn1stButton.addActionListener(e8 -> {
            RouletteBets.bets[7] = true;
            betOn1stText.setText("Your bet is on 1st 12");
        });
        //=== 1st Button&Text Field^ ===//

        JButton betOn2ndButton = new JButton("2nd");
        betOn2ndButton.setBounds(375,210,100,40);
        roulettePanel.add(betOn2ndButton);
        JTextField betOn2ndText = new JTextField(50);
        betOn2ndText.setBounds(247,210,123,40);
        roulettePanel.add(betOn2ndText);
        betOn2ndButton.addActionListener(e9 -> {
            RouletteBets.bets[8] = true;
            betOn2ndText.setText("Your bet is on 2nd 12");
        });
        //=== 2nd Button&Text Field^ ===//

        JButton betOn3rdButton = new JButton("3rd");
        betOn3rdButton.setBounds(375,270,100,40);
        roulettePanel.add(betOn3rdButton);
        JTextField betOn3rdText = new JTextField(50);
        betOn3rdText.setBounds(247,270,123,40);
        roulettePanel.add(betOn3rdText);
        betOn3rdButton.addActionListener(e10 -> {
            RouletteBets.bets[9] = true;
            betOn3rdText.setText("Your bet is on 3rd 12");
        });
        //=== 3rd Button&Text Field^ ===//

        JTextField[] betOnArray = {betOnRedText,betOnBlackText,betOnGreenText,betOnOddsText,betOnEvensText,
                betOnTopHalfText,betOnBottomHalfText,betOn1stText,betOn2ndText,betOn3rdText};
        //=== Array betOnJTextFrames^ ===//

        JButton resetAllBetsButton = new JButton("Reset all bets");
        resetAllBetsButton.setBounds(190,0,125,25);
        roulettePanel.add(resetAllBetsButton);
        resetAllBetsButton.addActionListener(e0 -> allBets.setAllBetsToFalse(betOnArray));
        //=== Reset All Bets Button^ ===//

        JTextField rouletteGameLogText = new JTextField(50);
        getFrames.getGameLogTextField(rouletteGameLogText,roulettePanel,userCredits);
        //=== GameLog Text Field^ ===//

        JButton spinWheelButton = new JButton("Spin Wheel");
        spinWheelButton.setBounds(15,330,460,40);
        roulettePanel.add(spinWheelButton);
        spinWheelButton.addActionListener(e11 -> calculateRouletteResults(betOnArray,rouletteGameLogText));
        //=== spinWheel Button^ ===//

        rouletteResultText = new JTextField(20);
        rouletteResultText.setBounds(425,380,50,50);
        roulettePanel.add(rouletteResultText);
        Font thickFont = new Font("SansSerif", Font.BOLD, 40);
        rouletteResultText.setFont(thickFont);
        rouletteResultText.setEditable(false);
        //=== Roulette Result Text Field^ ===//

        JTextField rouletteCurrentWagerText = new JTextField(20);
        getFrames.getCurrentWagerTextField(rouletteCurrentWagerText,roulettePanel);
        //=== CurrentWager TextField^ ===///

        JButton rouletteReduceWageButton = new JButton("Reduce Wage by 10");
        JButton rouletteRaiseWageButton = new JButton("Raise Wage by 10");
        getFrames.getRaiseAndLowerWagerButtons(rouletteReduceWageButton, rouletteRaiseWageButton, roulettePanel);
        rouletteCurrentWagerText.setText(String.valueOf(userBet));
        rouletteReduceWageButton.addActionListener(e13 -> {
            if (userBet > 9) {
                userBet -= 10;
                rouletteCurrentWagerText.setText(String.valueOf(userBet));
            }
        });
        rouletteRaiseWageButton.addActionListener(e13 -> {
            userBet += 10;
            rouletteCurrentWagerText.setText(String.valueOf(userBet));
        });
        //=== Raise/LowerWager Button^ ===//

        JButton rouletteExitToLobbyButton = new JButton("Lobby");
        getFrames.getExitToLobbyButton(rouletteExitToLobbyButton,roulettePanel);
        rouletteExitToLobbyButton.addActionListener(e14 -> {
            rouletteFrame.setVisible(false);
            choiceFrame.setVisible(true);
        });
        //=== Exit to lobby^ ===//
    }

    private void calculateRouletteResults(JTextField[] betOnArray, JTextField rouletteGameLogText) {
        RouletteBets allBets = new RouletteBets();
        DidRouletteWin checkIfWin = new DidRouletteWin();

        // Makes sure the user has enough credits for multiple bets
        int tempUserBet = 0;
        for (int i=0; RouletteBets.bets.length > i; i++) {
            if (RouletteBets.bets[i])
                tempUserBet += userBet;
        }

        // Goes on if the user affords the bet or bets
        if (userCredits >= tempUserBet) {

            // Spins the spinRoulette and String/Int the result, sets the colour of the result
            int rouletteRollResult = (int) spinRoulette();
            String x = Integer.toString(rouletteRollResult);
            rouletteResultText.setText(x);
            setResultColour(rouletteRollResult);

            // Check how many bets were placed and deducts bet amount per bet
            for (int i=0; RouletteBets.bets.length > i; i++) {
                if (RouletteBets.bets[i])
                    userCredits -= userBet;
            }

            // Sends the result of spinRoulette and bet to calculate win/loss
            int userTempValue = checkIfWin.checkWin(userBet,rouletteRollResult);
            userCredits += userTempValue;

            // Check if win/no bet/lose
            checkIfWinLoseOrNull(userTempValue,rouletteGameLogText);

            // check if user have enough funds
        } else if (userCredits > 0) {
            rouletteGameLogText.setText("Insufficient funds, please lower wager");
        } else {
            rouletteGameLogText.setText("Insufficient funds, please refill balance");
        }
        allBets.setAllBetsToFalse(betOnArray);
    }

    private void setResultColour(int roll) {
        if (roll == 0) {
            rouletteResultText.setBackground(Color.green);
        } else if (Arrays.asList(2,4,6,8,10,11,13,15,17,20,22,24,26,28,29,31,33,35).contains(roll)) {
            rouletteResultText.setBackground(Color.gray);
        } else {
            rouletteResultText.setBackground(Color.red);
        }
    }

    private void checkIfWinLoseOrNull(int tempValue,JTextField rouletteGameLogText) {
        if (tempValue > userBet) {
            rouletteGameLogText.setText("You won " + tempValue + " credits, your new total is: " + userCredits);
        } else if (!Arrays.asList(RouletteBets.bets).contains(true)) {
            rouletteGameLogText.setText("No bets found, your total is still : " + userCredits);
        } else {
            rouletteGameLogText.setText("You lost " + userBet + " credits, your total is now : " + userCredits);
        }
    }

}