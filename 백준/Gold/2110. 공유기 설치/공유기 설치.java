import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main{
	static int[] homes;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.valueOf(st.nextToken()); // 집의 갯수
		int M = Integer.valueOf(st.nextToken()); // 공유기의 개수
		homes = new int[N];
		for(int i = 0; i<N; i++) homes[i] = Integer.valueOf(br.readLine());
		
		Arrays.sort(homes);
		//기준 : 라우터 사이의 최소 거리
		int left = 1;
		int right = homes[N-1] - homes[0];
		
		while(left <= right) {
			int mid = (left + right)/2;
			int count = Count(mid);
			if(count < M) {
				right = mid - 1;
			}
			else {
				left = mid + 1;
			}
		}
		System.out.print(right);
	}
	private static int Count(int mid) {
		int count = 1;
		int left = 0;
		int right = 0;
		while(right < homes.length) {
			if(homes[right] - homes[left] >= mid) {
				count++;
				left = right;
				right++;
			}
			else {
				right++;
			}
		}
		
		return count;
	}
}
