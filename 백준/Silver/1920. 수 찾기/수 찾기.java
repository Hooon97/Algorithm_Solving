import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine()); // 수의 개수
		int[] A = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i<N; i++) A[i] = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		
		Arrays.sort(A);
		for(int i = 0; i<M; i++) {
			boolean find = false;
			int target = Integer.parseInt(st.nextToken());
			//이진 탐색
			int start = 0;
			int end = A.length-1;
			while(start <= end) {
				int midI = (start+end)/2;
				int midV = A[midI];
				if(midV > target) end = midI-1; // 현재 값이 찾고자 하는 값보다 작으면 왼쪽에 있을 것임 
				else if(midV < target) start = midI + 1; //값보다 크면 오른쪽에 있을 것임
				else {
					find = true;
					break;
				}
			}
			if(find) sb.append(1+"\n");
			else sb.append(0+"\n");
		}
		System.out.print(sb.toString());
		br.close();
	}
}
