class FibCalculator {
	public static void main(String[] args) {
	    System.out.println("fib 8: "+fib(8));
	    System.exit(0);
    }

    public static int fib(int n) {
        if(n <= 1) {
            return 1;
        }
        return fib(n - 1) + fib(n - 1);
    }
}

