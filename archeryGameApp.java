package chapter7.archerygame;

import java.security.SecureRandom;

public class archeryGameApp {
    public static void main(String[] args) {
        int[][] players =new int[4][3];
        final int score = 10;
        SecureRandom rands = new SecureRandom();
        int total = 0;
        int highPoint = 0;
        int[] winnerPoints = new int[4];
        int[] playerScore = new int[4];


        System.out.printf("%7s%20s%20s%20s%20s%n","Players","First Chance","Second Chance","Third Chance","Total Score");

        for (int count = 0; count < players.length; count++){
            System.out.printf("Player[%d]:",count+1);
            for (int row =0; row < players[count].length; row++) {
                players[count][row] = rands.nextInt(score);
                total += players[count][row];
                playerScore[count] = total;
                System.out.printf("%17d",players[count][row]);
            }
            winnerPoints[count] = playerScore[count];
            highPoint = winnerPoints[0];
            System.out.printf("%17d",playerScore[count]);
            for (int point: winnerPoints){
                if (point  > highPoint){
                    highPoint = point;
                }
            }
            total = 0; // make total forget its memory (reset total to zero)
            System.out.println();
        }


        System.out.printf("%n%n");
        System.out.printf("Congratulations!!!%nPlayer with point[%d] wins the game%n%n", highPoint);
;
    }
}
