import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int[] visited;
	static ArrayList<Integer>[] A;
	static int N,M,K,X;
	static List<Integer> answer;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); //도시의 개수
		int M = sc.nextInt(); //도로의 개수
		int K = sc.nextInt(); //거리 정보
		int X = sc.nextInt(); //출발 도시 번호
		A = new ArrayList[N+1];
		answer = new ArrayList<>();
		for(int i = 1; i<=N; i++) A[i] = new ArrayList<Integer>();
		
		for(int i = 0; i<M; i++) {
			int S = sc.nextInt();
			int E = sc.nextInt();
			A[S].add(E);
		}
		
		visited = new int[N+1];
		for(int i = 0; i<=N; i++) visited[i] = -1;
		BFS(X);
		for(int i = 0; i <= N; i++) {
			if(visited[i] == K) answer.add(i);
		}
		
		if(answer.isEmpty()) System.out.println("-1");
		else {
			Collections.sort(answer);
			for(int tmp : answer) System.out.println(tmp);
		}
		sc.close();
	}
	static void BFS(int Node) {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(Node);
		visited[Node]++;
		while(!queue.isEmpty()) {
			int cur = queue.poll();
			for(int i : A[cur]) {
				if(visited[i] == -1) {
					visited[i] = visited[cur] + 1;
					queue.add(i);
				}
			}
		}
	}
}
