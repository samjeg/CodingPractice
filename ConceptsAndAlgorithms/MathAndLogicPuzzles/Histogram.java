public class Histogram {
	public static void main(String[] args) {
	    int[] arr = {3, 5, 7, 8, 2, 6};
	    int topValue = processHistogram(arr);

	    System.out.println("top value: "+topValue);
		System.exit(0);
	}


    public static int processHistogram(int[] arr) {
    	int bestSoFar = arr[0];

    	for(int i=0; i<arr.length; i++) {
    		int next = arr[i];

    		if(next > bestSoFar) {
    			bestSoFar = next;
    		}
    	}
    	return bestSoFar;
    }

}