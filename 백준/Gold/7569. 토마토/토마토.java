import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static class Pos {
		int m;
		int n;
		int h;

		Pos(int m, int n, int h) {
			this.m = m;
			this.n = n;
			this.h = h;
		}
	}

	static int[] dr = { 1, -1, 0, 0, 0, 0 };
	static int[] dc = { 0, 0, 1, -1, 0, 0 };
	static int[] dh = { 0, 0, 0, 0, 1, -1 };
	static int cnt;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int M = sc.nextInt(); // 가로
		int N = sc.nextInt(); // 세로
		int H = sc.nextInt(); // 높이
		cnt = 0;
		int day = 0;
		int[][][] tomatoes = new int[N][M][H];
		Queue<Pos> q = new LinkedList<>(); // BFS 로 풀어보자.
		for (int h = 0; h < H; h++) {
			for (int n = 0; n < N; n++) {
				for (int m = 0; m < M; m++) {
					int cur = sc.nextInt();
					tomatoes[n][m][h] = cur;
					if (cur == 0)
						cnt++;
					if (cur == 1)
						q.add(new Pos(m, n, h));
				}
			}
		}

		while (!q.isEmpty()) {
			int size = q.size();
			day++;
			for (int s = 0; s < size; s++) {
				Pos cur = q.poll();
				for (int i = 0; i < 6; i++) {
					int dms = cur.m + dr[i];
					int dns = cur.n + dc[i];
					int dhs = cur.h + dh[i];
					if (dms < 0 || dms >= M || dns < 0 || dns >= N || dhs < 0 || dhs >= H)
						continue;
					if (tomatoes[dns][dms][dhs] == 0) {
						tomatoes[dns][dms][dhs] = 1; // 익었다
						cnt--; // 남은 안익은 토마토 개수
						q.add(new Pos(dms, dns, dhs));
					}
				}
			}
		}
		if ((cnt == 0 && day == 0) || cnt == 0)
			System.out.println(day-1);
		else
			System.out.println(-1);
		sc.close();
	}
}
