import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

//출발 도시에서 도착 도시까지의 최소 비용을 구하는거면.. 다익스트라?
public class Main {
	public static class Bus implements Comparable<Bus>{
		int node;
		int cost;
		Bus(int node, int cost){
			this.node = node;
			this.cost = cost;
		}
		@Override
		public int compareTo(Bus o) {
			if(this.cost < o.cost) return -1;
			else return 1;
		}
		
	}
	static int N, M;
	static ArrayList<Bus>[] adjList;
	static boolean[] visited;
	static int[] dist;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); // 도시의 개수
		M = sc.nextInt(); // 버스의 개수
		
		adjList = new ArrayList[N+1];
		for(int i = 0; i<N+1; i++) adjList[i] = new ArrayList<>();
		for(int i = 0; i<M; i++) {
			int st = sc.nextInt();
			int ed = sc.nextInt();
			int val = sc.nextInt();
			adjList[st].add(new Bus(ed, val));
		}
		
		visited = new boolean[N+1];
		dist = new int[N+1];
		for(int i = 0; i<N+1; i++) dist[i] = Integer.MAX_VALUE;
		
		int st = sc.nextInt();
		int ed = sc.nextInt();
		dijkstra(st);
		System.out.println(dist[ed]);
		
		sc.close();
	}
	public static void dijkstra(int st) {
		PriorityQueue<Bus> pq = new PriorityQueue<>();
		pq.add(new Bus(st, 0));
		dist[st] = 0;
		
		while(!pq.isEmpty()) {
			Bus cur = pq.poll();
			if(visited[cur.node]) continue;
			visited[cur.node] = true;
			
			for(Bus bus : adjList[cur.node]) {
				if(!visited[bus.node] && dist[bus.node] > dist[cur.node] + bus.cost) {
					dist[bus.node] = dist[cur.node] + bus.cost;
					pq.add(new Bus(bus.node, dist[bus.node]));
				}
			}
		}
	}
}
