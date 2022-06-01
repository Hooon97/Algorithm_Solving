import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static class Pos {
		int idx;
		int cnt;

		Pos(int idx, int cnt) {
			this.idx = idx;
			this.cnt = cnt;
		}
	}

	static int[] dice = { 1, 2, 3, 4, 5, 6 };
	static int[][] lag;
	static int[] map = new int[101];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		lag = new int[N + M][2];
		for (int i = 0; i < N + M; i++) {
			lag[i][0] = sc.nextInt();
			lag[i][1] = sc.nextInt();
		}
		Arrays.fill(map, Integer.MAX_VALUE);
		int ans = bfs();
		System.out.println(ans);
		sc.close();
	}

	public static int bfs() {
		int ans = 0;
		Queue<Pos> p = new LinkedList<>();
		p.add(new Pos(1, 0));
		while (!p.isEmpty()) {
			Pos cur = p.poll();
			if (cur.idx == 100) {
				ans = cur.cnt;
				break;
			}
			for (int i = 0; i < 6; i++) {
				int nextIdx = cur.idx + dice[i];
				// 주사위 이동 + 횟수 더해서 q에 넣기
				if (nextIdx <= 100) {
					if (move(nextIdx) == 0) {
						if (map[nextIdx] > cur.cnt + 1) {
							map[nextIdx] = cur.cnt + 1;
							p.add(new Pos(nextIdx, cur.cnt + 1));
						}
					} else {
						if (map[move(nextIdx)] > cur.cnt + 1) {
							map[move(nextIdx)] = cur.cnt + 1;
							p.add(new Pos(move(nextIdx), cur.cnt + 1));
						}
					}
				}
				else
					continue;
			}
		}
		return ans;
	}

	public static int move(int idx) {
		int flag = 0;
		for (int i = 0; i < lag.length; i++) {
			if (lag[i][0] == idx) {
				flag = lag[i][1];
				break;
			}
		}
		return flag;
	}
}
