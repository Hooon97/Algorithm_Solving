import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int N;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//한 자리 수에서 소수는 2,3,5,7 뿐이다. 자리수별 소수 조건을 걸어줘서 백트래킹 하기
		N = Integer.parseInt(br.readLine());
		//한 자리에서 소수인 것부터 탐색
		DFS(2,1);
		DFS(3,1);
		DFS(5,1);
		DFS(7,1);
	}
	static void DFS(int number, int J) {
		//해당 자리수에 도달하면
		if(J == N) {
			if(isPrime(number)) System.out.println(number);
			return;
		}
		for(int i = 1; i<10; i++) {
			if( i % 2 == 0) continue; //소수가 아님
			if(isPrime(number*10+i)) DFS(number * 10 +i, J+1);
		}
	}
	static boolean isPrime(int num) {
		for(int i = 2; i*i<=num; i++) {
			if(num%i == 0) return false;
		}
		return true;
	}
}
