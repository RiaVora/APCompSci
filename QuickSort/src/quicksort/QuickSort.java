package quicksort;

/* Acknowledgments:
 * https://www.geeksforgeeks.org/quick-sort/, Geeks For Geeks, provided the code by Rajat Mishra for open use. My friend
 * Zage Strassberg-Phillips provided me with this link. I modified the 
 * 
 */
public class QuickSort {
	// Java program for implementation of QuickSort
	    /* This function takes last element as pivot, places the pivot element at its correct
	       position in sorted array, and places all smaller (smaller than pivot) to left of
	       pivot and all greater elements to right of pivot */
	    public int partition(int arr[], int low, int high) {
	        int pivot = arr[high]; 
	        int i = (low-1); // index of smaller element
	        for (int j=low; j<high; j++) {
	            // If current element is smaller than or equal to pivot
	            if (arr[j] <= pivot) {
	                i++;
	                // swap arr[i] and arr[j]
	                int temp = arr[i];
	                arr[i] = arr[j];
	                arr[j] = temp;
	            }
	        }
	 
	        // swap arr[i+1] and arr[high] (or pivot)
	        int temp = arr[i+1];
	        arr[i+1] = arr[high];
	        arr[high] = temp;
	 
	        return i+1;
	    }
	 
	 
	    /* The main function that implements QuickSort()
	      arr[] --> Array to be sorted,
	      low  --> Starting index,
	      high  --> Ending index */
	    
	    public void sort(int arr[], int low, int high) {
	        if (low < high) {
	            /* pi is partitioning index, arr[pi] is 
	              now at right place */
	            int pi = partition(arr, low, high);
	 
	            // Recursively sort elements before
	            // partition and after partition
	            sort(arr, low, pi-1);
	            sort(arr, pi+1, high);
	        }
	    }
	 
	    /* A utility function to print array of size n */
	    public static void printArray(int arr[]) {
	        int n = arr.length;
	        for (int i=0; i<n; ++i)
	            System.out.print(arr[i]+" ");
	        System.out.println();
	    }
	    
	    //this method assumes that the array is already sorted! If you want to sort the array, you can simply call the
	    //sort function before running this method.
	    public static double findMedian(int arr[]) {
	    	int half = arr.length/2;
	    	if (arr.length % 2 == 0) {
	    		double first = (double)arr[half - 1];
	    		double second = (double)arr[half];
	    		return (first + second)/2;
	    	} else {
	    		return arr[half];
	    	}
	    }
	 
	    // Driver program
	    public static void main(String args[]) {
	        int arr[] = {10, 7, 8, 9, 1, 5, 6};
	        int n = arr.length;
	 
	        QuickSort ob = new QuickSort();
	        ob.sort(arr, 0, n-1);
	 
	        System.out.println("sorted array");
	        printArray(arr);
	        System.out.println("median of array: " + findMedian(arr));
	    }
	/*This code is contributed by Rajat Mishra */
}

