package puzzle;
import java.util.ArrayList;

public class LogicalSentence {
	
	//Variables
	private PropositionConstant pc; //For every instance
	private LogicalSentence ls; //For the Negation class
	private LogicalSentence lsl; //For the Conjunction class
	private LogicalSentence lsr; //For the Conjunction class

	//Constructors - Empty
	public LogicalSentence(PropositionConstant pc) {
		this.pc = pc;
	}
	
	//Constructors - For Negation
	public LogicalSentence(LogicalSentence ls) {
		this.ls = ls;
		this.pc = ls.getpc();
	}
	
	//Constructors - For Conjunction
	public LogicalSentence(LogicalSentence lsl, LogicalSentence lsr) {
		this.lsl = lsl;
		this.lsr = lsr;
	}
	
	//Getters
	public LogicalSentence getlsl() {
		return lsl;
	}
	
	public LogicalSentence getlsr() {
		return lsr;
	}

	public PropositionConstant getpc() {
		return pc;
	}
	
	//Returns the end truth value of the logical sentence
	public boolean evaluate(TruthAssignment ta1) {
		
		//Uses the Truth Assignment method to get the truth value associated with the assigned propositional constant
		return ta1.getb(pc);
	}

}
