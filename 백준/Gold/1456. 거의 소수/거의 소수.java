import java.util.Scanner;


/*
 * A와 B사이의 값의 정수 제곱근이 있는지 확인하고, 소수인지 확인하는 방법이 있고,
 * B의 제곱근 이하의 숫자 중 소수를 추려내고 제곱하여 값을 확인하는 방법이 있다.
 * 후자의 방법을 사용할 것이다.
 */
public class Main {
	public static void main(String[] args){
		//(int)Math.sqrt(10)는 제곱근 이하의 가장 큰 정수를 반환한다.
		Scanner sc = new Scanner(System.in);
		long Min = sc.nextLong();
		long Max = sc.nextLong();
		long[] A = new long[10000001];
		for(int i = 2; i<A.length; i++) A[i] = i;
		for(int i = 2; i<=Math.sqrt(A.length); i++) {
			if(A[i] == 0) continue;
			for(int j = i+i; j<A.length; j = j+i) A[j] = 0; //배수 지우기
		}
		int count = 0;
		for(int i = 2; i<10000001; i++) {
			if(A[i] != 0) {
				long tmp = A[i];
				while((double)A[i] <= (double)Max/(double)tmp) {
					if((double)A[i] >= (double)Min/(double)tmp) count++;
					tmp = tmp * A[i];
				}
			}
		}
		System.out.println(count);
		sc.close();
	}
}
