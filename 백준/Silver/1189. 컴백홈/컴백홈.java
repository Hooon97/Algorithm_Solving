import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{
	static int N, M, D, ans;
	static char[][] map;
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.valueOf(st.nextToken());
		M = Integer.valueOf(st.nextToken());
		D = Integer.valueOf(st.nextToken());
		map = new char[N][M];
		ans = 0;
		boolean[][] visit = new boolean[N][M];
		
		for(int i = 0; i<N; i++)
			map[i] = br.readLine().trim().toCharArray();
		
		visit[N-1][0] = true;
		Dfs(N-1, 0, 1, visit);
		System.out.print(ans);
	}
	private static void Dfs(int i, int j, int depth, boolean[][] visit) {
		if(depth == D && i == 0 && j == M-1) {
			ans++;
			return;
		}
		if(depth >= D) return;
		
		for(int p = 0; p<4; p++) {
			int drs = dr[p] + i;
			int dcs = dc[p] + j;
			if(drs < 0 || drs > N-1 || dcs < 0 || dcs > M-1) continue;
			if(visit[drs][dcs] || map[drs][dcs] == 'T') continue;
			visit[drs][dcs] = true;
			Dfs(drs,dcs, depth+1, visit);
			visit[drs][dcs] = false;
		}
	}
}

