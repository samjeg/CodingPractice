import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
import java.lang.Math.*;
import java.lang.Integer.*;

public class MinimumDifference {

    public static void main(String[] args) throws IOException {
        int[] a = {-59, -36, -13, 1, -53, -92, -2, -96, -54, 75};
        System.out.println("Minimum Difference: "+minimumAbsoluteDifference(a));
        System.exit(0);    
    }

    // Complete the minimumAbsoluteDifference function below.
    static int minimumAbsoluteDifference(int[] arr) {
        mergesort(arr);
        int diff = Integer.MAX_VALUE;
        // System.out.println("max value: "+diff);
        for(int i=0; i<arr.length - 1; i++) {
            int nextDiff = Math.abs(arr[i] - arr[i+1]); 
            if(nextDiff < diff) {
                diff = nextDiff;
            }
        }
        
        return diff;
    }

    static void mergesort(int[] arr) {
        int[] helper = new int[arr.length];
        mergesort(arr, helper, 0, arr.length - 1);
    }

    static void mergesort(int[] arr, int[] helper, int low, int high) {
        if( low < high) { // why does low have to less than high?
            int middle = (low + high) / 2;
            mergesort(arr, helper, low, middle);
            mergesort(arr, helper, middle + 1, high);
            merge(arr, helper, middle, low, high); // why middle is added as an argument?
        }
    } 

    static void merge(int[] arr, int[] helper, int middle, int low, int high) {
        for(int i=low; i<=high; i++) {
            helper[i] = arr[i];
        }

        int helperLeft = low;
        int helperRight = middle + 1;
        int current = low;

        while(helperLeft <= middle && helperRight <= high) {
            if(helper[helperLeft] <= helper[helperRight]) {
                arr[current] = helper[helperLeft];
                helperLeft++;
            } else {
                arr[current] = helper[helperRight];
                helperRight++;
            }
            current++;
        }
        // why only getting remaining using the left side?
        int remaining = middle - helperLeft;
        for(int i=0; i<=remaining; i++) {
            arr[current + i] = helper[helperLeft + i];
        }
    }
}
