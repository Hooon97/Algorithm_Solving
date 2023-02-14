import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main{
	static int[] nums;
	static long[] partSum;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.valueOf(br.readLine());
		nums = new int[N+1];
		partSum = new long[N+1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 1; i<N+1; i++) {
			nums[i] = Integer.valueOf(st.nextToken());
			partSum[i] += nums[i]+partSum[i-1];
		}
		Arrays.sort(nums);
		int budget = Integer.valueOf(br.readLine());
		int ans = 0;
		int left = nums[0];
		int right = nums[N];
		long sum = 0;
		while(left <= right) {
			ans = (left+right)/2;
			sum = 0;
			for(int i = 1; i<N+1; i++) {
				if(ans >= nums[i]) sum += nums[i];
				else if(ans < nums[i]) sum += ans;
			}
			if(sum > budget) {
				right = ans - 1;
			}
			else if(sum < budget) {
				left = ans + 1;
			}
			else {
				right = ans;
				break;
			}
		}
		System.out.print(right);
	}

}
