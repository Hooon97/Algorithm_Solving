import java.util.Scanner;

public class Main {
	//B[k]는 k번째 작은 수를 의미한다.
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int k = sc.nextInt();
		long start = 1, end = k;
		long ans = 0;
		//이진 탐색
		while(start <= end) {
			long middle = (start+end)/2;
			long cnt = 0;
			
			for(int i = 1; i<=N; i++) {
				cnt += Math.min(middle/i, N);
			}
			if(cnt < k) start = middle + 1;
			else {
				ans = middle;
				end = middle - 1;
			}
		}
		System.out.print(ans);
		sc.close();
	}
}
