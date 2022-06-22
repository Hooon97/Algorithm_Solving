import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.concurrent.SynchronousQueue;

// 1. 1에서 u까지 가는 최단 경로
// 2. u에서 v까지 가는 최단 경로
// 3. v에서 n까지 가는 최단 경로
// 4. 더하기

public class Main {
	public static class Edge implements Comparable<Edge>{
		int ed;
		int cost;

		Edge(int ed, int cost) {
			this.ed = ed;
			this.cost = cost;
		}

		@Override
		public int compareTo(Edge o) {
			if(this.cost < o.cost) return -1;
			else return 1;
		}
		
		
	}
	static ArrayList<Edge>[] map;
	static int N, M;
	static int[][] dist;
	static final int INF = 1000000;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); // 정점의 수
		M = sc.nextInt(); // 간선의 수
		map = new ArrayList[N+1];
		for(int i = 0; i<N+1; i++) map[i] = new ArrayList<Edge>();
		for(int i = 0; i<M; i++) {
			int st = sc.nextInt();
			int ed = sc.nextInt();
			int val = sc.nextInt();
			map[st].add(new Edge(ed, val));
			map[ed].add(new Edge(st, val));
		}
		int u = sc.nextInt();
		int v = sc.nextInt();
		dist = new int[N+1][N+1];
		for(int i = 1; i<N+1; i++)
			for(int j = 1; j<N+1; j++)
				dist[i][j] = INF;
		
		dijkstra(1);
		dijkstra(u);
		dijkstra(v);
		dijkstra(N);
		
		long tmpUV = INF;
		long tmpVU = INF;
		long ans = 0;
		if(routeUV(u,v)) tmpUV = dist[1][u] + dist[u][v] + dist[v][N];
		if(routeVU(u,v)) tmpVU = dist[1][v] + dist[v][u] + dist[u][N];
		ans = Math.min(tmpUV, tmpVU);
		if(ans != INF)
			System.out.println(ans);
		else
			System.out.println(-1);
		sc.close();
	}
	public static void dijkstra(int st) {
		boolean[] visited = new boolean[N+1];
		
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		pq.add(new Edge(st, 0));
		dist[st][st] = 0;
		
		while(!pq.isEmpty()) {
			Edge cur = pq.poll();
			if(visited[cur.ed]) continue;
			visited[cur.ed] = true;
			
			for(Edge e : map[cur.ed]) {
				int tmp = dist[st][cur.ed] + e.cost;
				if(!visited[e.ed] && dist[st][e.ed] > tmp ) {
					dist[st][e.ed] = tmp;
					pq.add(new Edge(e.ed, dist[st][e.ed]));
				}
			}
		}
	}
	
	public static boolean routeUV(int u, int v) {
		if(dist[1][u] != INF && dist[u][v] != INF && dist[v][N] != INF)
				return true;
		return false;
	}
	public static boolean routeVU(int u, int v) {
		if(dist[1][v] != INF && dist[v][u] != INF && dist[u][N] != INF)
				return true;
		return false;
	}
}
