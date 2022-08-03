import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
	public static class Tree implements Comparable<Tree> {
		int node;
		int length;
		int th;

		Tree(int node, int length) {
			this.node = node;
			this.length = length;
		}

		Tree(int node, int length, int th) {
			this.node = node;
			this.length = length;
			this.th = th;
		}

		@Override
		public int compareTo(Tree o) {
			if (this.length - o.length > 0)
				return 1;
			return -1;
		}
	}

	static int N, M;
	static int[] foxDist;
	static int[][] wolfDist;
	static ArrayList<Tree>[] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		StringTokenizer st1 = new StringTokenizer(str);
		N = Integer.parseInt(st1.nextToken()); // 그루터기의 수
		M = Integer.parseInt(st1.nextToken()); // 오솔길의 수
		foxDist = new int[N + 1];
		wolfDist = new int[2][N + 1];
		map = new ArrayList[N + 1];
		for (int i = 1; i < N + 1; i++)
			map[i] = new ArrayList<>();
		for (int i = 0; i < M; i++) {
			String str2 = br.readLine();
			StringTokenizer st2 = new StringTokenizer(str2);
			int st = Integer.parseInt(st2.nextToken());
			int ed = Integer.parseInt(st2.nextToken());
			int val = Integer.parseInt(st2.nextToken()) * 2;
			map[st].add(new Tree(ed, val));
			map[ed].add(new Tree(st, val));
		}
		for(int i = 1; i<N+1; i++) foxDist[i] = wolfDist[0][i] = wolfDist[1][i] = Integer.MAX_VALUE;

		foxDijkstra();
		wolfDijkstra();

		int ans = 0;
		
		for (int i = 1; i < N + 1; i++) {
			if (foxDist[i] < Math.min(wolfDist[0][i], wolfDist[1][i]))
				ans++;
		}
		System.out.println(ans);
	}

	public static void foxDijkstra() {
		boolean[] visited = new boolean[N + 1];
		PriorityQueue<Tree> pq = new PriorityQueue<>();
		foxDist[1] = 0;
		pq.add(new Tree(1, 0));
		while (!pq.isEmpty()) {
			Tree cur = pq.poll();
			if (visited[cur.node])
				continue;
			else
				visited[cur.node] = true;

			for (Tree t : map[cur.node]) {
				int tmp = t.length + foxDist[cur.node];
				if (foxDist[t.node] > tmp) {
					foxDist[t.node] = tmp;
					pq.add(new Tree(t.node, foxDist[t.node]));
				}
			}
		}
	}

	public static void wolfDijkstra() {
		PriorityQueue<Tree> pq = new PriorityQueue<>();
		wolfDist[1][1] = 0;
		pq.add(new Tree(1, 0, 1));
		while (!pq.isEmpty()) {
			Tree cur = pq.poll();

			if(wolfDist[cur.th%2][cur.node] < cur.length) continue;
			
			for (Tree t : map[cur.node]) {
				if (cur.th % 2 == 1) {
					int tmp = t.length/2 + wolfDist[1][cur.node];
					if (wolfDist[0][t.node] > tmp) {
						wolfDist[0][t.node] = tmp;
						pq.add(new Tree(t.node, wolfDist[0][t.node], cur.th+1));
					}
				}
				else {
					int tmp = t.length*2 + wolfDist[0][cur.node];
					if (wolfDist[1][t.node] > tmp) {
						wolfDist[1][t.node] = tmp;
						pq.add(new Tree(t.node, wolfDist[1][t.node], cur.th+1));
					}
				}
			}
		}
	}

}
