import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main{
	static int N;
	static StringBuilder sb;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.valueOf(br.readLine());
		sb = new StringBuilder();
		DFS(1,2);
		DFS(1,3);
		DFS(1,5);
		DFS(1,7);
		System.out.print(sb.toString());
	}
	private static void DFS(int depth, int num) {
		if(depth == N) {
			sb.append(num+"\n");
			return;
		}
		for(int i = 1; i<10; i++) {
			if(i % 2 == 0) continue;
			int tmp = num*10 + i; 
			if(!isPrime(tmp)) continue;
			DFS(depth+1, tmp);
		}
	}
	private static boolean isPrime(int num) {
		for(int i = 2; i*i<=num; i++) {
			if(num % i == 0) return false;
		}
		return true;
	}
}
