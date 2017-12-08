package mapcar;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.*;
import java.util.stream.Collectors;



public class Mapcar {
	//mapcar takes a function and a list, and implements that function on that list.
	//For example, if you want to square each n in a list of 6 integers, you pass mapcar the square function and the list
	//of integers
	//(1, 2, 3) --> (1, 4, 9)
	//Yes, this is exactly the same thing as a for-each method, but written more concisely
	
	public static void main (String[] args) {
		List<Integer> is = new ArrayList<Integer>();
		is.add(2);
		is.add(3);
		is.add(4);
		System.out.println("The original array: " + is);
		System.out.println("Now, we use mapcar to square each element (multiply by itself)!");
		
		is = mapcar(is, i -> i*i);
		System.out.println("The changed array: " + is);
	}
	
	public static <LIST_TYPE, ELEM_TYPE> List<LIST_TYPE> mapcar(Collection<ELEM_TYPE> list, Function<ELEM_TYPE, LIST_TYPE> function)
	{
	    return list.stream().map(function).collect(Collectors.toList());
	}

	
}
