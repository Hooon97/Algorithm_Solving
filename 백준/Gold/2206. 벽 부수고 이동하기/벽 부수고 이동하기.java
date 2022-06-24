import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	 static class Node{
	        int r, c, cnt, crush;
	        Node(int r, int c, int cnt, int crush){
	            this.r = r;
	            this.c = c;
	            this.cnt = cnt;
	            this.crush = crush;
	        }
	    }
	    static int[] dr = {-1, 1, 0, 0};
	    static int[] dc = {0, 0, -1, 1};
	    static int N, M;
	    static int[][] map;
	    static boolean[][][] visited;
	    public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);
	        N = sc.nextInt();
	        M = sc.nextInt();
	        map = new int[N][M];
	        visited = new boolean[N][M][2];
	        for(int i = 0; i < N; i++) {
	            String str = sc.next();
	            for(int j = 0; j < M; j++)
	                map[i][j] = str.charAt(j) - '0';
	        }
	        Queue<Node> queue = new LinkedList<>();
	        queue.add(new Node(0,0,1,0));
	        visited[0][0][0] = true;
	        int ans = -1;
	        while( !queue.isEmpty()) {
	            Node n = queue.poll();
	            if( n.r == N-1 && n.c == M-1) {
	                ans = n.cnt;
	                break;
	            }
	            for(int d = 0; d < 4; d++) {
	                int nr = n.r + dr[d];
	                int nc = n.c + dc[d];
	                if(nr < 0 || nc < 0 || nr >= N || nc >= M)
	                    continue;
//	                //벽이 아닌 곳을 이동할때는 나의 상태에서 방문안했으면 ㄱ
	                if( map[nr][nc] == 0 && !visited[nr][nc][n.crush] ) {
	                    visited[nr][nc][n.crush] = true;
	                    queue.add(new Node(nr, nc, n.cnt+1, n.crush));
	                }
	                //벽을 깰때는, 내가 안깬상태여야 하고, 깬상태로 변경하면서 다음이동
	                if( map[nr][nc] == 1 && n.crush == 0 ) {
	                    visited[nr][nc][1] = true;
	                    queue.add(new Node(nr,nc, n.cnt + 1, 1));
	                }
	            }
	        }
	        System.out.println(ans);
	    }
}
