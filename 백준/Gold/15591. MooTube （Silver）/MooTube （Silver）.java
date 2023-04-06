import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main{
	static ArrayList<Node>[] A;
	static boolean[] visit;
	static int[] distance;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.valueOf(st.nextToken()); // 노드의 개수
		int Q = Integer.valueOf(st.nextToken()); // 테케의 개수
		A = new ArrayList[N+1];
		for(int i = 1; i<N+1; i++) {
			A[i] = new ArrayList<Node>();
		}
		distance = new int[N+1];
		for(int i = 1; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int n1 = Integer.valueOf(st.nextToken());
			int n2 = Integer.valueOf(st.nextToken());
			int val = Integer.valueOf(st.nextToken());
			A[n1].add(new Node(n2, val));
			A[n2].add(new Node(n1, val));
		}
		
		for(int i = 0; i<Q; i++) {
			visit = new boolean[N+1];
			Arrays.fill(distance, Integer.MAX_VALUE);
			
			st = new StringTokenizer(br.readLine());
			int USADO = Integer.valueOf(st.nextToken());
			int start_node = Integer.valueOf(st.nextToken());
			
			distance[start_node] = 0;
			dijkstra(start_node);
			
			int count = 0;
			for(int j = 1; j<N+1; j++) {
				if(distance[j] >= USADO) count++;
			}
			sb.append(count+"\n");
			
		}
		System.out.print(sb.toString());
	}
	public static void dijkstra(int start) {
		visit[start] = true;
		PriorityQueue<Node> pq = new PriorityQueue<Node>();
		pq.add(new Node(start, 0));
		while(!pq.isEmpty()) {
			Node cur = pq.poll();
			if(cur.idx == start) {
				for(Node n : A[cur.idx]) {
					if(visit[n.idx]) continue;
					if(distance[n.idx] > n.val) {
						distance[n.idx] = n.val;
						pq.add(new Node(n.idx, distance[n.idx]));
						visit[n.idx] = true;
					}
				}
			}
			else {
				for(Node n : A[cur.idx]) {
					if(visit[n.idx]) continue;
					int tmp = Math.min(cur.val, n.val);
					if(distance[n.idx] > tmp) {
						distance[n.idx] = tmp;
						pq.add(new Node(n.idx, distance[n.idx]));
						visit[n.idx] = true;
					}
				}
			}
		}
		
	}
	
	static class Node implements Comparable<Node>{
		int idx;
		int val;
		Node(int idx, int val){
			this.idx = idx;
			this.val = val;
		}
		
		@Override
		public int compareTo(Node o) {
			return this.val - o.val; 
		}
	}
}

