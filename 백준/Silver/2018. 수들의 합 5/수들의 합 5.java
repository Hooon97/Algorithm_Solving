import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		int st_idx = 1;
		int ed_idx = 1;
		int sum = 1;
		int ans = 1; // 자기 자신
		//투포인터
		while(ed_idx != N) {
			if(sum == N) {
				ans++;
				ed_idx++;
				sum += ed_idx;
			}
			else if(sum < N) {
				//늘려야 하므로,
				ed_idx++;
				sum += ed_idx;
			}
			else {
				//큰 경우는 줄여야 함
				sum -= st_idx;
				st_idx++;
			}
		}
		System.out.print(ans);
		
	}
}
