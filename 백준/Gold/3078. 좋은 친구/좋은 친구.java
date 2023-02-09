import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;
public class Main{
	public static void main(String[] args) throws Exception{
		//3078 좋은 친구
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.valueOf(st.nextToken());
		int K = Integer.valueOf(st.nextToken());
		long ans = 0;
		Queue<Integer>[] student = new LinkedList[21];
		for(int i = 2; i<21; i++) student[i] = new LinkedList<>();
		for(int i = 1; i<N+1; i++) {
			int leng = br.readLine().length();
			if(!student[leng].isEmpty()) {
				while(i-student[leng].peek() > K) {
					student[leng].poll();
					if(student[leng].isEmpty()) break;
				}
				ans += student[leng].size();
				student[leng].add(i);
			}
			else student[leng].add(i);
		}
		
		System.out.print(ans);
	}
}
