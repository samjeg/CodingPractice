import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Ranker {
    public static void main(String[] args) {
        int[] scores = {100, 100, 50, 40, 40, 20, 10};
        int[] alice = {5, 25, 50, 120};
        int[] scores2 = {100, 90, 90, 80, 75, 60};
        int[] alice2 = {50, 65, 77, 90, 102};
        int[] scores3 = {102, 102, 102, 50, 30, 1};
        int[] alice3 = {20, 35, 102, 120};
        int[] scores4 = {300, 110, 50, 40, 20};
        int[] alice4 = {1, 15, 45, 299};
        int[] scores5 = {150, 100, 70, 70, 30};
        int[] alice5 = {0, 29, 30, 70, 151};

        int[] aliceRanking = climbingLeaderboard(scores2, alice2);
        for(int i=0; i<aliceRanking.length; i++) {
            System.out.print(alice2[i]+" - "+aliceRanking[i]+", ");
        }
        System.exit(0);
    }

    static int[] climbingLeaderboard(int[] scores, int[] alice) {
        int[] aliceRanking = new int[alice.length];
        int[] ranking = getRanking(scores);

        for(int i=0; i<alice.length; i++) {
            int scoreAlice = alice[i];
            aliceRanking = binarySearch(scores, ranking, alice, aliceRanking, i);
        }
        return aliceRanking;
    }

    static int[] binarySearch(int[] scrs, int[] rnkng, int[] alc, int[] alcRnkng, int p) {
        int left = 0;
        int right = scrs.length - 1;
        int mid = 0;
        int x = alc[p];
        boolean found = false;

        while(left <= right) {
            mid = (left + right) / 2;
            if(x < scrs[mid]) {
                left = mid + 1;
            } else if(x > scrs[mid]) {
                right = mid - 1;
            } else {
                alcRnkng[p] = rnkng[mid];
                found = true;
                break;
            } 
        }
        
        if(!found && mid == 0) {
            alcRnkng[p] = 1;
        } else if(!found && alc[p] < scrs[mid]) {
            alcRnkng[p] = rnkng[mid] + 1;
        } else if(!found && alc[p] > scrs[mid]) {
            alcRnkng[p] = rnkng[mid];
        }

        return alcRnkng;
    }

    static int[] getRanking(int[] scores) {
        int[] ranking = new int[scores.length];
        int rank = 1;
        ranking[0] = rank;
        int nextScore, score;
        for(int i=0; i<scores.length - 1; i++) {
            nextScore = scores[i+1];
            score = scores[i];
            if(nextScore < score) {
                rank++;
                ranking[i+1] = rank;
            } else {
                ranking[i+1] = rank;
            }
        }
        return ranking;
    }
}
