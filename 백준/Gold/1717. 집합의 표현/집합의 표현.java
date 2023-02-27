import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main{
	static int[] sets;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.valueOf(st.nextToken());
		int M = Integer.valueOf(st.nextToken());
		sets = new int[N+1];
		for(int i = 0; i<N+1; i++) sets[i] = i;
		for(int i = 0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int cal = Integer.valueOf(st.nextToken());
			int num1 = Integer.valueOf(st.nextToken());
			int num2 = Integer.valueOf(st.nextToken());
			switch(cal) {
			case 0 : Union(num1, num2);
				break;
			case 1 : 
				if(Find(num1) == Find(num2))
					sb.append("YES\n");
				else
					sb.append("NO\n");
				break;
			}
		}
		System.out.print(sb.toString());
	}
	static void Union(int num1, int num2) {
		num1 = Find(num1);
		num2 = Find(num2);
		if(num1 != num2) {
			sets[num2] = num1;
		}
	}
	static int Find(int num1) {
		if(num1 == sets[num1]) return num1;
		else return sets[num1] = Find(sets[num1]);
	}
}
