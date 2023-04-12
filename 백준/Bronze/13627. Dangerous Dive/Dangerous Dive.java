import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.valueOf(st.nextToken());
		int M = Integer.valueOf(st.nextToken());
		st = new StringTokenizer(br.readLine());
		
		if(st.countTokens() == N) {
			System.out.println("*");
			return;
		}
		else {
			boolean[] checkSurv = new boolean[N+1];
			while(st.hasMoreTokens()) {
				checkSurv[Integer.valueOf(st.nextToken())] = true;
			}
			for(int i = 1; i<N+1; i++) {
				if(!checkSurv[i]) sb.append(i+" ");
			}
		}
		
		System.out.println(sb.toString());
	}
}

