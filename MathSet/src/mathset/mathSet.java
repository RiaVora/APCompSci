package mathset;
import java.util.HashSet;
import java.util.Set;

public class mathSet extends HashSet<Integer>{
	
	public static void main(String args[]) {
		Set<Integer> exSet1 = new HashSet<Integer>();
		exSet1.add(1); exSet1.add(2); exSet1.add(3);
		
		System.out.println(exSet1);
		
		Set<Integer> exSet2 = new HashSet<Integer>();
		exSet2.add(1); exSet2.add(3); exSet2.add(5);
		
		System.out.println(exSet2);

		System.out.println("Union:" + union(exSet1, exSet2));
		System.out.println("Intersection:" + intersection(exSet1, exSet2));
		
	}

	
	public static Set<Integer> union(Set<Integer> s, Set<Integer> c) {
		Set<Integer> set = new HashSet<Integer>();
		for(int e : s) {
			if(!(set.contains(e))) {
				set.add(e);
			}
		}
		for(int e : c) {
			if(!(set.contains(e))) {
				set.add(e);
			}
		}
		return set;
	}
	
	public static Set<Integer> intersection(Set<Integer> s, Set<Integer> c) {
		Set<Integer> set = new HashSet<Integer>();
		if(s.size() > c.size()) {
			for(int e : s) {
				if(c.contains(e)) {
					set.add(e);
				}
			}
		} else {
			for(int e : c) {
				if(s.contains(e)) {
					set.add(e);
				}
			}
		}
		return set;
	}
}
