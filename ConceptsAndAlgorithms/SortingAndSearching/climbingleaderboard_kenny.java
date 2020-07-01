import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the climbingLeaderboard function below.
    static int[] climbingLeaderboard(int[] scores, int[] alice) {
        int scorePtr = scores.length - 1;
        int alicePtr = 0;
        int[] aliceRankings = new int[alice.length];

        int[] ranks = createRanks(scores);

        for (int i = 0; i < alice.length; i++) {
            int currentAliceScore = alice[i];
            ///System.out.println("i=" + i + " score " + currentAliceScore + " scorePtr " + scorePtr );
            for (int j = scorePtr; j >= 0; j--) {
                //System.out.println("j=" + j);
                int currentScore = scores[j];

                //System.out.println("currentScore= " + currentScore + " currentAliceScore= " + currentAliceScore);

                if(currentScore > currentAliceScore) {
                    aliceRankings[alicePtr] = ranks[j]+1;
                    alicePtr++;
                    scorePtr = j;
                    //System.out.println("> break " + " rank= " + aliceRankings[alicePtr]);
                    break;    
                } else if (currentScore == currentAliceScore) {
                    aliceRankings[alicePtr] = ranks[j];
                    alicePtr++;
                    scorePtr = j;
                    //System.out.println("= break" + " rank= " + aliceRankings[alicePtr]);
                    break;
                } 

                if (ranks[j] == 1) {
                    if(currentAliceScore >= currentScore) {
                        aliceRankings[alicePtr] = 1;
                        alicePtr++;
                        scorePtr = j;
                        break;
                    }
                    else {
                        aliceRankings[alicePtr] = 2;
                        alicePtr++;
                        scorePtr = j;
                        break;
                    }
                }
            }
        }
        //System.out.println(Arrays.toString(aliceRankings));
        return aliceRankings;
    }

    static int[] createRanks(int[] scores) {
        int[] ranks = new int[scores.length];
        // System.out.println("scores length =" + scores.length);
        // System.out.println("ranks length =" + ranks.length);

        ranks[0] = 1;
        int currentRank = 1;
        int currentValue = scores[0];

        for(int i = 1; i < scores.length; i++) {
            int newValue = scores[i];

            if(newValue != currentValue) 
                currentRank++;
                        
            ranks[i] = currentRank;
            currentValue = newValue;
        }
        //System.out.println(Arrays.toString(scores));
        //System.out.println(Arrays.toString(ranks));

        return ranks;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int scoresCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] scores = new int[scoresCount];

        String[] scoresItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < scoresCount; i++) {
            int scoresItem = Integer.parseInt(scoresItems[i]);
            scores[i] = scoresItem;
        }

        int aliceCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] alice = new int[aliceCount];

        String[] aliceItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < aliceCount; i++) {
            int aliceItem = Integer.parseInt(aliceItems[i]);
            alice[i] = aliceItem;
        }

        int[] result = climbingLeaderboard(scores, alice);

        for (int i = 0; i < result.length; i++) {
            bufferedWriter.write(String.valueOf(result[i]));

            if (i != result.length - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
