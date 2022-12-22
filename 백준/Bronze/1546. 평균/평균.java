import java.util.Scanner;

/*
 * TAG: 수학, 수식
 * A B C (A가 최고점) -> A/A*100, B/A*100, C/A*100
 * 수식이 (모든 값의 합/최고점)*100으로 수렴
 */
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int bestScr = 0; // 최고점
		double sum = 0; // 모든 값의 합
		
		for(int i = 0; i<N; i++) {
			int currentScr = sc.nextInt();
			if(bestScr < currentScr) bestScr = currentScr;
			sum += currentScr;
		}
		
		System.out.println(sum/bestScr*100/N);
		sc.close();
	}
}
