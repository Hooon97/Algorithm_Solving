import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main{
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.valueOf(br.readLine().trim());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] nums = new int[N];
		for(int i = 0; i<N; i++) nums[i] = Integer.valueOf(st.nextToken());
		Arrays.sort(nums);
		
		long ans = 0;
		for(int k = 0; k<N; k++) {
			int i = 0;
			int j = N-1;
			while(i<j) {
				long cur = nums[i] + nums[j];
				if(cur == nums[k]) {
					//합이 같아도 자기 자신이면 안됨
					if(i != k && j != k) {
						ans++;
						break;
					}
					else if(i == k) i++;
					else if(j == k) j--;
				}
				//더한 값이 더 작으면 크기를 키워야 함
				else if(cur < nums[k]) {
					i++;
				}
				//더한 값이 더 크면 크기를 작게해야 함
				else j--;
			}
		}
		System.out.print(ans);
	}
}
