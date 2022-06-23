import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static class Node{
		int son;
		int cost;
		Node(int son, int cost){
			this.son = son;
			this.cost = cost;
		}
	}
	static ArrayList<Node>[] tree;
	static int leng, max, edge;
	static boolean[] visited;
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		tree = new ArrayList[N+1];
		visited = new boolean[N+1];
		for(int i = 0; i<N+1; i++) tree[i] = new ArrayList<Node>();
		
		for(int i = 0; i<N-1; i++) {
			int st = sc.nextInt();
			int ed = sc.nextInt();
			int cost = sc.nextInt();
			tree[st].add(new Node(ed, cost));
			tree[ed].add(new Node(st, cost));
		}
		
		edge = 1;
		DFS(1,0);
		Arrays.fill(visited, false);
		DFS(edge, 0);
		
		System.out.println(max);
		sc.close();
	}
	public static void DFS(int st, int leng) {
		if(max < leng) {
			max = leng;
			edge = st;
		}
		
		visited[st] = true;
		for(int i = 0; i<tree[st].size(); i++) {
			Node n = tree[st].get(i);
			if(!visited[n.son]) DFS(n.son, n.cost+leng);
		}
	}
}
