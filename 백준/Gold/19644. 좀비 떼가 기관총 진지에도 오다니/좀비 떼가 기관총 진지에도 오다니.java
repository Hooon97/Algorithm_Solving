import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	// 현재 위치 앞 스코프에서 풀뎀 - Bomb의 갯수
	public static void main(String[] args) throws Exception {
		int L, Ml, Mk, C, map[], Bomb;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		L = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		Ml = Integer.parseInt(st.nextToken());
		Mk = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(br.readLine());
		boolean flag = true;
		map = new int[L];
		boolean Bomber[] = new boolean[L];
		int start = -Ml + 1;
		int end = 0;
		Bomb = Ml - 1;
		int shootDam = 0;
		int fullDam = Mk * Ml;
		while (true) {
			map[end] = Integer.parseInt(br.readLine());
			shootDam = fullDam - Bomb * Mk;
			if (shootDam < map[end]) {
				if (--C < 0) {
					flag = false;
					break;
				}
				Bomb++;
				Bomber[end] = true;
			}
			if (start < 0 || Bomber[start]) {
				Bomb--;
			}
			start++;
			if (++end == L)
				break;
		}

		System.out.println(flag ? "YES" : "NO");
	}
}