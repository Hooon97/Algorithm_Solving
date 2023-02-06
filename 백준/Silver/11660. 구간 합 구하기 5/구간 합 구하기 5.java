import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int N = Integer.valueOf(st.nextToken()); // 크기
		int M = Integer.valueOf(st.nextToken()); // 횟수
		int[][] sum = new int[N][N+1];

		//모든 범위에 대한 누적합
		for(int i = 0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1; j<N+1; j++) {
				sum[i][j] = sum[i][j-1] + Integer.valueOf(st.nextToken());
			}
			if(i != N-1) {
				sum[i+1][0] = sum[i][N];
			}
		}
		
		for(int i = 0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.valueOf(st.nextToken())-1;
			int y1 = Integer.valueOf(st.nextToken());
			int x2 = Integer.valueOf(st.nextToken())-1;
			int y2 = Integer.valueOf(st.nextToken());
			int ans = 0;
			for(int r = x1; r<=x2; r++) {
				ans += sum[r][y2] - sum[r][y1-1];
			}
			sb.append(ans+"\n");
		}
		System.out.print(sb.toString());
	}
}
