import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {
	public static void main(String[] args) throws Exception{
		// 오름차순 정렬 후, 값을 어떻게 할 지 결정한다.
		// 만약 마이너스가 두 개 있다면, 서로 곱하는게 이득이다.
		// 만약 마이너스가 하나 있다면, 그냥 더하는게 이득이다.
		// 양수는 가장 큰 값끼리 곱하고, 1과 페어로 남으면 더하는게 이득이다.
		// 양수, 음수를 각각의 배열에 저장하고, ASC, DSC 정렬해준다.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.valueOf(br.readLine());
		PriorityQueue<Integer> positiveQueue = new PriorityQueue<>(Collections.reverseOrder());
		PriorityQueue<Integer> negativeQueue = new PriorityQueue<>();
		
		for(int i = 0; i<N; i++) {
			int tmp = Integer.valueOf(br.readLine());
			if(tmp > 0) {
				//양수
				positiveQueue.add(tmp);
			}
			else {
				//음수
				negativeQueue.add(tmp);
			}
		}
		
		BigInteger ans = BigInteger.ZERO;
		while(!positiveQueue.isEmpty()) {
			if(positiveQueue.size() >= 2) {
				long tmp1 = positiveQueue.poll();
				long tmp2 = positiveQueue.poll();
				if(tmp1 != 1 && tmp2 != 1)
					ans = ans.add(BigInteger.valueOf(tmp1).multiply(BigInteger.valueOf(tmp2)));
				else
					ans = ans.add(BigInteger.valueOf(tmp1)).add(BigInteger.valueOf(tmp2));
			}
			else {
				ans = ans.add(BigInteger.valueOf(positiveQueue.poll()));
			}
		}
		while(!negativeQueue.isEmpty()) {
			if(negativeQueue.size() >= 2) {
				ans = ans.add(BigInteger.valueOf(negativeQueue.poll()).multiply(BigInteger.valueOf(negativeQueue.poll())));
			}
			else {
				ans = ans.add(BigInteger.valueOf(negativeQueue.poll()));
			}
		}
		
		System.out.print(ans);
	}
}
