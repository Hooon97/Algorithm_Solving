import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] nums = new int[1001];
		nums[1] = 1; nums[2] = 3;
		for(int i = 3; i<=1000; i++) nums[i] = (nums[i-1] + 2*nums[i-2])%10007;
		System.out.print(nums[sc.nextInt()]);
		
		sc.close();
	}
}
