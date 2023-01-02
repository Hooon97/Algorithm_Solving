import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][] A = new int[N][2];
		for(int i = 0; i<N; i++) {
			A[i][0] = sc.nextInt(); //시작 시간
			A[i][1] = sc.nextInt(); //종료 시간
		}
		Arrays.sort(A, new Comparator<int[]>() {
			@Override
			public int compare(int[] S, int[] E) {
				if(S[1] == E[1]) return S[0] - E[0];
				else return S[1] - E[1];
			}
		});
		
		int count = 0;
		int end = -1;
		for(int i = 0; i<N; i++) {
			if(A[i][0] >= end) {
				end = A[i][1];
				count++;
			}
		}
		System.out.println(count);
		sc.close();
	}
}
