import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N,M,K;
	static int[][] D;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		D = new int[202][202];
		for(int i = 0; i<=200; i++) {
			for(int j = 0; j<=i; j++) {
				if(j == 0 || j == i) D[i][j] = 1;
				else {
					D[i][j] = D[i-1][j-1] + D[i-1][j];
					if(D[i][j] > 1000000000) D[i][j] = 1000000001;
					//범위 초과 시 최댓값 저장
				}
			}
		}
		if(D[N+M][M] < K) {
			System.out.println("-1");
		}
		else {
			while(!(N == 0 && M == 0)) {
				if(D[N-1+M][M] >= K) {
					sb.append("a");
					N--;
				}
				else {
					sb.append("z");
					K -= D[N-1+M][M];
					M--;
				}
			}
		}
		System.out.print(sb.toString());
	}
}
