import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{
	static int N, M;
	static String[][] map;
	static int[][] distance;
	static ArrayList<int[]> sharks;
	static boolean[][] visit;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.valueOf(st.nextToken());
		M = Integer.valueOf(st.nextToken());
		sharks = new ArrayList<>();
		map = new String[N][M];
		visit = new boolean[N][M];
		distance = new int[N][M];
		for(int i = 0; i<N; i++) {
			for(int j = 0; j<M; j++) {
				distance[i][j] = Integer.MAX_VALUE;
			}
		}
		
		for(int i = 0; i<N; i++) {
			map[i] = br.readLine().split(" ");
			for(int j = 0; j<map[i].length; j++) {
				if(map[i][j].equals("1")) {
					sharks.add(new int[]{i,j});
					distance[i][j] = Integer.MIN_VALUE;
				}
			}
		}
		
		for(int[] shark : sharks) {
			int[][] tmpDis = new int[N][M];
			visit[shark[0]][shark[1]] = true;
			bfs(shark[0], shark[1], tmpDis);
			cleanVisit();
			
//			for(int i = 0; i<N; i++)
//				System.out.println(Arrays.toString(tmpDis[i]));
//			System.out.println();
			
			for(int i = 0; i<N; i++) {
				for(int j = 0; j<M; j++) {
					distance[i][j] = Math.min(distance[i][j], tmpDis[i][j]);
				}
			}
		}
		
		int ans = Integer.MIN_VALUE;
		for(int i = 0; i<N; i++) {
			for(int j = 0; j<M; j++) {
				if(distance[i][j] == Integer.MIN_VALUE) continue;
				ans = Math.max(ans, distance[i][j]);
			}
		}
		System.out.print(ans);
	}
	private static void bfs(int i, int j, int[][] tmpDis) {
		int[] dr = {-1,-1,-1,1,1,1,0,0}; // 열
		int[] dc = {-1,1,0,-1,1,0,1,-1}; // 행
		Queue<Node> q = new LinkedList<>();
		q.add(new Node(i, j, 0));
		
		while(!q.isEmpty()) {
			Node cur = q.poll();
			
			for(int p = 0; p<dr.length; p++) {
				int drs = dr[p] + cur.r;
				int dcs = dc[p] + cur.c;
				if(drs < 0 || drs > N-1 || dcs < 0 || dcs > M-1) continue;
				if(visit[drs][dcs]) continue;
				visit[drs][dcs] = true;
				tmpDis[drs][dcs] = cur.dis+1;
				q.add(new Node(drs, dcs, cur.dis+1));
			}
		}
		
	}
	
	private static void cleanVisit() {
		for(int i = 0; i<N; i++) {
			for(int j = 0; j<M; j++) {
				visit[i][j] = false;
			}
		}
	}
}
class Node{
	int r;
	int c;
	int dis;
	Node(int r, int c, int dis){
		this.r = r;
		this.c = c;
		this.dis = dis;
	}
}

