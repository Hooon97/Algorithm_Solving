import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int N, M, cnt;
	static boolean[] visitDfs;
	static LinkedList<Integer> dfs; 
	static LinkedList<Integer> bfs;
	static LinkedList<Integer>[] graph;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		N = sc.nextInt();
		M = sc.nextInt();
		int start = sc.nextInt();
		graph = new LinkedList[N+1];
		dfs = new LinkedList<>();
		visitDfs = new boolean[N+1];
		bfs = new LinkedList<>();
		for(int i = 1; i<=N; i++)
			graph[i] = new LinkedList<>();
		for(int i = 0; i<M; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			graph[a].add(b);
			graph[b].add(a);
		}
		for(int i = 1; i<=N; i++)
			Collections.sort(graph[i]);
		cnt = 0;
		dfs(start);
		bfs(start);
		for(int i : dfs)
			sb.append(i+" ");
		sb.append("\n");
		for(int i : bfs)
			sb.append(i+" ");	
		System.out.println(sb.toString());
		sc.close();
	}
	static void dfs(int Node) {
		if(cnt >= N)
			return;
		dfs.add(Node);
		visitDfs[Node] = true;
		for(int i : graph[Node]) {
			if(visitDfs[i]) continue;
			visitDfs[i] = true;
			dfs(i);
		}
		
	}
	static void bfs(int Node) {
		Queue<Integer> q = new LinkedList<>();
		boolean[] visited = new boolean[N+1];
		q.add(Node);
		visited[Node] = true;
		bfs.add(Node);
		while(!q.isEmpty()) {
			int cur = q.poll();
			for(int i : graph[cur]) {
				if(visited[i]) continue;
				bfs.add(i);
				visited[i] = true;
				q.add(i);
			}
		}
	}
	
}
