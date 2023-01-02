import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // 동전 종류의 개수
		int K = sc.nextInt(); // 동전의 합
		int[] coin = new int[N];
		int count = 0;
		for(int i = 0; i<N; i++)
			coin[i] = sc.nextInt();
		for(int i = N-1; i>=0; i--) {
			int cur = coin[i];
			if(cur <= K) {
				count += K/cur;
				K = K % cur;
			}
		}
		System.out.println(count);
		sc.close();
	}
}
