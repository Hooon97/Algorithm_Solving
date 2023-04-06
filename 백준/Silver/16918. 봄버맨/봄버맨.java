import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main{
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int R = Integer.valueOf(st.nextToken());
		int C = Integer.valueOf(st.nextToken());
		int T = Integer.valueOf(st.nextToken());
		char[][] map = new char[R][C];
		for(int i = 0; i<R; i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		if(T%2 == 0) {
			printWholeBoomb(R, C);
		}
		else if(T == 1) {
			printMap(map);
		}
		else if((T > 1 && T%4 == 3)) {
			ArrayList<int[]> A = new ArrayList<>();
			for(int i = 0; i<R; i++) {
				for(int j = 0; j<C; j++) {
					if(map[i][j] == 'O')
						A.add(new int[] {i,j});
					else
						map[i][j] = 'O';
				}
			}
			explode(map, A);
			printMap(map);
		}
		else if((T>1) && T%4 == 1) {
			ArrayList<int[]> A = new ArrayList<>();
			for(int i = 0; i<R; i++) {
				for(int j = 0; j<C; j++) {
					if(map[i][j] == 'O')
						A.add(new int[] {i,j});
					else
						map[i][j] = 'O';
				}
			}
			explode(map, A);
			A.clear();
			for(int i = 0; i<R; i++) {
				for(int j = 0; j<C; j++) {
					if(map[i][j] == 'O')
						A.add(new int[] {i,j});
					else
						map[i][j] = 'O';
				}
			}
			explode(map, A);
			printMap(map);
		}
	}
	private static void printWholeBoomb(int R, int C) {
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i<R; i++) {
			for(int j = 0; j<C; j++) {
				sb.append("O");
			}
			sb.append("\n");
		}
		System.out.print(sb.toString());
	}
	private static void printMap(char[][] map) {
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i<map.length; i++) {
			for(char c : map[i])
				sb.append(c);
			sb.append("\n");
		}
		System.out.print(sb.toString());
	}
	private static void explode(char[][] map, ArrayList<int[]> list){
		int[] dr = {1, 0, -1, 0};
		int[] dc = {0, 1, 0, -1};
		for(int[] A : list) {
			map[A[0]][A[1]] = '.';
			for(int p = 0; p<4; p++) {
				int drs = A[0]+dr[p];
				int dcs = A[1]+dc[p];
				if(drs < 0 || drs >= map.length || dcs < 0 || dcs >= map[0].length) continue;
				map[drs][dcs] = '.';
			}
		}
	}
}

