import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	public static class Edge implements Comparable<Edge>{
		int ed;
		int cost;
		Edge(int ed, int cost){
			this.ed = ed;
			this.cost = cost;
		}
		@Override
		public int compareTo(Edge o) {
			if(this.cost < o.cost) return -1;
			return 1;
		}
		
	}
	static ArrayList<Edge>[] Node;
	static int[] dist;
	static Scanner sc;
	static final int INF = Integer.MAX_VALUE;
	public static void main(String[] args) {
		sc = new Scanner(System.in);
		int V = sc.nextInt(); // 노드의 수
		int E = sc.nextInt(); // 간선의 수
		int st = sc.nextInt();
		Node = new ArrayList[V+1];
		dist = new int[V+1];
		for(int i = 0; i<V+1; i++) Node[i] = new ArrayList<>();
		input(E);
		dijkstra(st, V);
		
		for(int i = 1; i<=V; i++) {
			if(dist[i] != INF) System.out.println(dist[i]);
			else System.out.println("INF");
		}
		
		sc.close();
	}
	public static void input(int E) {
		for(int i = 0; i<E; i++) {
			int st = sc.nextInt();
			int ed = sc.nextInt();
			int cost = sc.nextInt();
			
//			for(int j = 0; j<Node[st].size(); j++)
//				if(Node[st].get(j).ed == ed) 
//					if(Node[st].get(j).cost < cost) continue;
			Node[st].add(new Edge(ed, cost));
		}
	}
	
	public static void dijkstra(int st, int V) {
		boolean[] visited = new boolean[V+1];
		
		Arrays.fill(dist, INF);
		dist[st] = 0;
		
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		pq.add(new Edge(st, 0));
		while(!pq.isEmpty()) {
			Edge cur = pq.poll();
			if(visited[cur.ed]) continue;
			for(Edge e : Node[cur.ed]) {
				int tmp = dist[cur.ed] + e.cost;
				if(!visited[e.ed] && dist[e.ed] > tmp) {
					dist[e.ed] = tmp;
					pq.add(new Edge(e.ed, dist[e.ed]));
				}
			}
		
		}
		
	}
}
