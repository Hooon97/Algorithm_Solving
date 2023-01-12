import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static ArrayList<Integer>[] tree;
	static boolean[] visited;
	static int ans = 0;
	static int deleteNode = 0;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		tree = new ArrayList[N];
		visited = new boolean[N];
		int root = 0;
		for(int i = 0; i<N; i++) tree[i] = new ArrayList<Integer>();
		for(int i = 0; i<N; i++) {
			int p = Integer.parseInt(st.nextToken());
			if(p != -1) {
				tree[i].add(p);
				tree[p].add(i);
			}
			else root = i;
		}
		deleteNode = Integer.parseInt(br.readLine());
		if(deleteNode == root) System.out.println(0);
		else {
			DFS(root);
			System.out.println(ans);
		}
	}
	static void DFS(int number) {
		visited[number] = true;
		int cNode = 0;
		for(int i : tree[number]) {
			if(!visited[i] && i != deleteNode) {
				cNode++;
				DFS(i);
			}
		}
		if(cNode == 0) ans++;
	}
}
