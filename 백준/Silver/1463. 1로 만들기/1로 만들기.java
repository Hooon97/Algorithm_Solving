import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] D = new int[N+1]; // 배열 D는 연산 횟수가 저장된 배열
		D[1] = 0;
		for(int i = 2; i<=N; i++) {
			D[i] = D[i-1] + 1;
			if(i % 2 == 0) D[i] = Math.min(D[i], D[i/2]+1);
			if(i % 3 == 0) D[i] = Math.min(D[i], D[i/3]+1);
		}
		System.out.println(D[N]);
		sc.close();
	}
}
