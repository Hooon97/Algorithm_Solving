import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main{
	static int[] parents;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.valueOf(st.nextToken());
		int M = Integer.valueOf(st.nextToken());
		parents = new int[N];
		int ans = 0;
		for(int i = 0; i<N; i++) parents[i] = i;
		for(int i = 1; i<M+1; i++) {
			st = new StringTokenizer(br.readLine());
			int dot1 = Integer.valueOf(st.nextToken());
			int dot2 = Integer.valueOf(st.nextToken());
			if(Find(dot1) == Find(dot2)) {
				ans = i;
				break;
			}
			Union(dot1, dot2);
		}
		System.out.print(ans);
	}
	static void Union(int dot1, int dot2) {
		dot1 = Find(dot1);
		dot2 = Find(dot2);
		if(dot1 != dot2)
			parents[dot2] = dot1;
	}
	static int Find(int dot) {
		if(dot == parents[dot]) return dot;
		else {
			return parents[dot] = Find(parents[dot]);
		}
	}
}
