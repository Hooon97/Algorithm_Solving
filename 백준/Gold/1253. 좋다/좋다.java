import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] numb = new int[N];
		for(int i = 0; i<N; i++) numb[i] = sc.nextInt();
		Arrays.sort(numb);
		
		int cnt = 0;
		for(int i = 0; i<N; i++) {
			int find = numb[i]; // 검사할 숫자
			int stIdx = 0;
			int edIdx = N-1; 
			
			while(stIdx < edIdx) { // 투포인터 알고리즘
				long sum = numb[stIdx] + numb[edIdx];
				if(sum == find) { // 각 숫자가 find와 같은 수면 안됨
					if(stIdx != i && edIdx != i) {
						cnt++; // 다른 위치의 숫자일때만 가산
						break;
					}
					else if(stIdx == i) stIdx++;
					else if(edIdx == i) edIdx--;
				}
				else if(sum < find) stIdx++;
				else edIdx--;
			}
		}
		System.out.print(cnt);
		sc.close();
	}
}
