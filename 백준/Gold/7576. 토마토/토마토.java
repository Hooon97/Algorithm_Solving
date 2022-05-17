import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static class Tom {
		int r;
		int c;

		Tom(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	static int c, r, cnt, yet;
	static int[][] map;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static Queue<Tom> tom;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		c = sc.nextInt(); // 너비
		r = sc.nextInt(); // 높이
		map = new int[r + 2][c + 2];
		cnt = 0;
		yet = 0;
		// 벽치기
		for (int i = 0; i < r + 2; i++)
			for (int j = 0; j < c + 2; j++)
				map[i][j] = -1;
		tom = new LinkedList<>();
		// 입력받기
		for (int i = 1; i <= r; i++)
			for (int j = 1; j <= c; j++) {
				map[i][j] = sc.nextInt();
				if (map[i][j] == 1)
					tom.add(new Tom(i, j));
				else if(map[i][j] == 0)
					yet++;
			}
		

		perm();
		if (yet == 0) System.out.println(cnt);
		else System.out.println(-1);
			

		sc.close();
	}

	static void perm() {
//		if(isRipe()) 
//			return;
		while (!tom.isEmpty()) {
			if(yet == 0)
				return;
			int n = tom.size();
			for (int j = 0; j < n; j++) {
			Tom cur = tom.poll();
				for (int i = 0; i < 4; i++) {
					int nr = cur.r + dr[i];
					int nc = cur.c + dc[i];
					if (map[nr][nc] == -1 || map[nr][nc] == 1)
						continue;
					if (map[nr][nc] == 0) {
						map[nr][nc] = 1;
						tom.add(new Tom(nr, nc));
						yet--;
					}
				}
			}
			cnt++;
		}

	}

	static boolean isRipe() {
		boolean flag = true;

		for (int i = 1; i <= r; i++)
			for (int j = 1; j <= c; j++) {
				if (map[i][j] == 0) {
					// 익지 않은 부분이 있으면
					flag = false;
				}
			}
		return flag;
	}
}
