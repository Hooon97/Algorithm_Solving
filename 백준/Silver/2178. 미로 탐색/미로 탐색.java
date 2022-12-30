import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[] dx = {0, 1, 0, -1}; //x축 이동
	static int[] dy = {1, 0, -1, 0}; //y축 이동
	static boolean[][] visited;
	static int[][] A;
	static int N,M;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		visited = new boolean[N][M];
		A = new int[N][M];
		for(int i = 0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			String tmp = st.nextToken();
			for(int j = 0; j<M; j++) {
				A[i][j] = tmp.charAt(j) - '0';
			}
		}
		BFS(0,0); // (0,0)에서 시작하여 탐색
		System.out.print(A[N-1][M-1]);
	}
	static void BFS(int i, int j) {
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] {i,j});
		while(!queue.isEmpty()) {
			int[] cur = queue.poll();
			visited[i][j] = true;
			for(int k = 0; k<4; k++) { //상하좌우
				int x = cur[0] + dx[k];
				int y = cur[1] + dy[k];
				if( x >= 0 && y >= 0 && x < N && y < M) {
					if(A[x][y] != 0 && !visited[x][y]) {
						visited[x][y] = true;
						A[x][y] = A[cur[0]][cur[1]]+1;
						queue.add(new int[] {x,y});
					}
				}
			}
		}
	}
}
