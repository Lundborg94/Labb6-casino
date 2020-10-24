package com.company;

public class CrapsGame {
    /*Reglerna för Craps är:
    Det finns två bets att välja på: Passline & dont Passline. Det finns två rundor av "rolls", första är
    "comeout roll" och andra är "pointRoll".
    Får du 11 eller 7 på "comeout roll" vinner du på Passline, och förlorar på "dont pass"
    Motsvarande förlorar "Passline" om du får 2, 3 eller 12, och "dont Pass" vinner.
    Alla andra utfall blir din "point" inför nästa runda.
    Nästa runda är "pointRoll", där är målet att slå samma siffra som din "point" för att vinna på "passline", och förlorar om du rullar en 7a.
    Motsatsen gäller för "dont pass", du vinner alltså om du slår en 7a innan du slår samma som din "point".
    Får du varken 7 eller din "point" skall du fortsätta slå tills någon av dem kommer upp.
    Får du dock en 12a och du har bet'at "dont pass" skall resultatet bli tie och du får tillbaka din insats (detta är ej inplementerat)
    */


        static double Dice1() {
            return (int) (Math.random() * ((6)) + (double) 1);
        }
        static double Dice2() {
            return (int) (Math.random() * ((6)) + (double) 1);
        }
        public static double twoDiceRoll = Dice1()+Dice2();
        public static double Point;
        public static boolean PassLineBetWin;
        public static boolean DontPassBetWin;

        public static void playComeOutRoll() {
            System.out.println("Your Come-out roll is: " + (int) twoDiceRoll);
            if (twoDiceRoll == 11.0 || twoDiceRoll == 7.0) {
                PassLineBetWin = true;
                DontPassBetWin = false;
                System.out.println("\n your Score is " + (int) twoDiceRoll);
                System.out.println("you win");
            }
            if (twoDiceRoll == 2.0 || twoDiceRoll == 3.0 || twoDiceRoll == 12.0) {
                PassLineBetWin = false;
                DontPassBetWin = true;
                System.out.println("\n your Score is " + (int) twoDiceRoll);
                System.out.println("you got craps!");
            } else {
                twoDiceRoll = Point;
                System.out.println("\n your point is " + (int) twoDiceRoll);
                System.out.println("time to roll point roll ");
                playPointRoll();

            }
        }
        public static void playPointRoll(){
            System.out.println("Your point roll is: " + (int) twoDiceRoll);
            if (twoDiceRoll == Point){
                PassLineBetWin = true;
                DontPassBetWin = false;
            }
            if (twoDiceRoll == 7){
                PassLineBetWin = false;
                DontPassBetWin = true;
            } else
                System.out.println("Roll again!");
                playPointRoll();
        }
}

