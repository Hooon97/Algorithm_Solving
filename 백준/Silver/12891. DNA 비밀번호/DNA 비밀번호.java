import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main{
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.valueOf(st.nextToken()); // 길이
		int P = Integer.valueOf(st.nextToken()); // 비밀번호 길이
		String DNA = br.readLine();
		st = new StringTokenizer(br.readLine());
		int[] standard = new int[4]; //A C G T순서
		int[] myCheck = new int[4];
		for(int i = 0; i<4; i++) standard[i] = Integer.valueOf(st.nextToken());
		for(int i = 0; i<P; i++) {
			switch(DNA.charAt(i)) {
			case 'A' : myCheck[0]++;
			break;
			case 'C' : myCheck[1]++;
			break;
			case 'G' : myCheck[2]++;
			break;
			case 'T' : myCheck[3]++;
			break;
			}
		}
		int ans = 0;
		if(possiblePW(standard, myCheck)) ans++;
		
		for(int i = P; i<N; i++) {
			
			switch(DNA.charAt(i)) {
			case 'A' : myCheck[0]++;
			break;
			case 'C' : myCheck[1]++;
			break;
			case 'G' : myCheck[2]++;
			break;
			case 'T' : myCheck[3]++;
			break;
			}
			
			switch(DNA.charAt(i-P)) {
			case 'A' : myCheck[0]--;
			break;
			case 'C' : myCheck[1]--;
			break;
			case 'G' : myCheck[2]--;
			break;
			case 'T' : myCheck[3]--;
			break;
			}
			
			if(possiblePW(standard, myCheck)) ans++;
		}
		System.out.print(ans);
	}
	
	public static boolean possiblePW(int[] standard, int[] myCheck) {
		for(int i = 0; i<4; i++) {
			if(standard[i] > myCheck[i]) return false;
		}
		return true;
		
	}
}
