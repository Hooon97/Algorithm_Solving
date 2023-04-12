import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{
	static int F, S, G;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		F = Integer.valueOf(st.nextToken()); // 전체 높이
		S = Integer.valueOf(st.nextToken()); // 현재 위치
		G = Integer.valueOf(st.nextToken()); // 목표 높이
		int U = Integer.valueOf(st.nextToken()); // 올라갈 수 있는 범위
		int D = Integer.valueOf(st.nextToken()); // 내려갈 수 있는 범위
		if(S < G && U == 0) {
			System.out.println("use the stairs");
			return;
		}
		else if(S > G && D == 0) {
			System.out.println("use the stairs");
			return;
		}
		int result = find(U,D);
		if(result < 0)
			System.out.println("use the stairs");
		else
			System.out.println(find(U,D));
		
	}
	public static int find(int U, int D) {
		Info info = new Info(0,S);
		PriorityQueue<Info> pq = new PriorityQueue<>();
		boolean[] visit = new boolean[F+1];
		pq.add(info);
		while(!pq.isEmpty()) {
			Info cur = pq.poll();
			if(cur.loca == G) {
				return cur.count;
			}
			
			if(visit[cur.loca]) continue;
			visit[cur.loca] = true;
			if(cur.loca+U <= F)
				pq.add(new Info(cur.count+1, cur.loca+U));
			if(cur.loca-D > 0)
				pq.add(new Info(cur.count+1, cur.loca-D));
		}
		return -1;
	}
}

class Info implements Comparable<Info>{
	int count;
	int loca;
	Info(int count, int loca){
		this.count = count;
		this.loca = loca;
	}
	public int compareTo(Info i) {
		return this.count - i.count;
	}
}
