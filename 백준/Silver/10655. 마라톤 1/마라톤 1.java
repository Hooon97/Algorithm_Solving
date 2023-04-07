import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main{
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.valueOf(br.readLine().trim());
		int[][] check_point = new int[N][2];
		int sum = 0;
		int ans = Integer.MAX_VALUE;
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		check_point[0][0] = Integer.valueOf(st.nextToken());
		check_point[0][1] = Integer.valueOf(st.nextToken());
		for(int i = 1; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			check_point[i][0] = Integer.valueOf(st.nextToken());
			check_point[i][1] = Integer.valueOf(st.nextToken());
			sum += Math.abs(check_point[i-1][0] - check_point[i][0])+Math.abs(check_point[i-1][1] - check_point[i][1]);
		}
		
		for(int i = 1; i<N-1; i++) {
			int cur = sum - calPlus(i, check_point) - calPlus(i+1, check_point);
			cur += Math.abs(check_point[i-1][0] - check_point[i+1][0])+Math.abs(check_point[i-1][1] - check_point[i+1][1]);
			ans = Math.min(ans, cur);
		}
		System.out.print(ans);
	}
	private static int calPlus(int i, int[][] point) {
		int result = Math.abs(point[i-1][0] - point[i][0])+Math.abs(point[i-1][1] - point[i][1]);
		return result;
	}
}

