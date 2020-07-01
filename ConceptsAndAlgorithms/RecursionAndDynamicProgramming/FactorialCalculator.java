import java.util.*;

class FactorialCalculator {
	
	public static void main(String[] args) {
        // System.out.println("recursive facd ctorial: "+recursiveFactorial(10));
        System.out.println("iterative factorial: "+iterativeFactorial(5));
        System.exit(0);
	}

	public static int recursiveFactorial(int n) {
        if(n < 1){
           return 0;
        }
        return recursiveFactorial(n - 1) + n; 
	}

	public static int iterativeFactorial(int n) {
	    int total = n;

	    for(int i=n - 1; i>0; i--) {
            total *= i;    
            System.out.println("rec n: "+i);
	    }
	    return total;
	}
}