import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	public static class Area implements Comparable<Area>{
		int no;
		int length;
		Area(int no,int length){
			this.no = no;
			this.length = length;
		}
		@Override
		public int compareTo(Area o) {
			if(this.length - o.length > 0) return 1;
			return -1;
		}
	}
	static ArrayList<Area>[] adj;
	static int n,m,r;
	static int[][] dist;
	static boolean[] visit;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int ans = 0;
		n = sc.nextInt(); // 지역의 수
		m = sc.nextInt(); // 수색 범위
		r = sc.nextInt(); // 길의 개수
		int[] items = new int[n+1];
		for(int i = 1; i<n+1; i++) items[i] = sc.nextInt();
		
		dist = new int[n+1][n+1];
		adj = new ArrayList[n+1];
		for(int i = 0; i<n+1; i++) adj[i] = new ArrayList<Area>();
		for(int i = 0; i<r; i++) {
			int st = sc.nextInt();
			int ed = sc.nextInt();
			int length = sc.nextInt();
			adj[st].add(new Area(ed, length));
			adj[ed].add(new Area(st, length));
		}
		
		for(int i = 0; i<n+1; i++) {
			for(int j = 0; j<n+1; j++) {
				dist[i][j] = Integer.MAX_VALUE;
			}
		}
		
		for(int i = 1; i<n+1; i++)
			dijkstra(i);
		
		for(int i = 1; i<n+1; i++) {
			int tmp = 0;
			for(int j = 1; j<n+1; j++) {
				if(dist[i][j] <= m) tmp += items[j];
			}
			if(ans < tmp) ans = tmp;
		}
		
		System.out.println(ans);
		sc.close();
	}
	public static void dijkstra(int i) {
		PriorityQueue<Area> pq = new PriorityQueue<>();
		visit = new boolean[n+1];
		dist[i][i] = 0;
		pq.add(new Area(i, 0));
		while(!pq.isEmpty()) {
			Area cur = pq.poll();
			if(!visit[cur.no]) visit[cur.no] = true;
			else continue;
			
			for(Area next : adj[cur.no]) {
				int tmp = next.length + dist[i][cur.no];
				if(dist[i][next.no] > tmp) {
					dist[i][next.no] = tmp;
					pq.add(new Area(next.no, dist[i][next.no]));
				}
			}
		}
	}
	
}
