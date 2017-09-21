
public class MyScope {
/**	This homework has 4 problems. Your answers must be complete English sentences. Avoid using vague pronoun references.
*	Avoid circular explanations. Avoid passive voice. It would be bad because this is that.
*
*	Question 1: What does the following code print out (feel free to run it to find out.)?
*
*	The code prints out 3, 3.14, 3, 7, 7, 88, 2, and 2.7, each separated by a line.
*
*
*	Question 2: The number 7 gets printed out twice in a row, but the number 88 is followed by a 2. Why?
*	
*		b is defined as a static variable, which means that it will stay the same across each instance, and if it is changed,
*	then it will be changed for every instance. Across all of the objects of a class, a static variable will only hold one
*	value at a given time. On line 45, MyInstance defines b as 7, so that means that all of the instances of MyScope now
*	have b at a value of 7. So, when MyInstance calls b on line 46, as it was clearly defined, the line returns 7. And, for
*	MyOtherInstance, b is also printed out as 7, because since b is static and therefore the same across all instances of
*	the class MyScope.
*		a is not defined as static, which means it defaults to accessible only by instances. Therefore, unlike b, a can be
*	defined differently for each instance. Across all of the objects of a class, a non-static variable can hold different
*	values in different instances at a given time. On line 48, when MyInstance.a is set to 88, the a value ONLY in
*	MyInstance is set to 88. In the instance MyOtherInstance, the a value is still set to the default value of 2. So, as
*	shown by the printed out code, when MyInstance.a is called on line 49, the value printed is 88, as changed on line 48.
*	On line 49, when the a for MyOtherInstance is called, the value printed out is 2, unaltered from its original value.
*
*
*	Question 3: The first value printed out is that of MyScope.b. If we try to print MyScope.a, what happens, and why?
*
*		If we tried to print MyScope.a, Eclipse would give an error, because a is not defined as static. a is only defined as
* 	int, and therefore defaults to only being accessible through a class instance. Being accessible by a class instance
* 	means that myInstance and myOtherInstance can call a directly, since it is not private (ex: myInstance.a). But, MyScope
* 	itself, as a class, cannot call a without an instance. Therefore, since MyScope cannot call a, MyScope.a will return
* 	with an error.
*/
		int a = 2;
		static int b = 3;
		public static void main(String[] args) {
			MyScope myInstance = new MyScope();
			MyScope myOtherInstance = new MyScope();
			double a = 3.14;
			double b = 2.7;
			System.out.println(MyScope.b);
			System.out.println(a);
			System.out.println(myInstance.b);
			myInstance.b = 7;
			System.out.println(myInstance.b);
			System.out.println(myOtherInstance.b);
			myInstance.a = 88;
			System.out.println(myInstance.a);
			System.out.println(myOtherInstance.a);
			System.out.println(b);
		}
}

/**
*	Question 4 (hard, do your best): Identify a way to generalize the way one can establish the scope of a variable.
*	If you wish, you can invent a new declaration mechanism, for example you might say:  
*
*  I wish to make it possible to declare a variable using the special word personal.
*	This makes a local variable in all methods, it would look like this:
*
*
*	public class NewScope {
*	  	personal int a = 1;
*
*		public static void main (String[] args) {
*			NewScope ns = new NewScope();
*(error)	ns.a = 3;
*			System.out.println(ns.a * 4);
*			int b = 7;
*			if (a == b) {
*				System.out.println("true");
*			} 
*			
*		}
*
*	}
*	
*		If a variable is public, then an instance is allowed to both call the variable's value AND change it. If a variable
*	is private, then an instance has to use a separate accessor (setter) and modifier (getter) method to both obtain the
*	value of the variable and change that value. My declaration personal is a creation between public and private. It will
*	allow an instance to call the variable's value, but leaves them unable to change it. The only way to change it would be
*	through another setter method. Therefore, if the creator wants to create a variable that the user can access and not
*	change, they can use personal. This idea is helpful when the creator wants a constant value that doesn't require a
*	getter method, which increases the ease of use for any scenario neccessary, But, they don't want to be able the user in
*	main to be able to change it, only call it. Unlike just declaring public final, the value can be changed by a getter
*	method if desired, AND can be changed internally. MAIN GIST OF PERSONAL: Personal will allow users to easily make their
*	value publicly accessible without having to risk the possibility of change. And, if they do decide to end up changing
*	it, they can create a getter method or change the declaration, therefore up to the creator to decide if they want the
*	value changed. One main argument against personal is its similarity to public final, but as explained, it has a few
*	different aspects that allows it to be used in a completely different context and cater to many different needs.
*
*
*	Question 5: So, you thought there were only four questions, but here you are, reading further.
*	Very well, try this one: Is it a good idea to be able to change the scope of a variable based on a conditional value
*	that is not known until runtime? 
*
*		Yes, I believe in a certain condition, changing the scope for a variable based on an unknown conditional value is a
*	good idea. Let's say you have code that creates a class Synopsis with a variable public static boolean x. This variable
*	x is defaulted to a value of 5. Synopsis is used in a game, where the user is expected to decide whether they want
*	a new character. If they want a new character, then x should be visible as 5, and seen by the user as 5. However, if
*	they decide to not have the new character, then x should return with an error. Also, if they decide in any other part
*	of the game that they	want the new character, by calling the specific method newCharacter(), then x should still be
*	stored in that method as 5. Therefore, in order to follow this exchange, we want to change x's scope based on the
*	decision that the user makes. If the user decides, out of the two options of true and false, true, then the user should
*	be able to access the value of 5. If they choose false, then the user should be unable to access the variable x, and it
*	should return as an error if they do try. Yes, there are other ways to perform this, but one of the	easier scenarios
*	would be to change x's scope. This use case is a clear place where we would want x's scope to change, and therefore
*	implementing it would be a good idea.
*	
*		Also, I believe that in other conditions, changing the scope of a variable based on an unknown conditional value is
*	a bad idea. By changing the scope of the variable, you could end up having errors throughout your code where you called
*	it. Or in a situation where you want to call it, you can't. Instead, it could be smarter to just set the value to 0, or
*	some other value that you set to return an error.
*
*		In conclusion, in some particular use cases, changing the scope of a variable based on an unknown value is an
*	easy option. However, if not used correctly or carefully, it can cause many errors and problems, and should be avoided
*	if not clearly easy.
*	
*	
*	
*/
