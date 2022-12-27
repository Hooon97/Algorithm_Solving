import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // 숫자의 개수
		int M = sc.nextInt(); // 숫자의 합
		int[] nums = new int[N]; //입력된 숫자들
		int ans = 0;
		for(int i = 0; i<N; i++) nums[i] = sc.nextInt();
		Arrays.sort(nums); //미정렬시 모든 경우의 수 탐색해야됨
		
		for(int i = 0; i<N-1; i++) {
			if(nums[i] > M) break;
			for(int j = i+1; j<N; j++) {
				if(nums[i]+nums[j] == M) {
					ans++;
					break;
				}
				else if(nums[i]+nums[j] > M) break;
			}
		}
		
		System.out.print(ans);
		sc.close();
	}
}
