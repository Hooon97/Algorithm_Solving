import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{
	static int[] nums;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.valueOf(br.readLine());
		nums = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i<N; i++) nums[i] = Integer.valueOf(st.nextToken());
		Arrays.sort(nums);
		
		int M = Integer.valueOf(br.readLine());
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i<M; i++) {
			sb.append(BinarySearch(Integer.valueOf(st.nextToken()))+" ");
		}
		System.out.print(sb.toString());
	}
	private static int BinarySearch(int target) {
		int left = 0;
		int right = nums.length-1;
		while(left <= right) {
			int mid = (left+right)/2;
			if(nums[mid] == target) return 1;
			if(nums[mid] > target) right = mid-1;
			else left = mid+1;
		}
		return 0;
	}
}
