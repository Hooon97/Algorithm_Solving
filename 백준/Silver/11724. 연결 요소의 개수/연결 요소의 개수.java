import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static ArrayList<Integer>[] A;
	static boolean visited[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()); 
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		A = new ArrayList[n+1];
		visited = new boolean[n+1];
		for(int i = 1; i<n+1; i++) {
			A[i] = new ArrayList<Integer>();
		}
		for(int i = 0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			A[s].add(e);
			A[e].add(s);
		}
		int count = 0;
		for(int i = 1; i<n+1; i++) {
			if(!visited[i]) { //시작 노드를 거쳐갔었는지 확인
				count++; // 개수 세기
				DFS(i); // dfs 함수 호출하기 -> 재귀적으로 구성할 것
			}
		}
		System.out.print(count);
	}
	static void DFS(int v) {
		if(visited[v]) return; //거쳐간 엣지는 더 이상 진행하지 않음
		visited[v] = true; //다녀간 곳으로 표시하기
		for(int i : A[v]) { // 향상된 for문
			if(visited[i] == false) DFS(i); //다녀가지 않았던 곳만 탐색하기
		}
	}
}
