package priorityqueue;
import java.util.ArrayList;

	public class Pqueue {
		
		public static ArrayList<Integer> arr;
		
		public static void main(String args[]) {
			Pqueue pq = new Pqueue(); 
			insert(1);
			insert(1);
			insert(0);
			insert(9);
			insert(5);
			insert(-3);
			insert(100);
			insert(4);
			insert(8);
			insert(10);
			insert(94);
			System.out.println(arr);
		}
		
		public Pqueue() {
			 arr = new ArrayList<Integer>();
		}
		
		public static void insert(int p) {
			if(arr.isEmpty()) {
				arr.add(0, p);
			} else {
				for (int i = 0; i < arr.size(); i++) {
					if(arr.get(i) >= p ){
						arr.add(i, p);
						return;
					} else if (i == arr.size()-1) {
						arr.add(arr.size(), p);
						break;
					}
				}
			}
		}
		
	}
