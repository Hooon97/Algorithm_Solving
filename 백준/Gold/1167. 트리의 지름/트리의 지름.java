import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	// dfs로 풀자.
	// 임의의 정점에서 가장 긴 거리 정점을 구하고,
	// 그 정점에서 가장 먼 정점의 거리를 구한다.
	public static class Edge{
		int node;
		int value;
		Edge(int node, int value){
			this.node = node;
			this.value = value;
		}
	}
	
	static ArrayList<Edge>[] list;
	static boolean[] visited;
	static int max = 0;
	static int node;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		list = new ArrayList[N+1];
		for(int i = 1; i<=N; i++) list[i] = new ArrayList<>();
		
		for(int i = 0; i<N; i++) { // 입력
			int st = sc.nextInt();
			while(true) {
				int ed = sc.nextInt();
				if(ed == -1) break;
				int val = sc.nextInt();
				list[st].add(new Edge(ed, val));
			}
		}
		
		//가장 긴 노드 찾기
		visited = new boolean[N+1];
		Dfs(2,0);
		
		for(int i = 0; i<N+1; i++) visited[i] = false;
		Dfs(node, 0);
		
		System.out.println(max);
		sc.close();
	}
	
	public static void Dfs(int ed, int leng) {
		if(leng > max) {
			max = leng;
			node = ed;
		}
		visited[ed] = true;
		
		for(int i = 0; i<list[ed].size(); i++) {
			Edge e = list[ed].get(i);
			if(!visited[e.node]) {
				Dfs(e.node, e.value+leng);
				visited[e.node] = true;
			}
		}
	}
}
