import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main{
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.valueOf(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] chemical = new int[N];
		for(int i = 0; i<chemical.length; i++) chemical[i] = Integer.valueOf(st.nextToken());
		Arrays.sort(chemical);
		
		
		int left = 0;
		int right = N-1;
		long sum = Long.MAX_VALUE;
		int ansLeft = 0;
		int ansRight = 0;
		while(left < right) {
		long cur = chemical[left] + chemical[right];
			if(Math.abs(cur) < sum) {
				sum = Math.abs(cur);
				ansLeft = chemical[left];
				ansRight = chemical[right];
			}
			if(cur > 0) right--;
			else left++;
		}
		
		System.out.print(ansLeft + " " + ansRight);
	}
}
