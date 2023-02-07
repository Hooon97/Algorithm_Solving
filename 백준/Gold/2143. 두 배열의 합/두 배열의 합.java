import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main{
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int target = Integer.valueOf(br.readLine().trim());
		
		//A, B 배열 입력 받으면서 누적합 배열 생성
		int N = Integer.valueOf(br.readLine().trim());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arrA = new int[N+1];
		for(int i = 1; i<N+1; i++) arrA[i] = arrA[i-1] + Integer.valueOf(st.nextToken());
		
		int M = Integer.valueOf(br.readLine().trim());
		int[] arrB = new int[M+1];
		st = new StringTokenizer(br.readLine());
		for(int i = 1; i<M+1; i++) arrB[i] = arrB[i-1] + Integer.valueOf(st.nextToken());
		
		//N개와 M개의 숫자가 있을 때 가능한 부분합의 개수는 N~1 까지의 합. 즉, (n)(n+1)/2
		long[] partSumA = new long[N*(N+1)/2];
		long[] partSumB = new long[M*(M+1)/2];
		
		//부분합 배열에 값 입력해주기
		int idx = 0;
		for(int i = 1; i<N+1; i++) {
			for(int j = 0; j<i; j++) {
				partSumA[idx++] = arrA[i] - arrA[j];
			}
		}
		
		idx = 0;
		for(int i = 1; i<M+1; i++) {
			for(int j = 0; j<i; j++) {
				partSumB[idx++] = arrB[i] - arrB[j];
			}
		}
		
		//정렬
		Arrays.sort(partSumB);
		long ans = 0;
		for(int i = 0; i<partSumA.length; i++) {
			//이진 탐색
			long res = target - partSumA[i];
			
			int left = 0;
			int right = partSumB.length-1;
			int start = 0;
			
			while(left <= right) {
				int mid = (left+right)/2;
				if(partSumB[mid] <= res) {
					//오른쪽에 위치할거란 뜻
					left = mid+1;
				}
				else {
					//mid보다 왼쪽에 존재할거란 뜻
					right = mid-1;
				}
			}
			start = right;
			
			int end = 0;
			left = 0;
			right = partSumB.length-1;
			while(left <= right) {
				int mid = (left+right)/2;
				if(partSumB[mid] >= res) {
					right = mid - 1;
				}
				else left = mid + 1;
			}
			end = right;
			
			
			ans += start - end;
		}
		
		System.out.print(ans);
	}
}
