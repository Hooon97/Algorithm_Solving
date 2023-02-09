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
	static int size, M, N;
	static boolean[][] map;
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.valueOf(st.nextToken()); //열
		N = Integer.valueOf(st.nextToken()); //행
		int K = Integer.valueOf(st.nextToken());
		map = new boolean[M][N];
//		for(int i = 0; i<M+1; i++) {
//			map[i][0] = true;
//			map[i][N-1] = true;
//		}
//		for(int i = 0 ;i<N+1; i++) {
//			map[0][i] = true;
//			map[M+1][i] = true;
//		}
		for(int i = 0; i<K; i++) {
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.valueOf(st.nextToken()); //행
			int y1 = Integer.valueOf(st.nextToken()); //열
			int x2 = Integer.valueOf(st.nextToken());
			int y2 = Integer.valueOf(st.nextToken());
			
			// 0 > 4, 2 > 4
			for(int p = x1; p<x2; p++) {
				for(int q = y1; q<y2; q++) {
					map[q][p] = true;
				}
			}
		}
		int count = 0;
		//아래서부터 인덱스 에러
		for(int i = 0; i<M; i++) { //열
			for(int j = 0; j<N; j++) { //행
				if(!map[i][j]) {
					count++;
					size = 0;
					DFS(i,j);
					sb.append(size+" ");
				}
			}
		}
		
		//출력
		st = new StringTokenizer(sb.toString());
		int[] ans = new int[count];
		for(int i = 0; i<count; i++) ans[i] = Integer.valueOf(st.nextToken());
		Arrays.sort(ans);
		sb.setLength(0);
		sb.append(ans.length+"\n");
		for(int i = 0; i<ans.length; i++)
			sb.append(ans[i]+" ");
		System.out.print(sb.toString());
	}
	public static void DFS(int y, int x) {
		map[y][x] = true;
		size++;
		for(int i = 0; i<4; i++) {
			int dcs = x+dc[i];
			int drs = y+dr[i];
			if(!isIn(drs, dcs) || map[drs][dcs]) continue;
			map[drs][dcs] = true;
			DFS(drs, dcs);
		}
	}
	public static boolean isIn(int x, int y) {
		if(x >= 0 && x < M && y >= 0 && y < N) return true;
		return false;
	}
}
