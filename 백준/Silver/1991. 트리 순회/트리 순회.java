import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static int[][] tree;
	static StringBuilder sb;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		tree = new int[26][2];
		sb = new StringBuilder();
		for(int i = 0; i<N; i++) {
			String[] tmp = br.readLine().split(" ");
			int node = tmp[0].charAt(0)-'A';
			char left = tmp[1].charAt(0);
			char right = tmp[2].charAt(0);
			
			if(left == '.') tree[node][0] = -1;
			else tree[node][0] = left-'A';
			
			if(right == '.') tree[node][1] = -1;
			else tree[node][1] = right - 'A';
		}
		preOrder(0);
		sb.append("\n");
		inOrder(0);
		sb.append("\n");
		postOrder(0);
		System.out.print(sb.toString());
	}
	public static void preOrder(int now) {
		if(now == -1) return;
		sb.append((char)(now+'A') ); //현재 노드
		preOrder(tree[now][0]); //왼쪽 탐색
		preOrder(tree[now][1]); //오른쪽 탐색
	}
	public static void inOrder(int now) {
		if(now == -1) return;
		inOrder(tree[now][0]); //왼쪽 탐색
		sb.append((char)(now+'A') ); //현재 노드
		inOrder(tree[now][1]); //오른쪽 탐색
	}
	public static void postOrder(int now) {
		if(now == -1) return;
		postOrder(tree[now][0]); //왼쪽 탐색
		postOrder(tree[now][1]); //오른쪽 탐색
		sb.append((char)(now+'A') ); //현재 노드
	}
}