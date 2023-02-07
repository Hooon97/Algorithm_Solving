import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.valueOf(st.nextToken()); // 배열의 길이
		int S = Integer.valueOf(st.nextToken()); // 기준 값
		long[] sum = new long[N+1];
		st = new StringTokenizer(br.readLine());
		for(int i = 1; i<N+1; i++) {
			int cur = Integer.valueOf(st.nextToken());
			sum[i] = sum[i-1] + cur;
			if(cur >= S) {
				System.out.print(1);
				return;
			}
		}
		
		int leng = Integer.MAX_VALUE;
		int idx = 0;
		boolean first = false;
		for(int i = 1; i<N+1; i++) {
			//값을 순회하며 누적합이 최초로 S를 넘는 누적합이 있는지 확인하기
			if(!first && sum[i] >= S) {
				first = true;
			}
			//구간이 있다면, 1번부터 빼면서 S보다 작아지는 최초의 값 찾아내기
			//최초 인덱스 이 후로는 조건을 충족하지 않는 위치인 idx부터 다시 검사 
			while(first && idx < i) {
				long partSum = sum[i] - sum[idx];
				if(partSum < S) break;
				leng = Math.min(leng, i-idx);
				idx++;
			}
		}
		System.out.print(leng == Integer.MAX_VALUE ? 0 : leng);
	}
}
