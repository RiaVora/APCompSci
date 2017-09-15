package puzzle;

public class Negation extends LogicalSentence{
	private LogicalSentence ls;
	
	//Supers the constructor in Logical Sentence, because otherwise Logical Sentence could not be created in Negation
	public Negation(LogicalSentence ls) {
		super(ls);
	}
	
	//Returns the end truth value of the negation of the logical sentence
	public boolean evaluate(TruthAssignment ta) {
		
		//Runs the evaluate in Logical Sentence, and the ! switches to the opposite boolean and returns that value
		return !super.evaluate(ta);
	}
}
