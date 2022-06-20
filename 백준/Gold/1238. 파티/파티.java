import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

//1. 유향 그래프임
//2. 모든 학생들은 X까지 최단 거리로 갔다가, 본인의 번호까지 최단 범위로 돌아와야함.
//3. 최단 경로...? 다익스트라..
//3.1. x에서의 다익스트라 + 모든 노드에서 x까지의 최단 거리의 합 -> 그 중 가장 오래 걸리는 값이 답
public class Main {
	public static class Node implements Comparable<Node>{
		int idx;
		int value;
		Node(int idx, int value){
			this.idx = idx;
			this.value = value;
		}
		@Override
		public int compareTo(Node o) { //Node의 value에 대한 Priority Queue
			if(this.value < o.value)
				return -1;
			else
				return 1;
		}
	}
	
	static int N,M,X;
	static ArrayList<ArrayList<Node>> graph;
	static boolean[] visited;
	static int[][] dist;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); //Node의 개수 : 학생의 수
		M = sc.nextInt(); //다리의 개수 : 간선의 수
		X = sc.nextInt(); //파티가 일어나는 장소
		
		//다익스트라를 위한 그래프 선언, 입력하기
		graph = new ArrayList<ArrayList<Node>>();
		for(int i = 0; i<N+1; i++) graph.add(new ArrayList<>());
		
		for(int i = 0; i<M; i++) {
			int st = sc.nextInt();
			int ed = sc.nextInt();
			int val = sc.nextInt();
			graph.get(st).add(new Node(ed, val));
		}
		
		visited = new boolean[N+1]; //방문처리
		dist = new int[N+1][N+1]; //거리값 저장
		for(int i = 0; i<N+1; i++) {
			for(int j = 0; j<N+1; j++)
				dist[i][j] = Integer.MAX_VALUE;
		}
		
		int ans = -1;
		for(int i = 1; i<N+1; i++) dijkstra(i);
		for(int i = 1; i<N+1; i++) {
			//X에서 i로의 최단경로 + i의 집에서 X로의 최단경로
			int tmp = dist[X][i] + dist[i][X];
			if(ans < tmp) ans = tmp;
		}
		
		System.out.println(ans);
		
		sc.close();
	}
	
	public static void dijkstra(int st) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.offer(new Node(st,0));
		dist[st][st] = 0;
		
		while(!pq.isEmpty()) {
			Node cur = pq.poll();
			
			int curVal = cur.value;
			int curIdx = cur.idx;
			
			//현재 노드 curIdx까지의 거리가 현재 노드까지의 가진 
			if(dist[st][curIdx] < curVal) continue;
		
			for(int i = 0; i<graph.get(curIdx).size(); i++) {
				int tmpCost = dist[st][curIdx] + graph.get(curIdx).get(i).value;
				
				if(tmpCost < dist[st][graph.get(curIdx).get(i).idx]) {
					dist[st][graph.get(curIdx).get(i).idx] = tmpCost;
					pq.offer(new Node(graph.get(curIdx).get(i).idx, tmpCost));
				}
			}
		}

	}
}
