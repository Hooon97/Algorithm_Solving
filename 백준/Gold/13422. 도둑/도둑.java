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
		StringBuilder sb = new StringBuilder();
		int T = Integer.valueOf(br.readLine());
		for(int t = 0; t<T; t++) {
			//기초 세팅
			StringTokenizer st = new StringTokenizer(br.readLine());
			int Home = Integer.valueOf(st.nextToken());
			int targetNum = Integer.valueOf(st.nextToken());
			int secure = Integer.valueOf(st.nextToken());
			int[] house = new int[Home];
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i<Home; i++) house[i] = Integer.valueOf(st.nextToken());
			
			
			//슬라이딩 윈도우
			int sumMoney = 0;
			int count = 0;
			//첫 윈도우 연산
			for(int i = 0; i<targetNum; i++) sumMoney += house[i];
			if(Home == targetNum) {
				if(sumMoney < secure) count = 1;
			}
			else {
				int i = 0;
				while(i<Home) {
					if(sumMoney<secure) count++;
					sumMoney += house[(i+targetNum)%Home]-house[i++];
				}
			}
			sb.append(count+"\n");
			}
			System.out.print(sb.toString());
	}
}
