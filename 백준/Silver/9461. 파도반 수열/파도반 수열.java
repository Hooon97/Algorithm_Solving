import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long[] val = new long[101];
		val[1] = val[2] = val[3] = 1;
		val[4] = val[5] = 2;
		for(int i = 6; i<= 100; i++) val[i] = val[i-1] + val[i-5];
		
		int T = sc.nextInt();
		for(int t = 0; t<T; t++) {
			int n = sc.nextInt();
			System.out.println(val[n]);
		}
		sc.close();
	}
}
