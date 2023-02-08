import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.StringTokenizer;
public class Main{
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.valueOf(st.nextToken());
		int X = Integer.valueOf(st.nextToken());
		int max = 0;
		int sum = 0;
		int count = 1;
		int[] visitor = new int[N+1];
		st = new StringTokenizer(br.readLine());
		for(int i = 1; i<N+1; i++) visitor[i] = Integer.valueOf(st.nextToken());
		
		//첫번째 슬라이드 크기 지정
		for(int i = 1; i<X+1; i++) sum += visitor[i];
		max = sum;
		for(int i = X+1; i<N+1; i++) {
			sum += visitor[i]-visitor[i-X];
			if(sum == max) {
				count++;
				max = sum;
			}
			else if(sum > max) {
				count = 1;
				max = sum;
			}
		}
		if(max == 0 && sum == 0) System.out.println("SAD");
		else if(max == 0){
			System.out.println(sum);
			System.out.print(count);
		}
		else {
			System.out.println(max);
			System.out.print(count);
		}
		
	}
}
