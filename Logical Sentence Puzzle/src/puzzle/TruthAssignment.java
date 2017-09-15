package puzzle;
import java.util.ArrayList;

public class TruthAssignment {
	
	//Variables
	private ArrayList<PropositionConstant> pca; //Stores Proposition Constant
	private ArrayList<Boolean> ba; //Stores corresponding truth values as booleans
	
	public TruthAssignment() {
		
		//Initializes the variables as empty ArrayLists
		pca = new ArrayList<PropositionConstant>();
		ba = new ArrayList<Boolean>();
	}
	
	//Adds a Proposition Constant to the Proposition Constant ArrayLists and a boolean to the boolean ArrayList at the
	//same indexes
	public void put(PropositionConstant pc, boolean b) {
		pca.add(pc);
		ba.add(b);
	}
	
	//Finds the truth value associated with that Proposition Constant
	public boolean getb(PropositionConstant pc) {
		
		//Finds the index of the boolean ArrayList with the corresponding truth value by finding the index of the
		//Proposition Constant in the Proposition Constant ArrayList
		int bi = pca.indexOf(pc);
		
		//Returns the truth value by plugging the index found above into the boolean ArrayList
		return ba.get(bi);
	}
}
