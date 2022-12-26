import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // 숫자의 개수
		int M = sc.nextInt(); // 값의 합
		long[] sums = new long[N];
		sums[0] = sc.nextLong();
		for(int i = 1; i<N; i++) {
			sums[i] = sc.nextLong()+sums[i-1];
		}
		
		//포인트는 중첩 반복문을 쓰지 않는 것
		long[] res = new long[M];
		long ans = 0;
		for(int i = 0; i<N; i++) {
			int remainder = (int) (sums[i]%M);
			if(remainder == 0) ans++;
			res[remainder]++;
		}
		
		for(int i = 0; i<M; i++) {
			if(res[i] > 1)
			ans += res[i]*(res[i]-1)/2;
		}
		
		System.out.println(ans);
		sc.close();
	}
}

/* 최초의 코드 : 시간초과
*Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // 숫자의 개수
		int M = sc.nextInt(); // 값의 합
		long[] numbs = new long[N];
		long[] sums = new long[N+1];
		for(int i = 0; i<N; i++) {
			numbs[i] = sc.nextLong();
			sums[i+1] =sums[i]+numbs[i];
		}
		
		int cnt = 0;
		for(int i = 1; i<N+1; i++)
			for(int j = 0; j<i; j++)
				if((sums[i]-sums[j])%M == 0) cnt++;
		System.out.println(cnt);
*/