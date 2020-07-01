

public class Sorter{
    public static void main(String[] args) {
        int[] arr = new int[] {
            1, 4, 7, 8, 2, 3, 0, 1 
        };
        for(int j=0; j<arr.length; j++) {
        	System.out.print(arr[j]+" ");
        }
        System.out.println("");

        arr = quicksort(arr, 0, arr.length - 1);

        for(int i=0; i<arr.length; i++) {
        	System.out.print(arr[i]+" ");
        }
	    System.exit(0);
    }

    public static int[] quicksort(int[] arr, int left, int right) {
        int index = partition(arr, left, right);
        
        System.out.println("quicksort: "+index+" left: "+left+" right: "+right);
        if(index - 1 > left) {
        	quicksort(arr, left, index - 1); // sort left half
        }
        if(index < right) {
        	 quicksort(arr, index, right); // sort right half
        }

        return arr;
    }

    public static int partition(int[] arr, int left, int right) {
    	int pivot = arr[(left + right) / 2];

    	while(left <= right) {
    		// find the value on the left that is out of place
    		while(arr[left] < pivot) left++;

    		//find the value on the right that is out of place
    		while(arr[right] > pivot) right--;

    		if(left <= right) {
    			swap(arr, left, right); // swap the out of place values
    			left++;
    			right--;
    		} 
    	}
        return left;
    }

    public static void swap(int[] arr, int left, int right) {
    	int temp = arr[left];
    	arr[left] = arr[right];
    	arr[right] = temp;
    }   
}