import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

// 현재 상어 위치에서 먹을 수 있는 물고기를 찾는다.
// 물고기 중 dist가 가장 가까운 물고기를 저장한다.
// Priority Queue를 사용하여 정렬한다.
// 반복
public class Main {
	public static class Fish{
		int r;
		int c;
		int dist;
		Fish(int r, int c, int dist){
			this.r = r;
			this.c = c;
			this.dist = dist;
		}
	}
	
	public static class Shark{
		int r;
		int c;
		int size;
		int grow;
		Shark(int r, int c, int size, int grow){
			this.r = r;
			this.c = c;
			this.size = size; //상어 크기
			this.grow = grow; //먹은 양
		}
	}
	
	static PriorityQueue<Fish> pq;
	static Shark baby;
	static int N, time;
	static int[][] map;
	static boolean[][] visit;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		map = new int[N][N];
		visit = new boolean[N][N];
		for(int i = 0; i<N; i++) {
			for(int j = 0; j<N; j++) {
				int tmp = sc.nextInt();
				map[i][j] = tmp;
				//상어 위치 저장
				if(tmp == 9) {
					baby = new Shark(i,j,2,0);
				}
			}
		}
		
		//거리, 높이, 왼쪽 순으로 정렬한 우선순위 큐
		pq = new PriorityQueue<>(new Comparator<Fish>() {
			@Override
			public int compare(Fish o1, Fish o2) {
				if(o1.dist == o2.dist) // 거리가 같으면
					if(o1.r == o2.r) // 높이도 같으면
						return o1.c-o2.c; //왼쪽에 있는 순으로
					else
						return o1.r-o2.r;
				else
					return o1.dist-o2.dist;
			}});
		
		while(true) {
			
//			System.out.println("---------------------");
//			System.out.println("baby grow : "+baby.grow +" baby size : "+baby.size);
//			System.out.println("time : "+time);
//			for(int i = 0; i<N; i++) {
//				System.out.println(Arrays.toString(map[i]));
//			}
			
			findFish();
			if(pq.isEmpty()) {
				System.out.println(time);
				break;
			}
			else {
				Fish cur = pq.poll();
				Eat(cur.r, cur.c, cur.dist);
			}
		}
		sc.close();
	}
	
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	public static void findFish() {
		Queue<Fish> q = new LinkedList<>();
		q.add(new Fish(baby.r, baby.c, 0)); //시작 위치
		while(!q.isEmpty()) {

			
			Fish cur = q.poll();
			if(ableToEat(cur.r, cur.c)) {
				pq.add(cur);
			}
			
			//움직일 수 있는 모든 방향으로 
			for(int i = 0; i<4; i++) {
				int drs = cur.r+dr[i];
				int dcs = cur.c+dc[i];
				if(drs<0 || drs >=N || dcs < 0 || dcs>=N || visit[drs][dcs] || !ableToMove(drs, dcs)) continue;
				q.add(new Fish(drs,dcs,cur.dist+1));
				visit[drs][dcs] = true;
			}
		}
	}
	
	// 물고기의 크기가 상어보다 작은지 검사
	public static boolean ableToEat(int i, int j) {
		boolean flag = false;
		if(map[i][j] < baby.size && map[i][j] != 0 && map[i][j] != 9) flag = true;
		return flag;
	}
	
	//이동 가능한지 검사
	public static boolean ableToMove(int i, int j) {
		boolean flag = false;
		if(map[i][j] <= baby.size) flag = true;
		return flag;
	}
	
	public static void resetVisit() {
		for(int i = 0; i<N; i++) {
			for(int j = 0; j<N; j++) {
				visit[i][j] = false;
			}
		}
	}
	
	public static void Eat(int i, int j, int dist) {
		resetVisit();
		pq.clear();
		map[i][j] = 9; //먹었으니 해당 물고기 위치는 0이 됨
		map[baby.r][baby.c] = 0; //기존 상어 위치는 0 
		baby.r = i;
		baby.c = j; //상어 위치 갱신
		time += dist; //걸린 시간 갱신
		baby.grow += 1;
		if(baby.size == baby.grow) {
			baby.size++;
			baby.grow = 0;
		}
	}
	
}
