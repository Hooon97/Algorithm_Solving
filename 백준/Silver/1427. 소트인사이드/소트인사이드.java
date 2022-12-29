import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String numberOrigin = br.readLine();
		int[] number = new int[numberOrigin.length()];
		for(int i = 0; i<number.length; i++) number[i] = numberOrigin.charAt(i) - '0';
		
		for(int i = 0; i<number.length; i++) {
			int Max = i;
			for(int j = i+1; j<number.length; j++) {
				if(number[j] > number[Max]) Max = j;
			}
			if(number[i] < number[Max]) {
				int tmp = number[i];
				number[i] = number[Max];
				number[Max] = tmp;
			}
		}
		for(int i = 0; i<number.length; i++) sb.append(number[i]);
		System.out.print(sb.toString());
		br.close();
	}
}
