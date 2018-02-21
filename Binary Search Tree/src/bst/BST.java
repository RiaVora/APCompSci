package bst;

public class BST {
	private Integer datum;
	private BST left;
	private BST right;
	
	public static void main(String[] args) {
		BST bst = new BST(4);
		bst.randomTree();
		bst.printTree();
	}
	
	public BST (Integer datum) {
		this.datum = datum;
		
	}
	
	public Integer getDatum() {
		return datum;
	}
	
	public BST getLeft() {
		return left;
	}
	
	public BST setLeft(BST t) {
		left = t;
		return left;
	}
	
	public BST getRight() {
		return right;
	}
	
	public BST setRight(BST t) {
		right = t;
		return right;
	}
	
	public void printTree() {
		boolean finish = false;
		while(!finish) {
			if (getLeft() != null || getRight() != null) {
				if (getLeft() != null) pln(getLeft().toString());
				if (getRight() != null); pln(getRight().toString());
			} else {
				finish = true;
			}
		}
	}
	
	public String toString() {
		return "Datum is " + datum + ", depth is " + findDepth();
	}
	
	public int depth(BST n) {
		return findDepth() - n.findDepth();		
	}
	
	public int findDepth() {
		int count = 1;
		if (getLeft() != null || getRight() != null) {
			count++;
			if (getLeft() != null) return count + getLeft().findDepth();
			else return count + getRight().findDepth();
		} else {
			return count;
		}
	}
	
	public void insert(Integer x) {
		if (x <= datum) {
			goLeft(x);
		} else {
			goRight(x);
		}
	}
	
	public void randomTree() {
		for (int i = 0; i < 10; i++) {
			int x = (int)Math.floor(Math.random() * 11);
			pln("x is " + x);
		}
	}
	
	
	public int goLeft(int d) {
		if (getLeft() == null) {
			pln("this is the datum being added as a new left: " + d);
			BST n = new BST(d);
			setLeft(n);
		}
		if (d <= getLeft().getDatum()) {
			return getLeft().goLeft(d);
		} else {
			return getLeft().goRight(d);
		}
	}
	
	public int goRight(int d) {
		if (getRight() == null) {
			pln("this is the datum being added as a new right: " + d);
			BST n = new BST(d);
			setRight(n);
		}
		if (d <= getRight().getDatum()) {
			return getRight().goRight(d);
		} else {
			return getRight().goLeft(d);
		}
	}
	
	public static void p (Object args) {
		System.out.print(args);
	}

	public static void pln (Object args) {
		System.out.println(args);
	}

	
	
	
}
