import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	//깊이가 5 이상인 DFS을 찾는 문제다.
	static boolean visited[];
	static ArrayList<Integer>[] A;
	static boolean arrive;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		arrive = false;
		int N = sc.nextInt(); //사람의 수
		int M = sc.nextInt(); //관계의 수
		A = new ArrayList[N];
		visited = new boolean[N];
		for(int i = 0; i<N; i++) A[i] = new ArrayList<Integer>();
		for(int i = 0; i<M; i++) {
			int s = sc.nextInt();
			int e = sc.nextInt();
			A[s].add(e);
			A[e].add(s);
		}
		for(int i = 0; i<N; i++) {
			DFS(i, 1); //i는 사람의 번호, 1은 최초 깊이
			if(arrive) break;
		}
		if(arrive) System.out.print("1");
		else System.out.print("0");
	}
	static void DFS(int now, int depth) {
		if(depth == 5 || arrive) {
			arrive = true;
			return;
		}
		visited[now] = true;
		for(int i : A[now]) {
			if(visited[i]) continue;
			DFS(i, depth+1);
		}
		visited[now] = false;
	}
}
