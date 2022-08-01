import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	public static class Node implements Comparable<Node> {
		int d;
		int cost;

		Node(int d, int cost) {
			this.d = d;
			this.cost = cost;
		}

		@Override
		public int compareTo(Node o) {
			if (this.cost - o.cost < 0)
				return -1;
			else
				return 1;
		}
	}

	static ArrayList<Node>[] adj;
	static int[][] dist;
	static boolean[][] visited;
	static int N, M, K;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 0; tc < T; tc++) {
			N = sc.nextInt(); // 방의 개수
			M = sc.nextInt(); // 다리의 개수
			adj = new ArrayList[N + 1];
			for (int i = 1; i < N + 1; i++) {
				adj[i] = new ArrayList<Node>();
			}

			for (int i = 0; i < M; i++) {
				int st = sc.nextInt();
				int ed = sc.nextInt();
				int cost = sc.nextInt();
				adj[st].add(new Node(ed, cost));
				adj[ed].add(new Node(st, cost));
			}

			K = sc.nextInt(); // 친구의 수
			dist = new int[K][N + 1];
			for (int i = 0; i < K; i++) {
				for (int j = 0; j < N + 1; j++) {
					dist[i][j] = Integer.MAX_VALUE;
				}
			}

			visited = new boolean[K][N + 1];
			int[] friends = new int[K];
			for (int i = 0; i < K; i++)
				friends[i] = sc.nextInt();
			int result = dijkstra(friends);
			System.out.println(result);
		}
		sc.close();
	}

	public static int dijkstra(int[] friends) {
		int T = friends.length;
		for (int i = 0; i < T; i++) {
			PriorityQueue<Node> pq = new PriorityQueue<>();
			int curStart = friends[i];
			pq.add(new Node(curStart, 0));
			dist[i][curStart] = 0;
			while (!pq.isEmpty()) {
				Node cur = pq.poll();
				if (visited[i][cur.d])
					continue;
				else
					visited[i][cur.d] = true;

				for (Node next : adj[cur.d]) {
					int tmp = dist[i][cur.d] + next.cost;
					if (dist[i][next.d] > tmp) {
						dist[i][next.d] = tmp;
						pq.add(new Node(next.d, tmp));
					}
				}
			}
		}

		int sum = 0;
		int min = Integer.MAX_VALUE;
		int ans = -1;
		for (int j = 1; j < N + 1; j++) {
			for (int i = 0; i < K; i++) {
				sum += dist[i][j];
			}
			if(min > sum) {
				min = sum;
				ans = j;
			}
			sum = 0;
		}
		return ans;
	}

}
