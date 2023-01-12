import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	static int[] parent;
	static int[][] map;
	static boolean[][] visited;
	static int N,M,sNum;
	static ArrayList<ArrayList<int[]>> sumList;
	static ArrayList<int[]> mlist;
	static PriorityQueue<bEdge> queue;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		visited = new boolean[N][M];
		for(int i = 0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		sNum = 1;
		sumList = new ArrayList<>();
		for(int i = 0; i<N; i++) {
			for(int j = 0; j<M; j++) {
				if(map[i][j] != 0 && !visited[i][j]) {
					BFS(i,j);
					sNum++;
					sumList.add(mlist);
				}
			}
		}
		
		queue = new PriorityQueue<>();
		for(int i = 0; i<sumList.size(); i++) {
			ArrayList<int[]> cur = sumList.get(i);
			for(int j = 0; j<cur.size(); j++) {
				int r = cur.get(j)[0];
				int c = cur.get(j)[1];
				int cur_S = map[r][c];
				for(int d = 0; d<4; d++) {
					int tmpR = dr[d];
					int tmpC = dc[d];
					int blength = 0;
					while(r+tmpR >= 0 && r+tmpR<N && c+tmpC >= 0 && c+tmpC <M ) {
						if(map[r+tmpR][c+tmpC] == cur_S) break;
						else if(map[r+tmpR][c+tmpC] != 0) {
							if(blength > 1) queue.add(new bEdge(cur_S, map[r+tmpR][c+tmpC], blength));
							break;
						}
						else blength++;
						
						if(tmpR < 0) tmpR--;
						else if(tmpR > 0) tmpR++;
						else if(tmpC < 0) tmpC--;
						else if(tmpC > 0) tmpC++;
					}
				}
			}
		}
		
		parent = new int[sNum];
		for(int i = 0; i<parent.length; i++) parent[i] = i;
		int useEdge = 0;
		int result = 0;
		while(!queue.isEmpty()) {
			bEdge now = queue.poll();
			if(find(now.s) != find(now.e)) {
				union(now.s,now.e);
				result += now.v;
				useEdge++;
			}
		}
		if(useEdge == (sNum -2)) {
			System.out.println(result);
		}
		else
			System.out.println("-1");
	}
	
	static void union(int a, int b) {
		a = find(a);
		b = find(b);
		if( a != b) parent[b] = a;
	}
	static int find(int a) {
		if(a == parent[a]) return a;
		else return parent[a] = find(parent[a]);
	}
	
	static void  BFS(int i, int j) {
		Queue<int[]> queue = new LinkedList<int[]>();
		mlist = new ArrayList<>();
		int[] st = {i,j};
		queue.add(st);
		mlist.add(st);
		visited[i][j] = true;
		map[i][j] = sNum;
		while(!queue.isEmpty()) {
			int now[] = queue.poll();
			int r = now[0];
			int c = now[1];
			for(int d = 0; d<4; d++) {
				int tmpR = dr[d];
				int tmpC = dc[d];
				while(r+tmpR >= 0 && r+tmpR<N && c+tmpC >= 0 && c+tmpC <M ) {
					if(!visited[r+tmpR][c+tmpC] && map[r+tmpR][c+tmpC] != 0)
						addNode(r+tmpR, c+tmpC, queue);
					else
						break;
					
					if(tmpR < 0) tmpR--;
					else if(tmpR > 0) tmpR++;
					else if(tmpC < 0) tmpC--;
					else if(tmpC > 0) tmpC++;
				}
			}
		}
	}
	
	static void addNode(int i, int j, Queue<int[]> queue) {
		map[i][j] = sNum;
		visited[i][j] = true;
		int[] tmp = {i,j};
		mlist.add(tmp);
		queue.add(tmp);
	}
	
	static class bEdge implements Comparable<bEdge>{
		int s,e,v;
		bEdge(int s, int e, int v){
			this.s = s;
			this.e = e;
			this.v = v;
		}
		
		@Override
		public int compareTo(bEdge o) {
			return this.v-o.v;
		}
	}
}
