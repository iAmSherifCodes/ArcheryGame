package chapter7.archerygame;

import java.security.SecureRandom;
import java.util.Arrays;

public class archeryGameApp {
    public static void main(String[] args) {
        int[][] players =new int[4][3];
        final int score = 10;
        SecureRandom rands = new SecureRandom();

        for (int count = 0; count < players.length; count++){
            for (int row =0; row < players[count].length; row++) {
                players[count][row] = rands.nextInt(score);
            }
        }

        System.out.printf("%n%n");

        System.out.printf("%7s%20s%20s%20s%20s%n","Players","First Chance","Second Chance","Third Chance","Total Score");
        int testTotal = 0;
        int[] testArray= new int[4];
        for (int r = 0; r < players.length; r++) {
            //{0,1,2,3}
            System.out.printf("Player %2d: ", r+1);
            for (int c =0; c <players[r].length; c++) {
                System.out.printf("%15d ", players[r][c]);
            }
            for (int i = 0; i < players.length; i++){
                for (int c =0; c <players[i].length; c++){
                    testTotal+=players[i][c];
                    testArray[i] = testTotal;
                }
                testTotal = 0;
            }

            System.out.printf("%20d",testArray[r]);

            System.out.println();
        }
        System.out.println();
        int highPnt = testArray[0];

        System.out.println();
        int winnerNumber = 0;
        int highP = getMaximum(testArray);
        System.out.println();

        winnerNumber = Arrays.binarySearch(testArray, highP);
        System.out.printf("Congratulations!!!%nPlayer %d won the game with %d number of points",winnerNumber+1,highP);
        System.out.println();

    }
    public static int getMaximum(int[] arr){
       int highNum = arr[0];
        for (int j : arr) {
            if (j > highNum) {
                highNum = j;
            }
        }
        return highNum;
    }
}
