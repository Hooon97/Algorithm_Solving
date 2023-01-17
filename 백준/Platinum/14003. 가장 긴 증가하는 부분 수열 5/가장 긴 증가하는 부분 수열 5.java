import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, maxLength;
	static int[] B = new int[1000001];
	static int[] A = new int[1000001];
	static int[] D = new int[1000001];
	static int[] ans = new int[1000001];
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 1; i<=N; i++) A[i] = Integer.parseInt(st.nextToken());
		B[++maxLength] = A[1];
		D[1] = 1;
		int index = 0;
		for(int i = 2; i<=N; i++) {
			if(B[maxLength] < A[i]) {
				B[++maxLength] = A[i];
				D[i] = maxLength;
			}
			else {
				index = binarySearch(1, maxLength, A[i]);
				B[index] = A[i];
				D[i] = index;
			}
		}
		
		sb.append(maxLength+"\n");
		index = maxLength;
		int x = B[maxLength] + 1;
		for(int i = N; i >= 1; i--) {
			if(D[i] == index && A[i] < x) {
				ans[index] = A[i];
				x = A[i];
				index--;
			}
		}
		for(int i = 1; i<= maxLength; i++) {
			sb.append(ans[i]+" ");
		}
		System.out.println(sb.toString());
	}
	static public int binarySearch(int l, int r, int row) {
		int mid;
		while(l<r) {
			mid = (r+l)/2;
			if(B[mid] < row)l = mid + 1;
			else r = mid;
		}
		return l;
	}
}
