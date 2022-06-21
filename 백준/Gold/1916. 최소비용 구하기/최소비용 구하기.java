//골드5 다익스트라
//06.16 스터디
//26퍼-시간초과: scanner+dij(priorityque)
//scanner-> br로 바꿔도 똑같음

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static class Node implements Comparable<Node>{
		int to;
		int cost;
		Node(int to, int cost){
			this.to=to;
			this.cost=cost;
		}
		@Override
		public int compareTo(Node o) {
			if(this.cost < o.cost) return -1;
            else return 1;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		ArrayList<Node>[] list = new ArrayList[n+1];
		for(int i=0; i<n+1; i++)
			list[i]=new ArrayList<>();
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			list[from].add(new Node(to, cost));
		}
		st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		
		//다익스트라-우선순위큐
		boolean [] visited = new boolean [n+1];
		
		int [] res = new int [n+1];
		Arrays.fill(res, Integer.MAX_VALUE);
		
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(start, 0));
		res[start]=0;
		
		while(!pq.isEmpty()) {
			Node cur = pq.poll();
            if(visited[cur.to]) continue;
			visited[cur.to]=true;
			
			for(Node node: list[cur.to]) {
				if(visited[node.to]) continue;
				if(res[node.to]>res[cur.to]+node.cost)
					res[node.to]=res[cur.to]+node.cost;
				pq.add(new Node(node.to, res[node.to]));
			}			
		}
		System.out.println(res[end]);
	}
}