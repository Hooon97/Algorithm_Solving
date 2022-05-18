import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int T = sc.nextInt();
		int N = sc.nextInt();
		int[] nums = new int[T+1];
		for(int i = 1; i<=T; i++) {
			int cur = sc.nextInt();
			nums[i] = cur+nums[i-1]; // 누적합
		}
		for(int i = 0; i<N; i++) {
			int st = sc.nextInt();
			int ed = sc.nextInt();
			int ans = nums[ed]-nums[st-1];
			sb.append(ans+"\n");
		}
		System.out.print(sb.toString());
		sc.close();
	}
}
