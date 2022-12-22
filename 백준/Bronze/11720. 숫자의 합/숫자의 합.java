import java.util.Scanner;

/*
 * TAG: 배열, 가산합
 */
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); //숫자의 개수
		String nums = sc.next();
		char[] numsChar = nums.toCharArray();

		long sol = 0;
		for(char data : numsChar)
			sol += data - '0'; // (char) 숫자는 0을 빼주면 정수로 변환됨 : 아스키코드
		System.out.println(sol);
		sc.close();
	}
}
