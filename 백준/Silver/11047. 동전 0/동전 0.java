import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int sum = sc.nextInt();
		int[] pennies = new int[N];
		for(int i = 0; i<N; i++) pennies[i] = sc.nextInt();
		int cnt = 0;
		for(int i = N-1; i>=0; i--) {
			if(pennies[i] > sum) continue;
			else {
				cnt += sum/pennies[i];
				sum %= pennies[i];
			}
		}
		System.out.print(cnt);
		sc.close();
	}
}
