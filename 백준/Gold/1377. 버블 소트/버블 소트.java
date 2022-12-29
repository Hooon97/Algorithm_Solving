import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		mData[] A = new mData[N];
		for(int i = 0; i<N; i++) {
			A[i] = new mData(Integer.parseInt(br.readLine()), i);
		}
		Arrays.sort(A); // 시간 복잡도는 O(nlogn)
		int Max = 0;
		for(int i = 0; i<N; i++) {
			if(Max < A[i].index - i) Max = A[i].index - i;
		}
		System.out.println(Max+1);
	}
	
}
	/*
	 * 사용자 정의 class를 class 내부에 선언하려면 static을 선언해야 하고, 아니면 안해줘도 된다.
	 */
	class mData implements Comparable<mData> {
	int value;
	int index;
	public mData(int value, int index) {
		super();
		this.value = value;
		this.index = index;
	}
	@Override
	public int compareTo(mData o) { // value 기준 오름차순 정렬
		return this.value - o.value;
	}
}