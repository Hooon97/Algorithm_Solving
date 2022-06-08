import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static class Pos{
		int num;
		String ord;
		Pos(int num, String ord){
			this.num = num;
			this.ord = ord;
		}
	}
	public static String[] order = {"D","S","L","R"};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		Queue<Pos> q = new LinkedList<>();
		int T = sc.nextInt();
		
		for(int tc = 0; tc<T; tc++) {
			boolean[] visit = new boolean[10000];
			q.clear();
			int st = sc.nextInt();
			int ed = sc.nextInt();
			q.add(new Pos(st, ""));
			visit[st] = true;
			
			while(!q.isEmpty()) {
				Pos cur = q.poll();
				String nextOd = cur.ord;
				int nextNum = cur.num;
				if(cur.num == ed) {
					sb.append(cur.ord+"\n");
					break;
				}
				for(int i = 0; i<4; i++) {
					String od = order[i];
					int next = 0;
					switch(od) {
					case "D" : next = (nextNum * 2) % 10000;
					if(!visit[next]) {
						visit[next] = true;
						q.add(new Pos(next,nextOd+"D"));
					}
					break;
					case "S" :
						next = (nextNum == 0) ? 9999 : nextNum-1;
						if(!visit[next]) {
							visit[next] = true;
							q.add(new Pos(next, nextOd+"S"));
						}
						break;
					case "L" :
						next = (nextNum) / 1000 + (nextNum % 1000) * 10;
						if(!visit[next]) {
							visit[next] = true;
							q.add(new Pos(next,nextOd+"L"));
						}
						break;
					case "R" :
						next = (nextNum) / 10 + ((nextNum % 10) * 1000);
						if(!visit[next]) {
							visit[next] = true;
							q.add(new Pos(next, nextOd+"R"));
						}
						break;
					}
					
				}
			}
		}
		System.out.println(sb);
		
		sc.close();
	}
}
