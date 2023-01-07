import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		ArrayList<ArrayList<dNode>> A = new ArrayList<>();
		ArrayList<ArrayList<dNode>> reverseA = new ArrayList<>();
		for(int i = 0; i<=N; i++) {
			A.add(new ArrayList<>());
			reverseA.add(new ArrayList<>());
		}
		int[] indegree = new int[N+1];
		for(int i = 0; i<M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int S = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());
			int V = Integer.parseInt(st.nextToken());
			A.get(S).add(new dNode(E,V));
			reverseA.get(E).add(new dNode(S,V));
			indegree[E]++;
		}
		StringTokenizer st = new StringTokenizer(br.readLine());
		int startCity = Integer.parseInt(st.nextToken());
		int endCity = Integer.parseInt(st.nextToken());
		
		//위상정렬
		Queue<Integer> q = new LinkedList<>();
		q.offer(startCity);
		int[] result = new int[N+1];
		while(!q.isEmpty()) {
			int cur = q.poll();
			for(dNode next : A.get(cur)) {
				indegree[next.targetNode]--;
				result[next.targetNode] = Math.max(result[next.targetNode], result[cur]+next.val);
				if(indegree[next.targetNode] == 0) q.offer(next.targetNode);
			}
		}
		
		//역 위상정렬
		int resultCount = 0;
		boolean visited[] = new boolean[N+1];
		q = new LinkedList<>();
		q.offer(endCity);
		visited[endCity] = true;
		while(!q.isEmpty()) {
			int cur = q.poll();
			for(dNode next : reverseA.get(cur)) {
				if(result[next.targetNode] + next.val == result[cur]) {
					resultCount++;
					if(!visited[next.targetNode]) {
						visited[next.targetNode] = true;
						q.offer(next.targetNode);
					}
				}
			}
		}
		System.out.println(result[endCity]);
		System.out.println(resultCount);
	}
}

class dNode{
	int targetNode;
	int val;
	dNode(int targetNode, int val){
		this.targetNode = targetNode;
		this.val = val;
	}
}
