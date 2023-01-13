import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static ArrayList<Integer>[] tree;
	static int[] depth;
	static int[] parent;
	static boolean[] visited;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		tree = new ArrayList[N+1];
		for(int i = 0; i<=N; i++) tree[i] = new ArrayList<Integer>();
		for(int i = 0; i<N-1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			tree[s].add(e);
			tree[e].add(s);
		}
		depth = new int[N+1];
		parent = new int[N+1];
		visited = new boolean[N+1];
		BFS(1);
		int M = Integer.parseInt(br.readLine());
		for(int i = 0; i<M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int LCA = executeLCA(a,b);
			sb.append(LCA+"\n");
		}
		System.out.println(sb.toString());
	}
	static int executeLCA(int a, int b) {
		if(depth[a] < depth[b]) {
			int tmp = a;
			a = b;
			b = tmp;
		}
		while(depth[a] != depth[b]) {
			a = parent[a];
		}
		while(a != b) {
			a = parent[a];
			b = parent[b];
		}
		return a;
	}
	
	static void BFS(int node) {
		Queue<Integer> q = new LinkedList<>();
		q.add(node);
		visited[node] = true;
		int level = 1;
		int now_size = 1;
		int count = 0;
		while(!q.isEmpty()) {
			int now_node = q.poll();
			for(int next : tree[now_node]) {
				if(!visited[next]) {
					visited[next] = true;
					q.add(next);
					parent[next] = now_node;
					depth[next] = level;
				}
			}
			count++;
			if(count == now_size) {
				count = 0;
				now_size = q.size();
				level++;
			}
		}
	}
}
