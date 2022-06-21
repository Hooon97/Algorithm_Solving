import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][] numTri = new int[N][N+1];
		for(int i = 0; i<N; i++) {
			for(int j = 1; j<=i+1; j++) {
				numTri[i][j] = sc.nextInt();
			}
		}
		int[][] dp = new int[N][N+1];
		dp[0][1] = numTri[0][1];
		for(int i = 1; i<N; i++)
			for(int j = 1; j<=i+1; j++)
				dp[i][j] = Math.max(dp[i-1][j-1]+numTri[i][j], dp[i-1][j]+numTri[i][j]);
		
		//최대값 검사
		int max = -1;
		for(int i = 1; i<N+1; i++) max = Math.max(max, dp[N-1][i]);
		
		System.out.println(max);
		sc.close();
	}
}
