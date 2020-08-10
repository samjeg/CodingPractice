class Permutations {
	public static void main(String[] args) {
		char[] chars = {'a', 'b', 'c'};
		printAllRecursive(3, chars);
		System.exit(0);
	}

	public static void printAllRecursive(int n, char[] elements) {
	    if(n == 1) {
	        printArray(elements);
	    } else {
	        for(int i = 0; i < n-1; i++) {
	            printAllRecursive(n - 1, elements);
	            if(n % 2 == 0) {
	                swap(elements, i, n-1);
	            } else {
	                swap(elements, 0, n-1);
	            }
	        }
	        printAllRecursive(n - 1, elements);
	    }
	}

	private static void swap(char[] input, int a, int b) {
	    char tmp = input[a];
	    input[a] = input[b];
	    input[b] = tmp;
	}

	private static void printArray(char[] input) {
	    System.out.print('\n');
	    for(int i = 0; i < input.length; i++) {
	        System.out.print(input[i]);
	    }
	}
}