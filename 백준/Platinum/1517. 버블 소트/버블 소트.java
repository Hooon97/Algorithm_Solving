import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static int[] A, tmp;
	public static long result;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		A = new int[N+1];
		tmp = new int[N+1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 1; i<=N; i++)A[i] = Integer.parseInt(st.nextToken());
		result = 0;
		mergeSort(1,N);
		System.out.print(result);
	}
	
	private static void mergeSort(int s, int e) {
		if( e - s < 1) return;
		int m = s+(e-s)/2;
		
		mergeSort(s,m);
		mergeSort(m+1,e);
		for(int i = s; i<=e; i++) tmp[i] = A[i];
		int k = s; //두 배열의 전체를 돌면서 확인할 인덱스
		int index1 = s; //첫번째 배열 시작점
		int index2 = m+1; //두번째 배열 시작점
		
		while(index1 <= m && index2 <= e) {
			if(tmp[index1] > tmp[index2]) {
				A[k] = tmp[index2];
				k++;
				index2++; //얘까 더 작은 인덱스이므로 지나가면 됨
				result = result + index2-k; //오른쪽(뒤 쪽) 데이터가 더 작으므로, switch가 일어난 걸로 인식
			}
			else {
				A[k] = tmp[index1];
				k++;
				index1++;
			}
		}
		while(index1 <= m) {
			A[k] = tmp[index1];
			k++;
			index1++;
		}
		while(index2 <= e) {
			A[k] = tmp[index2];
			k++;
			index2++;
		}
	}
}
