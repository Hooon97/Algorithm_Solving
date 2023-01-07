import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int N = sc.nextInt();
		int M = sc.nextInt();
		ArrayList<ArrayList<Integer>> A = new ArrayList<>();
		for(int i = 0; i<=N; i++) A.add(new ArrayList<>());
		int[] indegree = new int[N+1];
		for(int i = 0; i<M; i++) {
			int S = sc.nextInt();
			int E = sc.nextInt();
			A.get(S).add(E);
			indegree[E]++;
		}
		Queue<Integer> q = new LinkedList<>();
		for(int i = 1; i<=N; i++) {
			if(indegree[i] == 0) q.offer(i);
		}
		while(!q.isEmpty()) {
			int cur = q.poll();
			sb.append(cur+" ");
			for(int next : A.get(cur)) {
				indegree[next]--;
				if(indegree[next] == 0) q.offer(next);
			}
		}
		System.out.print(sb.toString());
		sc.close();
	}
}
