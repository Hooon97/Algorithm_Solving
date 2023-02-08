import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main{
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		int N = Integer.valueOf(st.nextToken());
		int M = Integer.valueOf(st.nextToken());
		st = new StringTokenizer(br.readLine());
		
		int[] nums = new int[N];
		for(int i = 0; i<N; i++) nums[i] = Integer.valueOf(st.nextToken());
		int ans = 0;
		int stIdx = 0;
		int edIdx = 0;
		long sum = 0;
		while(stIdx < N) {
			if(sum == M) ans++;
			if(sum > M || edIdx == N) {
				sum -= nums[stIdx++];
			}
			else sum += nums[edIdx++];
		}
		
		System.out.print(ans);
	}
}
