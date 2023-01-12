import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int[] parent;
	static int N, sum;
	static PriorityQueue<lEdge> queue;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		
		queue = new PriorityQueue<lEdge>();
		for(int i = 0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			char[] tmpc = st.nextToken().toCharArray();
			for(int j = 0; j<N; j++) {
				int tmp = 0;
				if(tmpc[j] >= 'a' && tmpc[j] <= 'z') {
					tmp = tmpc[j] - 'a' + 1;
				}
				else if(tmpc[j] >= 'A' && tmpc[j] <= 'Z') {
					tmp = tmpc[j] - 'A' + 27;
				}
				sum += tmp;
				if(i != j && tmp != 0) queue.add(new lEdge(i,j,tmp));
			}
		}
		parent = new int[N];
		for(int i = 0; i<parent.length; i++) {
			parent[i] = i;
		}
		int useEdge = 0;
		int result = 0;
		while(!queue.isEmpty()) {
			lEdge now = queue.poll();
			if(find(now.s) != find(now.e)) {
				union(now.s, now.e);
				result += now.v;
				useEdge++;
			}
		}
		if(useEdge == N-1) System.out.println(sum - result);
		else System.out.println(-1);
	}

	static int find(int a) {
		if(a == parent[a]) return a;
		else return parent[a] = find(parent[a]);
	}
	static void union(int a, int b) {
		a = find(a);
		b = find(b);
		if(a != b) parent[b] = a;
	}
	
	static class lEdge implements Comparable<lEdge>{
		int s, e, v;
		lEdge(int s, int e, int v){
			this.s = s;
			this.e = e;
			this.v = v;
		}
		@Override
		public int compareTo(lEdge l) {
			return this.v-l.v;
		}
	}
}
