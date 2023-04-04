import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{
	static ArrayList<Integer>[] A;
	static boolean[] visit;
	static StringBuilder sb;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		sb = new StringBuilder();
		int N = Integer.valueOf(st.nextToken());
		int M = Integer.valueOf(st.nextToken());
		int V = Integer.valueOf(st.nextToken());
		A = new ArrayList[N+1];
		visit = new boolean[N+1];
		for(int i = 1; i<N+1; i++) {
			A[i] = new ArrayList<>();
		}
		
		for(int i = 0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.valueOf(st.nextToken());
			int end = Integer.valueOf(st.nextToken());
			A[start].add(end);
			A[end].add(start);
		}
		
		for(int i = 1; i<N+1; i++) {
			Collections.sort(A[i]);
		}
		
		DFS(V);
		sb.append("\n");
		Arrays.fill(visit, false);
		BFS(V);
		
		System.out.print(sb.toString());
	}
	private static void DFS(int v) {
		if(visit[v]) return;
		visit[v] = true;
		sb.append(v+" ");
		for(int n : A[v]) {
			if(visit[n]) continue;
			DFS(n);
		}
	}
	private static void BFS(int v) {
		Queue<Integer> q = new LinkedList<>();
		q.add(v);
		visit[v] = true;
		sb.append(v+" ");
		
		while(!q.isEmpty()) {
			int cur = q.poll();
			for(int n : A[cur]) {
				if(visit[n]) continue;
				visit[n] = true;
				sb.append(n+" ");
				q.add(n);
			}
		}
	}
}

