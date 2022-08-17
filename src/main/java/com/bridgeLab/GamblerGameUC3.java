package com.bridgeLab;

import java.util.Scanner;

public class GamblerGameUC3 {
    //1.As a Gambler, would start with a stake of $100 every day and bet $1 every game.
    //2.As a Gambler make $1 bet so either win or loose $1
    //3.As a Calculative Gambler if won or lost 50% of the stake,would resign for the day
    //4.After 20 days of playing every day would like to know the total amount won or lost.
    //5.Each month would like to know the days won and lost and by how much.
    //6.Would also like to know my luckiest day where I won maximum and my unluckiest day where I lost maximum.
    //7.If won would like to continue playing next month or stop Gambling
    static int days = 20;
    static int rsPerDay = 100;
    static int ch = 0;
    static int totalWinAmount=0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int winCount = 0 ;
        int lossCount = 0;
            System.out.println("Press 1 to bet");
            int n = sc.nextInt();
            if(n == 1){
                while (rsPerDay!=0){
                    if(winCount == 50 && lossCount == 50){
                        System.out.println("You are unable to play more");
                        break;
                    }
                    rsPerDay--;
                    ch = getRandom();
                    switch (ch){
                        case 1:
                            gamblingWin();
                            winCount++;
                            break;
                        case 2:
                            gamblingLoss();
                            lossCount++;
                            break;
                        default:
                            break;
                    }
                }
                if(totalWinAmount<0){
                    System.out.println("Loss "+lossCount+" times on this day!");
                    System.out.println("You loss Game "+totalWinAmount+"$ ");
                }else{
                    System.out.println("Win "+winCount+" times on this day!");
                    System.out.println("You win amount "+totalWinAmount+"$");
                }
        }
    }
    private static void gamblingLoss() {
        totalWinAmount+=1;
    }

    private static void gamblingWin() {
        totalWinAmount-=1;
    }

    private static int getRandom(){
        int min=1,max=3;
        double random = Math.random();
        int hours = (int)(random * (max - min))+min;
        return hours;
    }
}
