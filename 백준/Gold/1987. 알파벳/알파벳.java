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
	static int maxLeng, R, C;
	static char[][] map;
	static int[] dr = {1,-1,0,0};
	static int[] dc = {0,0,1,-1};
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.valueOf(st.nextToken());
		C = Integer.valueOf(st.nextToken());
		map = new char[R][C];
		boolean[] visit = new boolean[26]; //알파벳 체크
		for(int i = 0; i<R; i++) map[i] = br.readLine().toCharArray();
		maxLeng = 1;
		DFS(visit, 1, 0, 0);
		System.out.print(maxLeng);
	}
	public static void DFS(boolean[] visit, int depth, int r, int c) {
		if(depth > maxLeng) maxLeng = depth;
		visit[map[r][c]-'A'] = true;
		for(int i = 0; i<4; i++) {
			int drs = r + dr[i];
			int dcs = c + dc[i];
			if(isIn(drs,dcs) && !visit[map[drs][dcs] - 'A']) {
				boolean[] newVisit = deepCopy(visit); 
				DFS(newVisit, depth+1, drs, dcs);
			}
			
		}
	}
	public static boolean isIn(int r, int c) {
		if(r >= 0 && r < R && c >= 0 && c < C) return true;
		return false;
	}
	public static boolean[] deepCopy(boolean[] visit) {
		boolean[] newVisit = new boolean[visit.length];
		for(int i = 0; i<visit.length; i++) newVisit[i] = visit[i];
		return newVisit;
	}
}
