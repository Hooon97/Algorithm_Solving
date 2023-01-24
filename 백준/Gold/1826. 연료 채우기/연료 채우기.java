import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception{
		// 현재 위치에서 남은 연료로 마을까지 도착할 수 있는지 검사
		// 된다면 답안 출력
		// 안된다면 갈 수 있는 주유소 중 가장 연료를 많이 채울 수 있는 곳에서 정차
		// 마을에 도달할 때 까지 검사
		// 만약 모든 주유소를 들렸음에도 도달하지 못한다면, -1 출력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.valueOf(br.readLine()); // 주유소의 개수
		stationInfo[] stationArr = new stationInfo[N];
		boolean[] visit = new boolean[N];
		long maxGas = 0;
		for(int i = 0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int pos = Integer.valueOf(st.nextToken()); // 위치
			int gas = Integer.valueOf(st.nextToken()); // 주유량
			stationArr[i] = new stationInfo(pos, gas);
			maxGas += gas;
		}
		StringTokenizer st = new StringTokenizer(br.readLine());
		int L = Integer.valueOf(st.nextToken()); // 마을까지 거리
		int P = Integer.valueOf(st.nextToken()); // 현재 주유량
		long curPos = P;
		int count = 0;
		Arrays.sort(stationArr);
		PriorityQueue<Integer> oilVolume = new PriorityQueue<>(Collections.reverseOrder()); 
		if(maxGas+P < L) System.out.print("-1");
		else {
			while(curPos < L) {
				//정차할 수 있는 주유소 저장
				for(int i = 0; i<N; i++) {
					if(stationArr[i].pos > curPos) break;
					if(visit[i]) continue;
					oilVolume.add(stationArr[i].gas);
					visit[i] = true;
				}
				//현재까지 거쳐온 주유소의 최대 주유량 검사 후 더하기
				if(curPos < L && !oilVolume.isEmpty()) {
					curPos += oilVolume.poll();
					count++;
				}
				else if(curPos < L && oilVolume.isEmpty()) { // 첫번째 주유소에 도착하지 못하는 경우
					count = -1;
					break;
				}
			}
		}
		System.out.print(count);
	}
	static private class stationInfo implements Comparable<stationInfo>{
		int pos;
		int gas;
		stationInfo(int pos, int gas){
			this.pos = pos;
			this.gas = gas;
		}
		
		@Override
		public int compareTo(stationInfo o) {
			return this.pos-o.pos;
		}
	}
}
