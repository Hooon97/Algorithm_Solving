import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
	static int N, M, T;
	static int[] trueth;
	static boolean[][] visit;
	static boolean[][] party;
	static boolean[] check;
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String tmp = br.readLine();
		StringTokenizer st = new StringTokenizer(tmp);
		
		N = Integer.parseInt(st.nextToken()); // 사람의 수
		M = Integer.parseInt(st.nextToken()); // 파티의 수
		tmp = br.readLine();
		st = new StringTokenizer(tmp);
		T = Integer.parseInt(st.nextToken()); // 진실을 아는 사람의 수
		
		trueth = new int[T]; //진실을 아는 사람들의 집합
		for(int i = 0; i<T; i++) {
			trueth[i] = Integer.parseInt(st.nextToken());
		}
		
		//idx가 파티의 번호, 값은 사람의 번호
		party = new boolean[51][51];
		check = new boolean[51];
		visit = new boolean[51][51];
		for(int i = 1; i<=M; i++) {
			tmp = br.readLine();
			st = new StringTokenizer(tmp);
			int partyNo = i; 
			int num = Integer.parseInt(st.nextToken());
			while(num --> 0) {
				party[partyNo][Integer.parseInt(st.nextToken())] = true;
			}
		}
		
		liar();
		
		int cnt = 0;
		for(int i = 1; i<= M; i++) {
			if(!check[i]) cnt++;
		}

		System.out.println(cnt);
		sc.close();
	}
	
	public static void liar() {
		Queue<Integer> q = new LinkedList<>();
		if(T < 1) return;
		else {
			for(int i = 0; i<T; i++) q.add(trueth[i]); // 진실을 아는 사람들 모두 q에 저장
		}
		while(!q.isEmpty()) {
			int tmp = q.poll();
			for(int i = 1; i<=50; i++) {
				if(party[i][tmp]) { //진실을 아는 사람이 파티에 참석해있으면
					check[i] = true; //해당 파티에서는 거짓말 못함
					visit[i][tmp] = true;
					for(int j = 1; j<=50; j++) {
						if(party[i][j] && !visit[i][j]) {//해당 파티에 참석한 사람들을 q에 담아서, 어느 파티에 참석했는지 조사해야함
							q.add(j);
							visit[i][j] = true;
						}
					}
				}
			}
		}
	}
}
