import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception{
		// 현재 위치를 갱신시켜가며 조건 비교
		// 다음 쓰레기의 위치가 현재 내 위치의 x, y보다 크면 청소가 가능함
		// 청소된 위치는 다시 볼 필요 없으므로, visit 배열로 방문 체크를 함
		// LinkedList나 Queue를 이용해 poll()을 시도해보았으나
		// 이 경우 전체 사이즈 변화로 코드가 복잡해짐
		
		// for문에서 조건문을 반복 조건에 삽입하면, 말 그대로 조건에 맞지 않으면 종료한다..
		// 이걸 찾는데 두시간 걸렸다. 후...........
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.valueOf(st.nextToken());
		int M = Integer.valueOf(st.nextToken());
		int[][] map = new int[N][M];
		LinkedList<Pos> garbage = new LinkedList<>();
		
		for(int i = 0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j<M; j++) {
				int tmpMapElement = Integer.parseInt(st.nextToken());
				map[i][j] = tmpMapElement;
				if(tmpMapElement == 1) garbage.add(new Pos(i,j));
			}
		}
		
		int size = garbage.size();
		boolean[] visit = new boolean[size];
		int ans = 0;
		for(int i = 0; i<size; i++) {
			if(!visit[i]) {
				ans++;
				Pos cur = garbage.get(i);
				visit[i] = true;
				for(int j = i+1; j<size; j++) {
					if(!visit[j]) {
						Pos next = garbage.get(j);
						if(cur.x <= next.x && cur.y <= next.y) { //청소 가능한 경로면 방문처리
							cur = next;
							visit[j] = true;
						}
					}
				}
			}
		}
		
		System.out.print(ans);
	}
	static private class Pos{
		int x;
		int y;
		public Pos(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
