import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static char[] dnaArray;
	static int[] conWindow;
	static int[] con;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int S = sc.nextInt(); // 문자열의 길이
		int P = sc.nextInt(); // 부분문자열의 길이
		String dna = sc.next();
		dnaArray = dna.toCharArray();
		con = new int[4]; //A C G T의 조건 개수
		conWindow = new int[4]; //슬라이딩 윈도우로 체크할 조건 개수
		for(int i = 0; i<4; i++) con[i] = sc.nextInt();
		int ans = 0;
		
		firstEdit(P);
		for(int i = P; i<S; i++) {
			if(conCheck()) {
				ans++;
			}
			plusEdit(dnaArray[i]);
			minusEdit(dnaArray[i-P]);
		}
		if(conCheck()) ans++;
		sb.append(ans);
		System.out.print(sb.toString());
		sc.close();
	}
	
	static void firstEdit(int P) {
		for(int i = 0; i<P; i++) {
			switch(dnaArray[i]) {
			case 'A' : conWindow[0]++;
			break;
			case 'C' : conWindow[1]++;
			break;
			case 'G' : conWindow[2]++;
			break;
			case 'T' : conWindow[3]++;
			break;
			}
		}
	}
	
	static void plusEdit(char dnaPiece) {
		switch(dnaPiece) {
		case 'A' : conWindow[0]++;
		break;
		case 'C' : conWindow[1]++;
		break;
		case 'G' : conWindow[2]++;
		break;
		case 'T' : conWindow[3]++;
		break;
		}
	}
	
	static void minusEdit(char dnaPiece) {
		switch(dnaPiece) {
		case 'A' : conWindow[0]--;
		break;
		case 'C' : conWindow[1]--;
		break;
		case 'G' : conWindow[2]--;
		break;
		case 'T' : conWindow[3]--;
		break;
		}
	}
	
	static boolean conCheck() {
		for(int i = 0; i<4; i++) {
			if(con[i] > conWindow[i]) return false;
		}
		return true;
	}
	
}
