import java.util.Scanner;
import java.util.Stack;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		String origin = sc.next();
		Stack<Character> st = new Stack<>();
		
		for(int i = 0; i<origin.length(); i++) {
			char cur = origin.charAt(i);
			if(cur <= 90 && cur >= 65) { //알파벳인 경우
				sb.append(cur);
			}
			else {
				if(cur == '(') st.push(cur);
				else if(cur == ')') {
					while(!st.isEmpty()) {
						if(st.peek() == '(') {
							st.pop();
							break;
						}
						else sb.append(st.pop());
					}
				}
				else {
					while(!st.empty() && priority(st.peek()) >= priority(cur)) 
						sb.append(st.pop());
					st.push(cur);
				}
			}
		}
		
		while(!st.isEmpty()) {
			sb.append(st.pop());
		}
		System.out.println(sb.toString());
		sc.close();
	}
	
	public static int priority(char c) {
		switch(c) {
		case '*' : return 2;
		case '/' : return 2;
		case '(' : return 0;
		default : return 1;
		}
	}
}
