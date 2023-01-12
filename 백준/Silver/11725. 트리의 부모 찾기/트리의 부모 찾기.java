import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static boolean[] visited;
	static ArrayList<Integer>[] tree;
	static int[] answer;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());
		visited = new boolean[N+1];
		answer = new int[N+1];
		tree = new ArrayList[N+1];
		for(int i = 0; i<=N; i++) tree[i] = new ArrayList<Integer>();
		for(int i = 1; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			tree[n].add(m);
			tree[m].add(n);
		}
		DFS(1);
		for(int i = 2; i<=N; i++) sb.append(answer[i]+"\n");
		System.out.print(sb.toString());
	}
	static void DFS(int numb) {
		visited[numb] = true;
		for(int i : tree[numb]) {
			if(!visited[i]) {
				answer[i] = numb;
				DFS(i);
			}
		}
	}
}
