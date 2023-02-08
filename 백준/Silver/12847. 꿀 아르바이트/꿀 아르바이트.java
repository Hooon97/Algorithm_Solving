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
		int N = Integer.valueOf(st.nextToken()); //총 일 수
		int M = Integer.valueOf(st.nextToken());
		long sumMoney = 0;
		long max = 0;
		int[] salary = new int[N+1];
		st = new StringTokenizer(br.readLine());
		
		for(int i = 1; i<N+1; i++) salary[i] = Integer.valueOf(st.nextToken());
		for(int i = 1; i<M+1; i++) sumMoney += salary[i];
		max = sumMoney;
		for(int i = M+1; i<N; i++) {
			sumMoney += salary[i]-salary[i-M];
			max = sumMoney > max ? sumMoney : max; 
		}
		System.out.print(max);
	}
}
