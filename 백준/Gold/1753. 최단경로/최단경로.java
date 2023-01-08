import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int V,E,K;
	static int[] distance;
	static boolean[] visited;
	static ArrayList<Edge>[] list;
	static PriorityQueue<Edge> pq = new PriorityQueue<>();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken()); //정점의 개수
		E = Integer.parseInt(st.nextToken()); //간선의 개수
		K = Integer.parseInt(br.readLine()); //시작 정점의 번호
		distance = new int[V+1];
		visited = new boolean[V+1];
		list = new ArrayList[V+1];
		for(int i = 1; i<= V; i++) list[i] = new ArrayList<Edge>();
		for(int i = 0; i<= V; i++) distance[i] = Integer.MAX_VALUE;
		for(int i = 0; i< E; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			list[u].add(new Edge(v,w));
		}
		pq.add(new Edge(K,0));
		distance[K] = 0;
		while(!pq.isEmpty()) {
			Edge cur = pq.poll();
			int c_v = cur.vertex;
			if(visited[c_v]) continue;
			visited[c_v] = true;
			for(int i = 0; i<list[c_v].size(); i++) {
				Edge tmp = list[c_v].get(i);
				int next = tmp.vertex;
				int val = tmp.val;
				if(distance[next] > distance[c_v] + val) {
					distance[next] = val + distance[c_v];
					pq.add(new Edge(next, distance[next]));
				}
			}
		}
		for(int i = 1; i<=V; i++) {
			if(visited[i]) sb.append(distance[i]+"\n");
			else sb.append("INF\n");
		}
		System.out.print(sb.toString());
	}
}

class Edge implements Comparable<Edge>{
	int vertex;
	int val;
	Edge(int vertext, int val){
		this.vertex = vertext;
		this.val = val;
	}
	@Override
	public int compareTo(Edge e) {
		if(this.val > e.val) return 1;
		else return -1;
	}
}
