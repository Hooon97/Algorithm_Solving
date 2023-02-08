import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main{
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.valueOf(br.readLine());
		int[] nums = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i<N; i++) nums[i] = Integer.valueOf(st.nextToken());
		int X = Integer.valueOf(br.readLine());
		Arrays.sort(nums);
		
		int stIdx = 0;
		int edIdx = N-1;
		int ans = 0;
		while(stIdx < edIdx) {
			int cur = nums[stIdx] + nums[edIdx];
			if(cur == X) ans++;
			if(cur >= X) edIdx--;
			else stIdx++;
		}
		System.out.print(ans);
	}
}
