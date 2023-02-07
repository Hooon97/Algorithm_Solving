import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main{
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.valueOf(br.readLine().trim());
		int M = Integer.valueOf(br.readLine().trim());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] nums = new int[N];
		for(int i = 0; i<N; i++) nums[i] = Integer.valueOf(st.nextToken());
		
		//투포인터를 적용하려면 정렬이 되어있어야 함
		Arrays.sort(nums);
		int start = 0;
		int end = N-1;
		int ans = 0;
		while(start < end) {
			long sum = nums[start] + nums[end];
			if(sum == M) {
				ans++;
				end--;
				start++;
			}
			else if(sum < M) start++;
			else if(sum > M) end--;
		}
		
		System.out.print(ans);
	}
}
