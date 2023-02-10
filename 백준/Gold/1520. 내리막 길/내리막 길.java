import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;
public class Main{
	static int R,C, count;
	static int[][] map;
	static int[][] dp;
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.valueOf(st.nextToken());
		C = Integer.valueOf(st.nextToken());
		map = new int[R][C];
		dp = new int[R][C];
		boolean[][] visit = new boolean[R][C]; 
		for(int i = 0; i<R; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j<C; j++) {
				map[i][j] = Integer.valueOf(st.nextToken());
				dp[i][j] = -1;
			}
		}
		
		System.out.print(DFS(visit, 0,0));
	}
	public static int DFS(boolean[][] visit, int r, int c) {
		if(r == R-1 && c == C-1) {
			return 1;
		}
		
		if(dp[r][c] == -1) {
			dp[r][c] = 0;
			for(int i = 0; i<4; i++) {
				int drs = r+dr[i];
				int dcs = c+dc[i];
				if(isIn(drs,dcs) && map[r][c] > map[drs][dcs] ) {
					dp[r][c] += DFS(visit, drs, dcs);
				}
			}
		}
		return dp[r][c];
	}
	public static boolean[][] cleanVisit(boolean[][] visit){
		for(int i = 0; i<R; i++) {
			for(int j = 0; j<C; j++) {
				visit[i][j] = false;
			}
		}
		return visit;
	}
	public static boolean isIn(int r, int c) {
		if(r >= 0 && r < R && c >= 0 && c < C) return true;
		return false;
	}
}
