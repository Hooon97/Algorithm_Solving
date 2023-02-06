import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int N = Integer.valueOf(st.nextToken());//수의 개수
		int M = Integer.valueOf(st.nextToken());//구하는 횟수
		String[] nums = br.readLine().split(" ");
		int[] sums = new int[N+1];
		for(int i = 1; i<=N; i++) {
			sums[i] = sums[i-1] + Integer.valueOf(nums[i-1]); 
		}
		
		for(int i = 0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.valueOf(st.nextToken());
			int end = Integer.valueOf(st.nextToken());
			sb.append(sums[end]-sums[start-1]+"\n");
		}
		System.out.print(sb.toString());
	}
}
