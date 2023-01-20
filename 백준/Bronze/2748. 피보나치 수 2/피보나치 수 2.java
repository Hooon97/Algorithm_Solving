import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		long[] sum = new long[N+1];
		sum[1] = 1;
		for(int i = 2; i<=N; i++) {
			sum[i] = sum[i-1] + sum[i-2];
		}
		System.out.println(sum[N]);
		sc.close();
	}
}
