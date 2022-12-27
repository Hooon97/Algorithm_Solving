import java.util.Scanner;

/*
 * TAG: 투포인터
 * 앞에서부터 모든 경우의 수를 그리디로 탐색하고 싶을 때 사용하면 좋을듯..?
 */
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int st_idx = 1;
		int ed_idx = 1;
		int sum = 1;
		int cnt = 1; // ed_idx가 N일 때를 미리 카운트
		while(ed_idx != N) {
			if(sum == N) {
				cnt++;
				ed_idx++;
				sum += ed_idx;
			}
			else if(sum > N) {
				sum -= st_idx;
				st_idx++;
			}
			else {
				ed_idx++;
				sum += ed_idx;
			}
		}
		System.out.print(cnt);
		sc.close();
	}
}
