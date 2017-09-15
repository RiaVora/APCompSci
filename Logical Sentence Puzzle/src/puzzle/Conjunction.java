package puzzle;

public class Conjunction extends LogicalSentence{
	
	//Supers the constructor in Logical Sentence, because otherwise Logical Sentences could not be created in Conjunction
	public Conjunction(LogicalSentence lsl, LogicalSentence lsr) {
		super(lsl, lsr);
	}
	
	//Returns the end truth value of the logical sentences put together by the conjunction AND (&&)
	public boolean evaluate(TruthAssignment ta) {
		
		//Runs the evaluate in Logical Sentence on each side of the conjunction, and then runs those truth values through
		//the java syntax of the constructor AND (&&) and returns the result
		return (getlsl().evaluate(ta) && getlsr().evaluate(ta));
	}
}
