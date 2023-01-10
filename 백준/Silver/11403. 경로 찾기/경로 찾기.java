import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[][] distance;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());
		distance = new int[N][N];
		for(int i = 0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j<N; j++) {
				int v = Integer.parseInt(st.nextToken());
				distance[i][j] = v;
			}
		}
		
		//변형된 플로이드-워셜 알고리즘
		//여기서 k는 중간에 거쳐가는 노드를 뜻함
		for(int k = 0; k<N; k++) { // 모든 노드에 대하여
			for(int i = 0; i<N; i++) { // 시작 노드
				for(int j = 0; j<N; j++) { // 종료 노드
					if(distance[i][k] == 1 && distance[k][j] == 1) distance[i][j] = 1;
				}
			}
		}
		
		for(int i = 0; i<N; i++) {
			for(int j = 0; j<N; j++) {
				sb.append(distance[i][j]+" ");
			}
			sb.append("\n");
		}
		System.out.print(sb.toString());
	}
}
