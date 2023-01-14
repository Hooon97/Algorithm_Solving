import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		long[][] D = new long[N+1][2]; //1의 자리를 기준으로 0, 1로 끝나는 이친수 개수를 저장하는 두 배열
		D[1][1] = 1; // 한자리 이친수는 1개
		D[1][0] = 0;
		for(int i = 2; i<=N; i++) {
			D[i][0] = D[i-1][1] + D[i-1][0];
			D[i][1] = D[i-1][0];
		}
		System.out.println(D[N][0] + D[N][1]);
		sc.close();
	}
}
