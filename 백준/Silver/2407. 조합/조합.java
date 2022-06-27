import java.math.BigInteger;
import java.util.Scanner;

/**
 * 1. nCm = (n-1)C(m-1) + (n-1)Cm를 이용한 dp의 구현
 * 1.1 혹은 n!/((m! * (n-m)!)
 * 2. 수의 크기가 매우 크므로 BigInteger 이라는 class를 사용
 * @author HoonD
 *
 */
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		BigInteger mult = BigInteger.ONE;
		BigInteger div = BigInteger.ONE;
		
		for(int i = 0; i<m; i++) {
			mult = mult.multiply(new BigInteger(String.valueOf(n-i)));
			div = div.multiply(new BigInteger(String.valueOf(i+1)));
		}
		System.out.println(mult.divide(div));
		sc.close();
	}
}
