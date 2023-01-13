import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int[][] D;
		int T,N,K;
		D = new int[15][15];
		for(int i = 0; i < 15; i++) {
			D[i][1] = 1;
			D[0][i] = i;
		}
		for(int i = 1; i < 15; i++) {
			for(int j = 2; j < 15; j++) {
				D[i][j] = D[i][j-1] + D[i-1][j];
			}
		}
		
		T = Integer.parseInt(br.readLine());
		for(int i = 0; i<T; i++) {
			K = Integer.parseInt(br.readLine());
			N = Integer.parseInt(br.readLine());
			sb.append(D[K][N]+"\n");
		}
		System.out.print(sb.toString());
	}
}
