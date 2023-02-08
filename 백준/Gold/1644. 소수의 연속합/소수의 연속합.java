import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		if(N == 1) {
			System.out.print(0);
			return;
		}
		boolean[] filter = new boolean[N+1];
		ArrayList<Integer> atoms = new ArrayList<>();
		//소수 거르기
		for(int i = 2; i<N+1; i++) {
			int idx = 1;
			if(!filter[i]) {
				atoms.add(i);
				while(i*idx <= N) {
					filter[idx*i] = true;
					idx++;
				}
			}
		}
		
		int left = 0;
		int right = 0;
		int sum = 0;
		int count = 0;
		while(left < atoms.size()) {
			if(sum == N) {
				count++;
			}
			if(sum > N || right == atoms.size()) {
				sum -= atoms.get(left++);
			}
			else {
				sum += atoms.get(right++);
			}
		}
		
		System.out.print(count);
	}
}
