package randomizer;

public class Randp {
	private int[] nums;
    private int numsLeft;
    
    public static void main(String[] args) {
    	
    	//Creates new object
    	Randp r = new Randp(6);
    	
    	//Test Print Out
    	for (int i = 1; i < 13; i++) {
    		System.out.println("Run " + i + ": " + r.nextInt());
    	}

    }
	
    //Constructor --> sets num length to n, sets numLeft to n, and runs initNums()
    public Randp(int n) {
    	nums = new int[n];
    	numsLeft = n;
    	initNums(n);
   }
	
    //initializes the nums array with ordered numbers from 1 to n
    private void initNums(int n) {
    	for (int i = 0; i < n; i++) {
        	nums[i] = i + 1;
    	}
    }
	
    //returns a random number between 1 and n once, and returns 0 once all of the numbers are taken
    public int nextInt() {
    	
    	//checks to see if numsLeft is 0 first
    	if (numsLeft == 0) return 0;
    	
    	//gives random index
    	int randIndex = (int) Math.floor(Math.random() * (nums.length));
    	
    	//while the index is 0, checks for another random number, until a number that has not been used yet is found
	    while(nums[randIndex] == 0) {
	   		randIndex = (int) Math.floor(Math.random() * (nums.length));
	   	}
	    
	    //sets the return value to the random number from index, and sets that index in the array to 0
	    int retval = nums[randIndex];
	    
	    nums[randIndex] = 0;
	    
	    //reduces numsLeft by 1
    	numsLeft--;
    	
    	//returns the return value
    	return retval;
    }
}
