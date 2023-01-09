import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N,M;
	static int[][] distance;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(br.readLine()); // 도시의 개수
		M = Integer.parseInt(br.readLine()); // 버스의 개수
		distance = new int[N+1][N+1];
		for(int i = 1; i<=N; i++) {
			for(int j = 1; j<=N; j++) {
				if(i==j) distance[i][j] = 0;
				else distance[i][j] = 10000001;
			}
		}
		
		for(int i = 0; i<M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			if(distance[s][e] > v) distance[s][e] = v;
		}
		
		//플로이드-워셜 알고리즘
		for(int k = 1; k<=N; k++) { //경유지 k
			for(int i = 1; i<=N; i++) { // 출발 노드
				for(int j = 1; j<=N; j++) { // 도착 노드
					if(distance[i][j] > distance[i][k] + distance[k][j])
						distance[i][j] = distance[i][k] + distance[k][j];
				}
			}
		}
		
		for(int i = 1; i<=N; i++) {
			for(int j = 1; j<=N; j++) {
				if(distance[i][j] == 10000001) sb.append(0+" ");
				else sb.append(distance[i][j]+" ");
			}
			sb.append("\n");
		}
		
		System.out.print(sb.toString());
	}
}
