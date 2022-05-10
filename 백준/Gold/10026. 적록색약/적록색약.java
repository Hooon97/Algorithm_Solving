import java.util.Scanner;

public class Main {
	static char[][] maps;
	static int T;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static boolean[][] visit;
	static int normalCnt;
	static int abnormalCnt;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		maps = new char[T][T];
		visit = new boolean[T][T];
		normalCnt = 0;
		abnormalCnt = 0;
		for (int i = 0; i < T; i++) {
			String tmp = sc.next();
			maps[i] = tmp.toCharArray();
		}

		for (int i = 0; i < T; i++) {
			for (int j = 0; j < T; j++) {
				if (!visit[i][j]) {
					normalDfs(i, j, maps[i][j]);
					normalCnt++;
				}
			}
		}
		for(int i = 0; i<T; i++) {
			for(int j = 0; j<T; j++) {
				visit[i][j] = false;
			}
		}
		

		for (int i = 0; i < T; i++) {
			for (int j = 0; j < T; j++) {
				if (!visit[i][j]) {
					char tmp = maps[i][j];
					if(tmp == 'R' || tmp == 'G')
						abnormalDfs(i, j, maps[i][j]);
					else
						normalDfs(i,j,maps[i][j]);
					abnormalCnt++;
				}
			}
		}
		System.out.print(normalCnt+" "+abnormalCnt);
		sc.close();
	}

	public static void normalDfs(int i, int j, char clr) {
		if(maps[i][j] == clr) {
			visit[i][j] = true;
		}
		
		for(int t = 0; t<4; t++) {
			int drs = i + dr[t];
			int dcs = j + dc[t];
			if(drs < 0 || drs >=T || dcs <0 || dcs>=T || visit[drs][dcs] || maps[drs][dcs] != clr) continue;
			normalDfs(drs,dcs, clr);
		}
	}

	public static void abnormalDfs(int i, int j, char clr) {
		visit[i][j] = true;
		for(int t = 0; t<4; t++) {
			int drs = i + dr[t];
			int dcs = j + dc[t];
			if(drs < 0 || drs >=T || dcs <0 || dcs>=T || visit[drs][dcs] || maps[drs][dcs] == 'B') continue;
			abnormalDfs(drs,dcs, clr);
		}
	}
}
