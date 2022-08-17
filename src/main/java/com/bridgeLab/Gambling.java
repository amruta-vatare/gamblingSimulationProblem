package com.bridgeLab;

import java.util.HashMap;
import java.util.Scanner;

//1.As a Gambler, would start with a stake of $100 every day and bet $1 every game.
//2.As a Gambler make $1 bet so either win or loose $1
//3.As a Calculative Gambler if won or lost 50% of the stake,would resign for the day
//4.After 20 days of playing every day would like to know the total amount won or lost.
//5.Each month would like to know the days won and lost and by how much.
//6.Would also like to know my luckiest day where I won maximum and my unluckiest day where I lost maximum.
//7.If won would like to continue playing next month or stop Gambling
public class Gambling {
    static int noOfMaxGamesInaDay = 50;
    static int daysOfMonth = 20;
    static int rsAmountOfDay = 100;
    static int resignAmountWhenWon = rsAmountOfDay + (rsAmountOfDay * 50 / 100); // 150
    static int resignAmountWhenLoss = rsAmountOfDay - (rsAmountOfDay * 50 / 100); // 50
    static int win = 0;
    static int loss = 0;
    static int cash =0;
    public static void main(String[] args) {
        int netCashMonth = 0 ;
        int maximumLoss = 0,maximumWon = 0;
        int dayWon = 0 , dayLoss = 0 ;
        Scanner sc = new Scanner(System.in);
        System.out.println("Press Y to start game");
        char ch = sc.next().charAt(0);
        if(ch == 'Y' || ch == 'y' ){
            for(int day = 1 ;day<=daysOfMonth;day++){
                cash = rsAmountOfDay;
                win = 0;
                loss = 0;
                int gameCount = 0;
                //3.As a Calculative Gambler if won or lost 50% of the stake,would resign for the day
                while(gameCount <= noOfMaxGamesInaDay ||
                        (cash < resignAmountWhenLoss || cash > resignAmountWhenWon))
                {
                    gameCount++;
                    gambling();
                }
                netCashMonth = netCashMonth +cash;
                int totalBet = win+loss;
                System.out.println("On day : "+day+" Your total bets are : "+totalBet);
                if(win>loss){
                    dayWon++;
                    int wonBy = cash - rsAmountOfDay;
                    //6.Would also like to know my luckiest day where I won maximum and my unluckiest day where I lost maximum.
                    if(maximumWon<wonBy)
                        maximumWon = wonBy;
                    //4.After 20 days of playing every day would like to know the total amount won or lost.
                    System.out.println(" Your are Luckiest you won "+win+" no of times, won by "+wonBy+" net cash for day:"+cash);
                } else{
                    dayLoss++;
                    int lossBy = rsAmountOfDay - cash;
                    if(maximumLoss<lossBy)
                        maximumLoss = lossBy;

                    System.out.println(" Your are Unluckiest you lost "+loss+" no of times, loss by "+lossBy+" net cash for day:"+cash);
                }
                System.out.println("-------------------------------------------------");
            }
            if(netCashMonth < 2000){
                System.out.println("Your maximum won is amount is "+maximumWon);
                System.out.println("Your maximum Loss is "+maximumLoss);
                //UC-5.Each month would like to know the days won and lost and by how much.
                int lossamt = 2000-netCashMonth;
                System.out.println("You loss "+dayLoss+" days on this month you loss $"+lossamt);
            }else{
                System.out.println("Your maximum won is amount is "+maximumWon);
                System.out.println("Your maximum Loss is "+maximumLoss);
                int wonamt = netCashMonth - 2000;
                System.out.println("You won "+dayWon+" days on this month you won $"+wonamt);
            }


        }
    }

    private static void gambling() {
        int result = getRandomGambling();
        if(result == 1){
            cash+=1;
            win++;
        }else {
            cash-=1;
            loss++;
        }


    }
    private static int getRandomGambling(){
        int min=1,max=3;
        double random = Math.random();
        int result = (int)(random * (max - min))+min;
        return result;
    }
}
