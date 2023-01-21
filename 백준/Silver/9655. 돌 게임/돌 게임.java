import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		// 입력되는 값에 따라 이기는 사람은 무조건 정해져있다.
		// 뭔짓을 해도 정해져있으므로 최대한 빠르게 가자.
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		System.out.println(N%2==0 ? "CY" : "SK");
		sc.close();
	}
}
