import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main{
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		br.readLine();
		String[] arrA = br.readLine().split(" ");
		String[] arrB = br.readLine().split(" ");
		
		
		int idxA = 0;
		int idxB = 0;
		while(idxA < arrA.length && idxB < arrB.length) {
			int curA = Integer.valueOf(arrA[idxA]);
			int curB = Integer.valueOf(arrB[idxB]);
			if(curA <= curB) {
				sb.append(curA+" ");
				idxA++;
			}
			else {
				sb.append(curB+" ");
				idxB++;
			}
		}
		
		//A 배열을 다 돌지 못했다면
		if(idxA != arrA.length) {
			while(idxA < arrA.length) {
				sb.append(arrA[idxA++]+" ");
			}
		}
		else if(idxB != arrB.length) {//B배열을 다 돌지 못했다면
			while(idxB < arrB.length) {
				sb.append(arrB[idxB++]+" ");
			}
		}
		
		System.out.print(sb.toString());
	}
}
