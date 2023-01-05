import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static boolean[] visited;
	static int[] ans;
	static ArrayList<Integer>[] A;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		A = new ArrayList[N+1];
		ans = new int[N+1];
		for(int i = 0; i<=N; i++) A[i] = new ArrayList<Integer>();
		for(int i = 0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int S = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());
			A[S].add(E);
		}
		for(int i = 1; i<=N; i++) {
			visited = new boolean[N+1];
			BFS(i);
		}
		int maxVal = 0;
		for(int i = 1; i<=N; i++) {
			maxVal = Math.max(maxVal, ans[i]);
		}
		for(int i = 1; i<=N; i++) {
			if(ans[i] == maxVal) sb.append(i).append(" ");
		}
		System.out.print(sb.toString());
	}
	static void BFS(int idx) {
		Queue<Integer> q = new LinkedList<>();
		q.add(idx);
		visited[idx] = true;
		while(!q.isEmpty()) {
			int cur = q.poll();
			for(int i : A[cur]) {
				if(!visited[i]) {
					visited[i] = true;
					ans[i]++;
					q.add(i);
				}
			}
		}
	}
}
