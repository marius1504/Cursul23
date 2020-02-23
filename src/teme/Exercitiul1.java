package teme;

import java.util.ArrayDeque;
import java.util.Deque;
public class Exercitiul1 {
	private String parantheses = "()[]{}"; 
	private Deque<Character> listOfParantheses;
	
	public Exercitiul1() { 
		listOfParantheses = new ArrayDeque<>();
	}
	
	public static boolean checkValidity(String str) {
		Exercitiul1 pile = new Exercitiul1();
		
		for(int i=0; i<str.length(); i++) {
			int position = pile.parantheses.indexOf(str.charAt(i));
			if(position % 2 == 0) {
				pile.listOfParantheses.push(str.charAt(i));
			}else if(position % 2 == 1) {
				if(pile.listOfParantheses.isEmpty()) {
					return false;
				}else if(pile.listOfParantheses.peek() == pile.parantheses.charAt(position-1)) {
					pile.listOfParantheses.pop();
				}else {
					System.out.println("\t Nu este un sir valid de paranteze!");
					return false;				}
			}
		}
		if(!pile.listOfParantheses.isEmpty()) {
			return false;
		}else {
			return true;
		}
	}

	
	public static void main(String[] args) {
		String str = "()(([])){[[()]]}";

		if(checkValidity(str)) {
			System.out.println("\t Sirul \"" + str + "\" indeplineste conditiile!");
		}else {
			System.out.println("\t Sirul \"" + str + "\" NU indeplineste conditiile!");
		}
		
	}
}
