import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		// 배열에 값 저장하기
		int[] number = new int[N];
		for(int i = 0; i<N; i++) number[i] = Integer.parseInt(br.readLine());
		
		for(int i = 0; i<N-1; i++) { // N-1번의 루프
			for(int j = 0; j<N-1-i; j++) {
				if(number[j] > number[j+1]) { //swap 조건
					int tmp = number[j];
					number[j] = number[j+1];
					number[j+1] = tmp;
				}
			}
		}
		for(int i = 0; i<N-1; i++) sb.append(number[i]+"\n");
		sb.append(number[N-1]);
		System.out.print(sb.toString());
		br.close();
	}
}
