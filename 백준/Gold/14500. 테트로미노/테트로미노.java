import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int N,M,ans;
	static int[][] map;
	static boolean[][] visit;
	static int[] drs = {-1, 1, 0, 0};
	static int[] dcs = {0, 0, -1, 1};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// dfs로 커버 가능한 경우의 수는 한 붓 그리기가 가능해야 한다.
		N = sc.nextInt();
		M = sc.nextInt();
		map = new int[N][M];
		visit = new boolean[N][M];
		ans = 0;
		
		for(int i = 0; i<N; i++) {
			for(int j = 0; j<M; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		for(int i = 0; i<N; i++) {
			for(int j = 0; j<M; j++) {
				dfs(i,j,0,0);
				mid(i,j);
			}
		}
		System.out.println(ans);
		sc.close();
	}

	public static void dfs(int i, int j, int idx, int sum) {
		if(idx >= 4) {
			if(ans < sum) ans = sum;
			return;
		}
		
		for(int t = 0; t<4; t++) {
			int dr = i+drs[t];
			int dc = j+dcs[t];
			if(dr < 0 || dr>=N || dc <0 || dc >= M || visit[dr][dc]) continue;
			visit[dr][dc] = true;
			dfs(dr, dc, idx+1, sum+map[dr][dc]);
			visit[dr][dc] = false;
		}
	}
	
	public static void mid(int i, int j) {
		//4가지 경우의 수
		if(i-1>=0 && i+1 <N) {
			if(j+1<M) {
				int sum = map[i-1][j]+map[i][j]+map[i+1][j]+map[i][j+1];
				if(ans < sum) ans = sum;
			}
			if(j-1>=0) {
				int sum = map[i-1][j]+map[i][j]+map[i+1][j]+map[i][j-1];
				if(ans < sum) ans = sum;
			}
		}
		
		if(j-1>=0 && j+1 <M) {
			if(i+1<N) {
				int sum = map[i][j+1]+map[i][j]+map[i][j-1]+map[i+1][j];
				if(ans < sum) ans = sum;
			}
			if(i-1>=0) {
				int sum = map[i][j+1]+map[i][j]+map[i][j-1]+map[i-1][j];
				if(ans < sum) ans = sum;
			}
		}
		
	}
}
