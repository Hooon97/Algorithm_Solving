import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int[] parent;
	static PriorityQueue<pEdge> q;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 정점의 개수
		int E = Integer.parseInt(st.nextToken()); // 간선의 개수
		q = new PriorityQueue<pEdge>();
		parent = new int[N+1];
		for(int i = 0; i<N; i++) parent[i] = i;
		for(int i = 0; i<E; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			q.add(new pEdge(s,e,v));
		}
		
		int useEdge = 0;
		int result = 0;
		while(useEdge < N-1) {
			pEdge cur = q.poll();
			if(find(cur.s) != find(cur.e)) {
				union(cur.s, cur.e);
				result += cur.v;
				useEdge++;
			}
		}
		System.out.println(result);
	}
	
	public static void union(int a, int b) {
		a = find(a);
		b = find(b);
		if(a != b) {
			parent[b] = a;
		}
	}
	
	public static int find(int a) {
		if(a == parent[a]) return a;
		else return parent[a] = find(parent[a]);
	}
	
	static class pEdge implements Comparable<pEdge>{
		int s, e, v;
		pEdge(int s, int e, int v){
			this.s = s;
			this.e = e;
			this.v = v;
		}
		@Override
		public int compareTo(pEdge o) {
			return this.v-o.v; //value 값을 기준으로 오름차순 정렬
		}
	}
}
