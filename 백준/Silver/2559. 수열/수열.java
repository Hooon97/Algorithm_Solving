import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.valueOf(st.nextToken());
		int K = Integer.valueOf(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int[] sums = new int[N+1];
		int[] newSums = new int[N-K+1];
		int ans = Integer.MIN_VALUE;
		for(int i = 1; i<N+1; i++) {
			sums[i] = sums[i-1] + Integer.valueOf(st.nextToken());
		}
		
		for(int i = 0; i<newSums.length; i++) {
			newSums[i] = sums[K+i] - sums[i];
			ans = Math.max(newSums[i], ans);
		}
		
		System.out.print(ans);
		
	}
}
